package com.expd.adoptionapp.repository;

import com.expd.adoptionapp.model.Adopter;
import com.expd.adoptionapp.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AdopterJPA extends JpaRepository<Adopter, Integer> {

    @Query("select a from Adopter a join fetch a.pets p where p.type = :type")
    Optional<List<Adopter>> selectAllAdoptersWithPetType(Pet.PetType type);

}
