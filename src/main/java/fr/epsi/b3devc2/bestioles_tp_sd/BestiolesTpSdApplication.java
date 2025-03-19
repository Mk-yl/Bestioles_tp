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
        System.out.println("Démarrage des tests... ");


        // Afficher toutes les personnes et animaux
        System.out.println(" Liste des personnes : " + personRepository.findAll());

        System.out.println(" Liste des animaux : " + animalRepository.findAll());


        //  Ajouter des entités
        Role role = new Role("admin");
        Person person = new Person( 21 , "mkl", "Dupont", " mk1l" , "mkl01", true );
        Species species = new Species("chien", "canis lupus" );
        Animal animal = new Animal("rouge", "chien", "m", species);

        animalRepository.save(animal);
        personRepository.save(person);
        roleRepository.save(role);

        //Rechercher une entité par son id avec findById

        Optional<Person> person1 = personRepository.findById(1);
        System.out.println("Personne avec id 1 : " + person1);

        //Supprimer une entité avec delete, et afficher la longueur de la liste de toutes les entités
        //pour vérifier qu’elle a bien été supprimée

        personRepository.delete(person);

        System.out.println(" Liste des personnes : " + personRepository.findAll().size());

        //delete by id
        personRepository.deleteById(1);
        System.out.println(" Liste des personnes : " + personRepository.findAll().size());




        // utilser les méthodes de recherche personnalisées existsByOwner

        System.out.println("Animal appartient à au moins une personne : " + animalRepository.existsByOwner(9));


        System.out.println("cette animal appartien a : " + personRepository.findByAnimal(1));












        System.out.println("🚀 Fin des tests !");
    }
}


