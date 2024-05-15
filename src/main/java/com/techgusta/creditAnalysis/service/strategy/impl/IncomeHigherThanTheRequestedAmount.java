package com.techgusta.creditAnalysis.service.strategy.impl;

import com.techgusta.creditAnalysis.domain.Proposal;
import com.techgusta.creditAnalysis.service.strategy.ScoreCalculation;
import org.springframework.stereotype.Component;

@Component
public class IncomeHigherThanTheRequestedAmount implements ScoreCalculation {
    @Override
    public int calculate(Proposal proposal) {
        return incomeHigherThanTheRequestedAmount(proposal) ? 100 : 0;
    }

    private boolean incomeHigherThanTheRequestedAmount(Proposal proposal) {
        return proposal.getUser().getSalary() > proposal.getRequestedAmount();
    }
}
