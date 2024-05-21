package com.expd.adoptionapp.service;

import com.expd.adoptionapp.model.Adopter;
import com.expd.adoptionapp.model.Pet;
import com.expd.adoptionapp.repository.AdopterDAO;
import com.expd.adoptionapp.repository.inmemory.InMemoryPetDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private InMemoryPetDAO inMemoryPetDAO;

    public PetService(InMemoryPetDAO inMemoryPetDAO) {
        this.inMemoryPetDAO = inMemoryPetDAO;
    }

    public Pet addPet(Pet pet) {
        return inMemoryPetDAO.insert(pet);
    }

    public Pet getPet(int id) {
        return inMemoryPetDAO.findById(id);
    }

    public List<Pet> getAllPets() {
        return inMemoryPetDAO.findAll();
    }

    public boolean deletePet(int id) {
        return inMemoryPetDAO.delete(id);
    }

    public boolean updatePet(Pet pet) {
        return inMemoryPetDAO.update(pet);
    }

    public void setPetDAO(InMemoryPetDAO inMemoryPetDAO) {
        this.inMemoryPetDAO = inMemoryPetDAO;
    }

}
