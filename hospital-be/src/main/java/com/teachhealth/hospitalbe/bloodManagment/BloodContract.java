package com.teachhealth.hospitalbe.bloodManagment;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "BloodContract")
@Table(name = "blood_contract")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BloodContract {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToMany
    private List<BloodUnit> bloodUnits;
    private Integer price;
    private LocalDateTime deliveryDate;
    private Boolean isExpired = false;
    private String hospitalName;
}
