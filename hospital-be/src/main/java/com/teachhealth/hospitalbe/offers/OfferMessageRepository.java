package com.teachhealth.hospitalbe.offers;

import com.teachhealth.hospitalbe.bloodManagment.BloodContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OfferMessageRepository extends JpaRepository<OfferMessage, Long> {
    @Query("SELECT m from OfferMessage m order by m.id DESC")
    List<OfferMessage> GetOffers();
}