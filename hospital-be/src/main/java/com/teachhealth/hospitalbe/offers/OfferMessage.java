package com.teachhealth.hospitalbe.offers;

import lombok.*;

import javax.persistence.*;

@Entity(name = "OfferMessage")
@Table(name = "offer_message")
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
