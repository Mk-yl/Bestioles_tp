package fr.epsi.b3devc2.bestioles_tp_sd.repository;

import fr.epsi.b3devc2.bestioles_tp_sd.bo.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SpeciesRepository extends JpaRepository<Species, Integer> {

    List<Species> findAllByCommonName (String commonName);

    List<Species> findAllByLatinNameContainingIgnoreCase(String latinName);

}
