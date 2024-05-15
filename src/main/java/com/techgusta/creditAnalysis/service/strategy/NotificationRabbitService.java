package com.techgusta.creditAnalysis.service.strategy;

import com.techgusta.creditAnalysis.domain.Proposal;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationRabbitService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void notify(String exchange, Proposal proposal) {
        rabbitTemplate.convertAndSend(exchange, "", proposal);
    }
}
