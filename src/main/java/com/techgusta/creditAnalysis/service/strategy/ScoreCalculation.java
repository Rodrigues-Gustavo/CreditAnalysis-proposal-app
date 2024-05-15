package com.techgusta.creditAnalysis.service.strategy;

import com.techgusta.creditAnalysis.domain.Proposal;

public interface ScoreCalculation {

    int calculate(Proposal proposal);
}
