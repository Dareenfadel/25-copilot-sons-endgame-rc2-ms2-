package com.example.demo.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Captain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Unique ID with auto-generation strategy

    @Column(nullable = false)
    private String name;  // Name of the captain

    @Column(nullable = false, unique = true)
    private String licenseNumber;  // License number of the captain

    @Column(nullable = false)
    private Double avgRatingScore;  // Average rating score

    @OneToMany(mappedBy = "captain", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Trip> trips;
    // Default constructor
    public Captain() {
        this.avgRatingScore = 0.0;  // Default value for avgRatingScore
    }

    // Partial constructor (with name, license number, and rating score)
    public Captain(String name, String licenseNumber, Double avgRatingScore) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.avgRatingScore = avgRatingScore;
    }

    // Full constructor (with all attributes including ID)
    public Captain(Long id, String name, String licenseNumber, Double avgRatingScore) {
        this.id = id;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.avgRatingScore = avgRatingScore;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Double getAvgRatingScore() {
        return avgRatingScore;
    }

    public void setAvgRatingScore(Double avgRatingScore) {
        this.avgRatingScore = avgRatingScore;
    }

    // Override toString for easier printing (optional)
    @Override
    public String toString() {
        return "Captain{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", avgRatingScore=" + avgRatingScore +
                '}';
    }
}
