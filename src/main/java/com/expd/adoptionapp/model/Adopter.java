package com.expd.adoptionapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Adopter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    @NotNull
    private String name;
    @Column
    private String phoneNumber;

    @NotNull
    @PastOrPresent
    @Column
    private LocalDate adoptionDate;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Pet> pets = new ArrayList<>();


    public Adopter(String name, String phoneNumber, LocalDate adoptionDate) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.adoptionDate = adoptionDate;
    }

    public Adopter(String name, String phoneNumber) {
        this(name, phoneNumber, null);
    }

    public Adopter() {
        int stop = 10;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getAdoptionDate() {
        return adoptionDate;
    }

    public void setAdoptionDate(LocalDate adoptionDate) {
        this.adoptionDate = adoptionDate;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "Adopter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", adoptionDate=" + adoptionDate +
                ", pets=" + pets +
                '}';
    }
}
