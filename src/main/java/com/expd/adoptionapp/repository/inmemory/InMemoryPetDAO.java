package com.expd.adoptionapp.repository.inmemory;

import com.expd.adoptionapp.model.Pet;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
@Profile("dev")
public class InMemoryPetDAO {

    private Map<Integer, Pet> pets = new ConcurrentHashMap<>();
    private AtomicInteger nextId = new AtomicInteger(1);

    public Pet insert(Pet newPet) {
        newPet.setPetId(nextId.getAndIncrement());
        newPet.setName("InMem: " + newPet.getName());
        pets.put(newPet.getPetId(), newPet);

        return newPet;
    }

    public boolean delete(int id) {
        return pets.remove(id) != null;
    }

    public boolean update(Pet pet) {
        return pets.replace(pet.getPetId(), pet) != null;
    }

    public Pet findById(int id) {
        return pets.get(id);
    }

    public List<Pet> findAll() {
        return new ArrayList(pets.values());
    }
}
