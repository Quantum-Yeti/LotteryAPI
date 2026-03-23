package me.theoria.lottery_api.service;

import jakarta.annotation.PostConstruct;
import me.theoria.lottery_api.model.LotteryDraw;
import me.theoria.lottery_api.repository.LotteryRepository;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Objects;

@Service
public class LotteryCSVService {

    private final LotteryRepository lotteryCSVRepository;

    public LotteryCSVService(LotteryRepository lotteryCSVRepository) {
        this.lotteryCSVRepository = lotteryCSVRepository;
    }

    @PostConstruct
    public void seedFileOnStartup() {
        try {
            ingestCsv();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ingestCsv() throws Exception {
        // Load CSV from resources
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(getClass().getResourceAsStream("/data/lottery.csv"))))) {

            // Skip header
            br.readLine();

            // Read each line
            br.lines().map(line -> {
                String[] parts = line.split(",");
                LocalDate date = LocalDate.parse(parts[0]);       // draw_date
                String numbers = parts[1];                        // numbers
                Integer powerball = Integer.parseInt(parts[2]);   // powerball
                return new LotteryDraw(date, numbers, powerball);
            }).forEach(lotteryCSVRepository::save);
        }

        System.out.println("CSV ingested successfully!");
    }

}
