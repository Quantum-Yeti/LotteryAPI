package me.theoria.lottery_api.service;

import me.theoria.lottery_api.model.LotteryDraw;
import me.theoria.lottery_api.repository.LotteryRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LotteryService {

    private final LotteryRepository repository;

    public LotteryService(LotteryRepository repository) {
        this.repository = repository;
    }

    public List<LotteryDraw> getAllDraws() {
        return repository.findAll();
    }

    public LotteryDraw save(LotteryDraw draw) {
        return repository.save(draw);
    }

    // Most frequent numbers (from all draws)
    public Map<String, Long> mostFrequentNumbers(int topN) {
        return repository.findAll().stream()
                .flatMap(draw -> Arrays.stream(draw.getNumbers().split(",")))
                .collect(Collectors.groupingBy(String::trim, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topN)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    // Average Powerball number
    public Double averagePowerball() {
        return repository.findAll().stream()
                .collect(Collectors.averagingInt(LotteryDraw::getPowerball));
    }

}
