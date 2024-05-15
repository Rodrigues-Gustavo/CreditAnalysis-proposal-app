package com.techgusta.creditAnalysis.service.strategy;

import com.techgusta.creditAnalysis.domain.Proposal;
import com.techgusta.creditAnalysis.exceptions.StrategyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditedAnalysisService {

    @Autowired
    private List<ScoreCalculation> scoreCalculationsList;

    @Autowired
    private NotificationRabbitService notificationRabbitService;

    @Value("rabbitmq.completedproposal.exchange}")
    private String exchangeCompletedProposal;

    public void analyze(Proposal proposal) {
        try {
            int score = scoreCalculationsList.stream().
                    mapToInt(impl -> impl.calculate(proposal)).sum();
            proposal.setApproved(score > 350);
        } catch (StrategyException ex) {
            proposal.setApproved(false);
            proposal.setObservation(ex.getMessage());
        }
        notificationRabbitService.notify(exchangeCompletedProposal, proposal);
    }
}
