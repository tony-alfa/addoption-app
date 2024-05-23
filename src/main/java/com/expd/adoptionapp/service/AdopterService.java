package com.expd.adoptionapp.service;

import com.expd.adoptionapp.model.Pet;
import com.expd.adoptionapp.model.Adopter;
import com.expd.adoptionapp.repository.AdopterJPA;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdopterService {

    private AdopterJPA adopterJPA;

    public AdopterService(AdopterJPA adopterJPA) {
        this.adopterJPA = adopterJPA;
    }

    public Adopter addAdopter(Adopter adopter) {
        return adopterJPA.save(adopter);
    }

    public Adopter getAdopter(int id) {
        return adopterJPA.findById(id).orElse(null);
    }

    public List<Adopter> getAllAdopters() {
        return adopterJPA.findAll();
    }

    public List<Adopter> getAllAdoptersWithPetType(Pet.PetType type) {
        return adopterJPA.selectAllAdoptersWithPetType(type).orElse(null);
    }

    public Adopter addPetsToAdopter(int adopterId, List<Pet> pets){
        Adopter adopter = adopterJPA.findById(adopterId).orElse(null);
        if (adopter == null){
           return null;
        }else{
            adopter.getPets().addAll(pets);
            return adopterJPA.save(adopter);
        }
    }

    public boolean deleteAdopter(Adopter adopter) {
        if(adopterJPA.existsById(adopter.getId())){
            adopterJPA.delete(adopter);
            return true;
        }
        return false;
    }

    public boolean updateAdopter(Adopter adopter) {
        if(adopterJPA.existsById(adopter.getId())){
            adopterJPA.save(adopter);
            return true;
        }
        return false;
    }
}
