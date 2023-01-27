package com.teachhealth.hospitalbe.bloodManagment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4205/")
@RequestMapping(path = "api/v1/blood-contract")
@RequiredArgsConstructor
public class BloodContactController {
    private final BloodContractService bloodContractService;
    @PostMapping()
    public ResponseEntity<?> createContract(@RequestBody BloodContractDto contractDto){
        bloodContractService.createContract(contractDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping()
    public  ResponseEntity<BloodContract> getCurrentontract() throws Exception {
        BloodContract contract = bloodContractService.getCurrentContract();
        return ResponseEntity.ok(contract);
    }

}
