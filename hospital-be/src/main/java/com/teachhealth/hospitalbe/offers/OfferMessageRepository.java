package com.teachhealth.hospitalbe.offers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferMessageRepository extends JpaRepository<OfferMessage, Long> {
}