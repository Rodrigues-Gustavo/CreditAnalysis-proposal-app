package com.techgusta.creditAnalysis.service.strategy.impl;

import com.techgusta.creditAnalysis.constant.ConstantMessage;
import com.techgusta.creditAnalysis.domain.Proposal;
import com.techgusta.creditAnalysis.exceptions.StrategyException;
import com.techgusta.creditAnalysis.service.strategy.ScoreCalculation;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Order(2)
@Component
public class ScoreImpl implements ScoreCalculation {
    @Override
    public int calculate(Proposal proposal) {
        int score = score();

        if (score < 200) {
            throw new StrategyException(String.format(ConstantMessage.LOW_SERASA_SCORE, proposal.getUser().getName()));
        } else if (score <= 400) {
            return 150;
        } else if (score <= 600) {
            return 180;
        } else {
            return 220;
        }
    }

    private int score() {
        return new Random().nextInt(0,1000);
    }
}
