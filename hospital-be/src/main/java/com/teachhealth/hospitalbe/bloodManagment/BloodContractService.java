package com.teachhealth.hospitalbe.bloodManagment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class BloodContractService {
    private final BloodContractRepository bloodContractRepository;
    private final BloodUnitRepository bloodUnitRepository;
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
        bloodContractRepository.save(newContract);
    }
}
