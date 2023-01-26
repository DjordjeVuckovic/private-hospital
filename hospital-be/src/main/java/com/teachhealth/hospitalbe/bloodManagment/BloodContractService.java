package com.teachhealth.hospitalbe.bloodManagment;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BloodContractService {
    private final BloodContractRepository bloodContractRepository;
    @Transactional
    public void createContract(BloodContractDto contractDto){
        var contract = bloodContractRepository
                .getCurrentContract(contractDto.getHospitalName());
        contract.ifPresent(bloodContract -> bloodContract.setIsExpired(true));
        var newContract = BloodContract.builder()
                .deliveryDate(contractDto.getDeliveryDate())
                .price(contractDto.getPrice())
                .hospitalName(contractDto.getHospitalName())
                .isExpired(false)
                .bloodUnits(contractDto.getBloodUnits())
                .build();
        bloodContractRepository.save(newContract);
    }
}
