package com.teachhealth.hospitalbe.bloodManagment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BloodContractDto {
    private List<BloodUnitDto> bloodUnits;
    private Integer price;
    private LocalDateTime deliveryDate;
    private String hospitalName;
}
