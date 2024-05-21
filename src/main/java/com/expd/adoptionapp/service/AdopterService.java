package com.expd.adoptionapp.service;

import com.expd.adoptionapp.repository.AdopterDAO;
import com.expd.adoptionapp.model.Adopter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdopterService {

    private AdopterDAO adopterDAO;

    public AdopterService(AdopterDAO adopterDAO) {
        this.adopterDAO = adopterDAO;
    }

    public Adopter addAdopter(Adopter adopter) {
        return adopterDAO.insert(adopter);
    }

    public Adopter getAdopter(int id) {
        return adopterDAO.findById(id);
    }

    public List<Adopter> getAllAdopters() {
        return adopterDAO.findAll();
    }

    public boolean deleteAdopter(int id) {
        return adopterDAO.delete(id);
    }

    public boolean updateAdopter(Adopter adopter) {
        return adopterDAO.update(adopter);
    }

    public void setAdopterDAO(AdopterDAO adopterDAO) {
        this.adopterDAO = adopterDAO;
    }

//    public List<Adopter> getAdoptersByPetType(Pet.PetType type) {
//        return adopterDAO
//                .findAll().stream()
//                .filter(a -> a.getPet().getType() == type)
//                .toList();
//    }
}
