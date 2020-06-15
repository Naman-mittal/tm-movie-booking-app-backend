package com.upgrad.mtb.beans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column( nullable = false, unique = true)
    private String theatreName;
    @Column( nullable = false)
    private int noOfSeats;
    @Column( nullable = false)
    private int ticketPrice;

    @Column( nullable = false)
    @ManyToOne
    @JsonBackReference("theatre_city")
    private City city;

    @OneToMany(mappedBy = "theatre" , fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @MapKey
    @JsonManagedReference("booking_theatre")
    List<Booking> bookings;

    @ManyToOne
    @JsonBackReference("movie_theatre")
    private Movie movie;

    public Theatre(){}



}