package com.techgusta.creditAnalysis.service.strategy.impl;

import com.techgusta.creditAnalysis.constant.ConstantMessage;
import com.techgusta.creditAnalysis.domain.Proposal;
import com.techgusta.creditAnalysis.exceptions.StrategyException;
import com.techgusta.creditAnalysis.service.strategy.ScoreCalculation;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Order(1)
@Component
public class NegativeNameImpl implements ScoreCalculation {
    @Override
    public int calculate(Proposal proposal) {
        if (negativeName()) {
            throw new StrategyException(String.format(ConstantMessage.CUSTOMER_NEGATIVE, proposal.getUser().getName()));
        }
        return 100;
    }

    private boolean negativeName() {
        return new Random().nextBoolean();
    }
}
