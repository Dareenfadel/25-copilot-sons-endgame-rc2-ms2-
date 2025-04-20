package com.example.demo.repositories;


import com.example.demo.models.Captain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CaptainRepository extends JpaRepository<Captain, Long> {

    // Method to find all captains with a rating above a given threshold
    List<Captain> findByAvgRatingScoreGreaterThan(Double threshold);

    // Method to find a captain by their license number
    Optional<Captain> findByLicenseNumber(String licenseNumber);

    // You can also use JPQL (Optional, as alternative to method query derivation)
    @Query("SELECT c FROM captains c WHERE c.avgRatingScore > :threshold")
    List<Captain> findCaptainsByRatingAbove(Double threshold);

    @Query("SELECT c FROM captains c WHERE c.licenseNumber = :licenseNumber")
    Optional<Captain> findCaptainByLicenseNumber(String licenseNumber);
}
