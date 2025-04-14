package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @OneToOne
    @JoinColumn(name = "trip_id", referencedColumnName = "id")
    private Trip trip;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}