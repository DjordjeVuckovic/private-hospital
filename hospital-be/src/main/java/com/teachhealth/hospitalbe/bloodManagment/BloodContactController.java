package com.teachhealth.hospitalbe.bloodManagment;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4205")
@RequestMapping(path = "api/v1/blood-contract")
@RequiredArgsConstructor
public class BloodContactController {
    private final BloodContractService bloodContractService;
    @PostMapping()
    public ResponseEntity<?> createContract(@RequestBody BloodContractDto contractDto){
        bloodContractService.createContract(contractDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/{hospitalName}")
    public  ResponseEntity<BloodContract> getCurrentContract(@Parameter(name="hospitalName", required = true) @PathVariable("hospitalName") String hospitalName) {
        BloodContract contract;
        try {
           contract = bloodContractService.getCurrentContract(hospitalName);
        }
        catch (RuntimeException re){
            return  ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(contract);
    }

}
