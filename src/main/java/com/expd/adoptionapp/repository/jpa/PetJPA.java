package com.expd.adoptionapp.repository.jpa;

import com.expd.adoptionapp.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetJPA extends JpaRepository<Pet, Integer> {
}
