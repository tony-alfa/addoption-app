package com.expd.adoptionapp.repository;


import com.expd.adoptionapp.model.Adopter;

import java.util.List;

public interface AdopterDAO {
    Adopter insert(Adopter newAdopter);

    boolean delete(int id);

    boolean update(Adopter adopter);

    Adopter findById(int id);

    List<Adopter> findAll();

    interface AdopterJPA {
    }
}
