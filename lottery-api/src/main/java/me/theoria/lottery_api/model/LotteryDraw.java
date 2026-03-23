package me.theoria.lottery_api.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class LotteryDraw {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate drawDate;
    private String numbers;
    private Integer powerball;

    // Required by JPA
    public LotteryDraw() {}

    public LotteryDraw(LocalDate drawDate, String numbers, Integer powerball) {
        this.drawDate = drawDate;
        this.numbers = numbers;
        this.powerball = powerball;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDrawDate() {
        return drawDate;
    }

    public void setDrawDate(LocalDate drawDate) {
        this.drawDate = drawDate;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public Integer getPowerball() {
        return powerball;
    }

    public void setPowerball(Integer powerball) {
        this.powerball = powerball;
    }
}