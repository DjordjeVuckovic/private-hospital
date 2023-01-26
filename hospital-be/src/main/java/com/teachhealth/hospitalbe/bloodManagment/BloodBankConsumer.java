package com.teachhealth.hospitalbe.bloodManagment;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BloodBankConsumer {
    private static final Logger log = LoggerFactory.getLogger(BloodContractService.class);
    @RabbitListener(queues="${QUEUE_HOSPITAL_1}")
    public void handler(String message) {
        log.info("Consumer> " + message);
    }
}
