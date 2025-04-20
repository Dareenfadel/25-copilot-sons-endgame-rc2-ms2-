package com.example.demo.controllers;

import com.example.demo.models.Captain;
import com.example.demo.models.Customer;
import com.example.demo.models.Payment;
import com.example.demo.models.Trip;
import com.example.demo.services.CaptainService;
import com.example.demo.services.CustomerService;
import com.example.demo.services.PaymentService;
import com.example.demo.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripController {

    private final TripService tripService;
    private final CaptainService captainService;

    @Autowired
    public TripController(TripService tripService, CaptainService captainService) {
        this.tripService = tripService;
        this.captainService = captainService;

    }

    @PostMapping("/addTrip")
    public Trip addTrip(@RequestBody Trip trip){
        //currently allowing null attributes, awaiting test files
            return tripService.addTrip(trip);
    }

    @GetMapping("/allTrips")
    public List<Trip> getAllTrips(){
        return tripService.getAllTrips();
    }

    @GetMapping("/{id}")
    public Trip getTripById(@PathVariable Long id) {
        return tripService.getTripById(id);
    }

    @PutMapping("/update/{id}")
    public Trip updateTrip(@PathVariable Long id, @RequestBody Trip trip){
        return tripService.updateTrip(id, trip);
    }



    @DeleteMapping("/delete/{id}")
    public String deleteTrip(@PathVariable Long id){
        try {
            tripService.deleteTrip(id);
            return "Trip deleted successfully.";
        } catch (Exception e) {
            return "Trip not found.";
        }
    }

    @GetMapping("/findByDateRange")
    public List<Trip> findTripsWithinDateRange(@RequestParam LocalDateTime startDate, @RequestParam
    LocalDate endDate){
        return tripService.findTripsWithinDateRange(startDate, endDate.atTime(23, 59, 59));
    }

    @GetMapping("/findByCaptainId")
    public List<Trip> findTripsByCaptainId(@RequestParam Long captainId){
            Captain captain = captainService.getCaptainById(captainId);
            if (captain == null) {
               throw new IllegalArgumentException("Captain not found with id: " + captainId);

            }

            return tripService.findTripsByCaptainId(captainId);

    }

}
