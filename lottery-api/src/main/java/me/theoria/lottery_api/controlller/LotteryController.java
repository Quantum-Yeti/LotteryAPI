package me.theoria.lottery_api.controlller;

import me.theoria.lottery_api.model.LotteryDraw;
import me.theoria.lottery_api.service.LotteryCSVService;
import me.theoria.lottery_api.service.LotteryService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/lottery")
public class LotteryController {

    private final LotteryService lotteryService;
    private final LotteryCSVService lotteryCSVService;

    public LotteryController(LotteryService lotteryService, LotteryCSVService lotteryCSVService) {
        this.lotteryService = lotteryService;
        this.lotteryCSVService = lotteryCSVService;
    }

    @GetMapping("/draws")
    public List<LotteryDraw> getAllDraws() {
        return lotteryService.getAllDraws();
    }

    @GetMapping("/draws/latest")
    public LotteryDraw getLatestDraw() {
        return lotteryService.getAllDraws()
                .stream()
                .max(Comparator.comparing(LotteryDraw::getDrawDate))
                .orElse(null);
    }

    @GetMapping("/draws/range")
    public List<LotteryDraw> getDrawsByRange(
            @RequestParam("start") String startDate,
            @RequestParam("end") String endDate) {

        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        return lotteryService.getAllDraws()
                .stream()
                .filter(draw -> !draw.getDrawDate().isBefore(start) && !draw.getDrawDate().isAfter(end))
                .collect(Collectors.toList());
    }

    @GetMapping("/stats/numbers")
    public Map<String, Long> getTopNumbers(@RequestParam(defaultValue = "10") int topN) {
        return lotteryService.mostFrequentNumbers(topN);
    }

    @GetMapping("/stats/powerball")
    public Double getAveragePowerball() {
        return lotteryService.averagePowerball();
    }

    @PostMapping
    public String ingestCsv() throws Exception {
        lotteryCSVService.ingestCsv();
        return "OK";
    }

}
