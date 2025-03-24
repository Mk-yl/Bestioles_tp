package fr.epsi.b3devc2.bestioles_tp_sd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.epsi.b3devc2.bestioles_tp_sd.bo.*;
import fr.epsi.b3devc2.bestioles_tp_sd.repository.*;


import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class BestiolesTpSdApplication implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private SpeciesRepository speciesRepository;

    @Autowired
    private RoleRepository roleRepository;


    public static void main(String[] args) {
        SpringApplication.run(BestiolesTpSdApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

    }
}


