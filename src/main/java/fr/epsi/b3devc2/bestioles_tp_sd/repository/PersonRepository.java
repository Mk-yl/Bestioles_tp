package fr.epsi.b3devc2.bestioles_tp_sd.repository;

import fr.epsi.b3devc2.bestioles_tp_sd.bo.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    //tp4
    List<Person> findAllByLastnameOrFirstname(String lastname, String firstname);

    List <Person> findAllByAgeGreaterThanEqual(int age);

    //tp5
    // Trouver les personnes dont l'âge est entre ageMin et ageMax
    @Query("SELECT p FROM Person p WHERE p.age BETWEEN :ageMin AND :ageMax")
    List<Person> findByAgeBetween(@Param("ageMin") int ageMin, @Param("ageMax") int ageMax);

    // Trouver les personnes qui possèdent un animal
    @Query("SELECT p FROM Person p JOIN p.animals a WHERE a.id = :animalId")
    List<Person> findByAnimal(@Param("animalId") Integer animalId);

}
