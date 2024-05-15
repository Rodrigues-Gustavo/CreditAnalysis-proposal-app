package com.techgusta.creditAnalysis.listener;

import com.techgusta.creditAnalysis.domain.Proposal;
import com.techgusta.creditAnalysis.service.strategy.CreditedAnalysisService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProposalUnderAnalysisListener {

    @Autowired
    private CreditedAnalysisService creditedAnalysisService;

    @RabbitListener(queues = "${rabbitmq.queue.pending.proposal}")
    public void proposalUnderAnalysis(Proposal proposal) {
        creditedAnalysisService.analyze(proposal);
    }
}
