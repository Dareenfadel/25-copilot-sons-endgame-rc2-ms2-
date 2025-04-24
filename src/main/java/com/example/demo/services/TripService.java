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
        return tripRepository.findById(id).orElse(null);
    }

    public Trip updateTrip(Long id, Trip trip) {
        //To update trip details such as origin, destination, or cost.
        Trip existingTrip = getTripById(id);
        if(existingTrip==null) {
            return null;
        }
        if(trip.getOrigin()!=null)
            existingTrip.setOrigin(trip.getOrigin());
        if(trip.getDestination()!=null)
            existingTrip.setDestination(trip.getDestination());
        if(trip.getTripCost()!=0)
            existingTrip.setTripCost(trip.getTripCost());
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
