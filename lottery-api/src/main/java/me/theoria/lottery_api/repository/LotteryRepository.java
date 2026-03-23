package me.theoria.lottery_api.repository;

import me.theoria.lottery_api.model.LotteryDraw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotteryRepository extends JpaRepository<LotteryDraw, Long> {
}
