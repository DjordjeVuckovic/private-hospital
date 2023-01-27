package com.teachhealth.hospitalbe.bloodManagment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.teachhealth.hospitalbe.offers.OfferMessage;
import com.teachhealth.hospitalbe.offers.OfferMessageRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BloodBankConsumer {
    private static final Logger log = LoggerFactory.getLogger(BloodContractService.class);
    private final OfferMessageRepository offerMessageRepository;
    @RabbitListener(queues="${QUEUE_HOSPITAL_1}")
    public void handler(String message) {
        log.info("Consumer> " + message);
        var off = OfferMessage.builder().message(message).build();
        offerMessageRepository.save(off);
    }
}
