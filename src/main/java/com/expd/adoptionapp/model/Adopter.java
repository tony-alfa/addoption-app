package com.expd.adoptionapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;
import java.util.Set;

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

    @OneToMany
    Set<Pet> pets;

    public Adopter(String name, String phoneNumber, LocalDate adoptionDate, Set<Pet> pets) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.adoptionDate = adoptionDate;
        this.pets = pets;
    }

    public Adopter(String name, String phoneNumber) {
        this(name, phoneNumber, null, null);
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

    public Set<Pet> getPet() {
        return pets;
    }

    public void setPet(Set<Pet> pet) {
        this.pets = pet;
        this.adoptionDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Adopter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", adoptionDate=" + adoptionDate +
                ", pet=" + pets +
                '}';
    }
}
