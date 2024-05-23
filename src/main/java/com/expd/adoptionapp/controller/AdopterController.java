package com.expd.adoptionapp.controller;

import com.expd.adoptionapp.model.Adopter;
import com.expd.adoptionapp.model.Pet;
import com.expd.adoptionapp.service.AdopterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adopter")
public class AdopterController {
    AdopterService adopterService;

    public AdopterController(AdopterService adopterService) {
        this.adopterService = adopterService;
    }

    @GetMapping
    public List<Adopter> getAllAdopters(){
        return adopterService.getAllAdopters();
    }

    @GetMapping("/{id}")
    public Adopter getAdopterById(@PathVariable int id){
        return adopterService.getAdopter(id);
    }

    @GetMapping("/type/{type}")
    public List<Adopter> getAllAdoptersWithPetType(@PathVariable Pet.PetType type){
        return adopterService.getAllAdoptersWithPetType(type);
    }

    @PatchMapping
    public Adopter addPetsToAdopter(@RequestBody Adopter adopter){
        return adopterService.addPetsToAdopter(adopter.getId(), adopter.getPets());
    }

    @PostMapping
    public Adopter addAdopter(@RequestBody Adopter adopter){
        return adopterService.addAdopter(adopter);
    }
}
