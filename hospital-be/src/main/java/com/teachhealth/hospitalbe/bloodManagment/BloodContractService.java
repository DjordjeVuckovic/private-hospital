package com.teachhealth.hospitalbe.bloodManagment;

import com.teachhealth.hospitalbe.common.MessagingConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BloodContractService {
    private final BloodContractRepository bloodContractRepository;
    private final BloodUnitRepository bloodUnitRepository;
    private final RabbitTemplate rabbitTemplate;


    public BloodContract getCurrentContract( ) throws Exception {
        return bloodContractRepository
                .getCurrentContract("Best Hospital")
                .orElseThrow(() -> new Exception("No contracts"));
    }
    @Transactional
    public void createContract(BloodContractDto contractDto){
        var contract = bloodContractRepository
                .getCurrentContract(contractDto.getHospitalName());
        contract.ifPresent(bloodContract -> bloodContract.setIsExpired(true));
        var newBloodUnits = contractDto.getBloodUnits().stream().map(bloodUnitDto ->
                new BloodUnit(bloodUnitDto.getBloodType(),bloodUnitDto.getBloodAmount()))
                .toList();
        bloodUnitRepository.saveAll(newBloodUnits);
        var newContract = BloodContract.builder()
                .deliveryDate(contractDto.getDeliveryDate())
                .price(contractDto.getPrice())
                .hospitalName(contractDto.getHospitalName())
                .isExpired(false)
                .bloodUnits(newBloodUnits)
                .build();
        rabbitTemplate.convertAndSend(MessagingConfig.EXCHANGE_STATIC, MessagingConfig.QUEUE_STATIC, contractDto);
        bloodContractRepository.save(newContract);
    }
}
