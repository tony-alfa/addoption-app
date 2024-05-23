package com.expd.adoptionapp;

import com.expd.adoptionapp.model.Adopter;
import com.expd.adoptionapp.model.Pet;
import com.expd.adoptionapp.service.AdopterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.List;

@SpringBootApplication
public class AdoptionAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdoptionAppApplication.class, args);
    }

}


//@Component
class MyRunner implements CommandLineRunner
{
    private final AdopterService adopterService;


    public MyRunner(AdopterService adopterService) {
        this.adopterService = adopterService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("MyRunner called");

        Adopter adopter1 = new Adopter("Antony Alfaro","64205409");
        adopterService.addAdopter(adopter1);

        Pet pet1 = new Pet();
        List<Adopter> adopters = adopterService.getAllAdopters();
        System.out.println("adopters: " + adopters.size());
        System.out.println(adopters);
    }
}
