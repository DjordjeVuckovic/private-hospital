package com.teachhealth.hospitalbe.bloodManagment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BloodContractRepository extends JpaRepository<BloodContract, Long> {
    @Query("SELECT bc from BloodContract bc where bc.isExpired = false and bc.hospitalName=?1")
    Optional<BloodContract> getCurrentContract(String hospitalName);
}