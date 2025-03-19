package fr.epsi.b3devc2.bestioles_tp_sd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.epsi.b3devc2.bestioles_tp_sd.bo.*;
import fr.epsi.b3devc2.bestioles_tp_sd.repository.*;


import java.util.Optional;

@SpringBootApplication
public class BestiolesTpSdApplication implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AnimalRepository animalRepository;

    public static void main(String[] args) {
        SpringApplication.run(BestiolesTpSdApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Démarrage des tests... ");

        // Afficher toutes les personnes et animaux
        System.out.println(" Liste des personnes : " + personRepository.findAll());

        System.out.println(" Liste des animaux : " + animalRepository.findAll());


        //  Ajouter des entités
        Person person = new Person( 21 , "Jean", "Dupont", " mkl" , "mkl01", true );
        personRepository.save(person);




        System.out.println("🚀 Fin des tests !");
    }
}


