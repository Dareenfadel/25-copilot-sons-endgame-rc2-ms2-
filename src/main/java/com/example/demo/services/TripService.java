package com.example.demo.services;

import com.example.demo.models.Captain;
import com.example.demo.models.Customer;
import com.example.demo.models.Payment;
import com.example.demo.models.Trip;
import com.example.demo.repositories.TripRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TripService {

    private final TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public Trip addTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public Trip getTripById(Long id) {
        return tripRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Trip not found with id: " + id));
    }

    public Trip updateTrip(Long id, Trip trip) {
        Trip existingTrip = getTripById(id);

        existingTrip.setOrigin(trip.getOrigin());
        existingTrip.setDestination(trip.getDestination());
        existingTrip.setTripCost(trip.getTripCost());
//        existingTrip.setTripDate(trip.getTripDate());
        return tripRepository.save(existingTrip);
    }


    public void deleteTrip(Long id) {
        Trip existingTrip = getTripById(id);
        tripRepository.delete(existingTrip);
    }

    public List<Trip> findTripsWithinDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return tripRepository.findTripsByDateRange(startDate, endDate);
    }

    public List<Trip> findTripsByCaptainId(Long captainId) {
        return tripRepository.findByCaptainId(captainId);
    }
}
