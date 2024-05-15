package com.techgusta.creditAnalysis.service.strategy.impl;

import com.techgusta.creditAnalysis.domain.Proposal;
import com.techgusta.creditAnalysis.service.strategy.ScoreCalculation;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OtherLoansInProgress implements ScoreCalculation {
    @Override
    public int calculate(Proposal proposal) {
        return otherLoansInProgress() ? 0 : 80;
    }

    private boolean otherLoansInProgress() {
        return new Random().nextBoolean();
    }
}
