package me.theoria.lottery_api.controlller;

import me.theoria.lottery_api.service.LotteryCSVService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lottery")
public class LotteryCSVController {

    private final LotteryCSVService csvService;

    public LotteryCSVController(LotteryCSVService csvService) {
        this.csvService = csvService;
    }

    @PostMapping("/ingest")
    public String ingestCsv() {
        try {
            csvService.ingestCsv();
            return "CSV ingested successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error ingesting CSV: " + e.getMessage();
        }
    }
}