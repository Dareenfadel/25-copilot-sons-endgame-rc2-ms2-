package com.example.demo.controllers;

import com.example.demo.models.Trip;
import com.example.demo.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripController {

    private final TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @PostMapping("/addTrip")
    public ResponseEntity<Trip> addTrip(@RequestBody Trip trip) {
        try {
            Trip createdTrip = tripService.addTrip(trip);
            return new ResponseEntity<>(createdTrip, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/allTrips")
    public ResponseEntity<List<Trip>> getAllTrips() {
        List<Trip> trips = tripService.getAllTrips();
        return new ResponseEntity<>(trips, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trip> getTripById(@PathVariable Long id) {
        try {
            Trip trip = tripService.getTripById(id);
            return new ResponseEntity<>(trip, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Trip> updateTrip(@PathVariable Long id, @RequestBody Trip trip) {
        try {
            Trip updatedTrip = tripService.updateTrip(id, trip);
            return new ResponseEntity<>(updatedTrip, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTrip(@PathVariable Long id) {
        try {
            tripService.deleteTrip(id);
            return new ResponseEntity<>("Trip deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Trip not found.", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByDateRange")
    public ResponseEntity<List<Trip>> findTripsWithinDateRange(
            @RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        try {
            List<Trip> trips = tripService.findTripsWithinDateRange(startDate.atStartOfDay(), endDate.atTime(23, 59, 59));
            return new ResponseEntity<>(trips, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByCaptainId")
    public ResponseEntity<List<Trip>> findTripsByCaptainId(@RequestParam Long captainId) {
        try {
            List<Trip> trips = tripService.findTripsByCaptainId(captainId);
            return new ResponseEntity<>(trips, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
