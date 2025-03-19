package fr.epsi.b3devc2.bestioles_tp_sd.repository;

import fr.epsi.b3devc2.bestioles_tp_sd.bo.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    Animal findFirstBySpeciesCommonName (String commonName);

    List<Animal> findAllByColorIn (List<String> colors);

}
