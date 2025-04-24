package com.example.demo.repositories;


import com.example.demo.models.Captain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CaptainRepository extends JpaRepository<Captain, Long> {

    @Query("SELECT c FROM Captain c WHERE c.avgRatingScore > :threshold")
    List<Captain> findByAvgRatingScoreGreaterThan(Double threshold);

    @Query("SELECT c FROM Captain c WHERE c.licenseNumber = :licenseNumber")
    Optional<Captain> findByLicenseNumber(String licenseNumber);
}
