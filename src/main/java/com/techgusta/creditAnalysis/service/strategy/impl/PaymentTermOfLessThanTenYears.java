package com.techgusta.creditAnalysis.service.strategy.impl;

import com.techgusta.creditAnalysis.domain.Proposal;
import com.techgusta.creditAnalysis.service.strategy.ScoreCalculation;
import org.springframework.stereotype.Component;

@Component
public class PaymentTermOfLessThanTenYears implements ScoreCalculation {
    @Override
    public int calculate(Proposal proposal) {
        return proposal.getPaymentTime() < 120 ? 80 : 0;
    }
}
