package com.teachhealth.hospitalbe.bloodManagment;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "BloodUnit")
@Table(name = "blood_unit")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BloodUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Enumerated(EnumType.STRING)
    private BloodType bloodType;
    private Integer bloodAmount;
    public BloodUnit(BloodType bloodType, Integer bloodAmount) {
        this.bloodType = bloodType;
        this.bloodAmount = bloodAmount;
    }
}
