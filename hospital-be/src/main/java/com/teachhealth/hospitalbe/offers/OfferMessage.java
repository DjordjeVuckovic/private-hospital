package com.teachhealth.hospitalbe.offers;

import lombok.*;

import javax.persistence.*;

@Entity(name = "BloodContract")
@Table(name = "blood_contract")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OfferMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    String message;
}
