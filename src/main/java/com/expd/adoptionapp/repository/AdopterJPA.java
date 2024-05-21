package com.expd.adoptionapp.repository;

import com.expd.adoptionapp.model.Adopter;
import com.expd.adoptionapp.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdopterJPA extends JpaRepository<Adopter, Integer> {
    List<Adopter> findAdoptersByPetType(Pet.PetType petType);

}
