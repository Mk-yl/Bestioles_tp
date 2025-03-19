package fr.epsi.b3devc2.bestioles_tp_sd.repository;

import fr.epsi.b3devc2.bestioles_tp_sd.bo.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    Animal findFirstBySpeciesCommonName (String commonName);

    List<Animal> findAllByColorIn (List<String> colors);

    // Trouver le nombre d'animaux ayant un certain sexe
    @Query("SELECT COUNT(a) FROM Animal a WHERE a.sex = :sex")
    long countBySex(@Param("sex") String sex);

    // Vérifier si un animal appartient à au moins une personne
    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN TRUE ELSE FALSE END FROM Person p JOIN p.animals a WHERE a.id = :animalId")
    boolean existsByOwner(@Param("animalId") Integer animalId);

}
