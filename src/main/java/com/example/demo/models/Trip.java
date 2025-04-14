package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime tripDate;
    private String origin;
    private String destination;
    private double  tripCost;

    @ManyToOne
    @JoinColumn(name = "captain_id")
    private Captain captain;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(mappedBy = "trip", fetch = FetchType.LAZY)
    private Payment payment;


    public Trip() {
    }

    public Trip(LocalDateTime tripDate, String origin, String destination, double tripCost, Captain captain, Customer customer, Payment payment) {
        this.tripDate = tripDate;
        this.origin = origin;
        this.destination = destination;
        this.tripCost = tripCost;
        this.captain = captain;
        this.customer = customer;
        this.payment = payment;
    }

    public Trip(long id, LocalDateTime tripDate, String origin, String destination, double tripCost, Captain captain, Customer customer, Payment payment) {
        this.id = id;
        this.tripDate = tripDate;
        this.origin = origin;
        this.destination = destination;
        this.tripCost = tripCost;
        this.captain = captain;
        this.customer = customer;
        this.payment = payment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getTripDate() {
        return tripDate;
    }

    public void setTripDate(LocalDateTime tripDate) {
        this.tripDate = tripDate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getTripCost() {
        return tripCost;
    }

    public void setTripCost(double tripCost) {
        this.tripCost = tripCost;
    }

    public Captain getCaptain() {
        return captain;
    }

    public void setCaptain(Captain captain) {
        this.captain = captain;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", tripDate=" + tripDate +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", tripCost=" + tripCost +
                ", captain=" + captain +
                ", customer=" + customer +
                ", payment=" + payment +
                '}';
    }
}
