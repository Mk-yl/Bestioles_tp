package fr.epsi.b3devc2.bestioles_tp_sd.repository;

import fr.epsi.b3devc2.bestioles_tp_sd.bo.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Repository
public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    //  tp6
    // Supprime toutes les personnes qui n'ont pas d'animaux
    @Override
    @Transactional
    public void deletePersonsWithoutAnimals() {
        // Étape 1 : Récupérer les IDs des personnes sans animaux
        List<Integer> personIds = entityManager.createQuery(
                        "SELECT p.id FROM Person p WHERE p.animals IS EMPTY", Integer.class)
                .getResultList();

        if (!personIds.isEmpty()) {
            // Étape 2 : Supprimer ces personnes
            entityManager.createQuery("DELETE FROM Person p WHERE p.id IN :ids")
                    .setParameter("ids", personIds)
                    .executeUpdate();
        }
    }

    // Génère x personnes avec des noms aléatoires
    @Override
    @Transactional
    public void generateRandomPersons(int numberOfPersons) {
        Random random = new Random();
        IntStream.range(0, numberOfPersons).forEach(i -> {
            Person person = new Person();
            person.setFirstname("FirstName" + random.nextInt(1000));
            person.setLastname("LastName" + random.nextInt(1000));
            person.setAge(random.nextInt(80));
            person.setLogin( "login" + random.nextInt(1000));
            person.setMdp("mdp" + random.nextInt(1000));
            person.setActive(random.nextBoolean());
            entityManager.persist(person);
        });
    }
}
