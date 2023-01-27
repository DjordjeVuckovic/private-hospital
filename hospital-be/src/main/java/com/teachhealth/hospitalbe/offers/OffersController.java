package com.teachhealth.hospitalbe.offers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/offers")
@RequiredArgsConstructor
public class OffersController {
    private final OfferMessageRepository offerMessageRepository;
    @GetMapping
    public ResponseEntity<List<OfferMessage>> getAllMessages(){
        return ResponseEntity.ok(offerMessageRepository.GetOffers());
    }
}
