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
    private BloodType bloodType;
    private Integer bloodAmount;
}
