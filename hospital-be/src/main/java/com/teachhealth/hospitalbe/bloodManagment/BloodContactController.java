package com.teachhealth.hospitalbe.bloodManagment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/blood-contract")
@RequiredArgsConstructor
public class BloodContactController {
    private final BloodContractService bloodContractService;
    @PostMapping()
    public ResponseEntity<?> createCenter(@RequestBody BloodContractDto contractDto){
        bloodContractService.createContract(contractDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
