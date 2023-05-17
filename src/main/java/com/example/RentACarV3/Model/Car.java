package com.example.RentACarV3.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "Car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCar;

    private String name;

    private String brand;

    private Integer year;

    private String description;

    // Gama 
    @ManyToOne
    @JoinColumn(name = "gamaId")
    @JsonIgnoreProperties("cars")
    private Gama gama;

    // Messages
    @OneToMany  // (cascade = {CascadeType.PERSIST}, mappedBy = "car")  
    @JsonIgnoreProperties({"client", "car"})
    private List<Message> messages;

    // Reservations
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "car")
    @JsonIgnoreProperties({"car", "client"})        //
    private List<Reservation> reservations;

    //  Integer idCar
    public Integer getIdCar() {
        return idCar;
    }
    public void setIdCar(Integer idCar) {
        this.idCar = idCar;
    }

    //  String name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //  String brand
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    //  Integer year
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year){
        this.year = year;
    }

    //  String description
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    // gama, messages, reservations son atributos de Car, por lo que crear acceso para ellos es necesatio
    //  Gama gama
    public Gama getGama() {
        return gama;
    }
    public void setGama(Gama gama) {
        this.gama = gama;
    }

    // List<Message> messages
    public List<Message> getMessages() {
        return messages;
    }
    public void setMessages(List<Message> messages) {
        this.messages = messages; 
    }

    // List<Reservation> reservations
    public List<Reservation> getReservations() {
        return reservations;
    }
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
