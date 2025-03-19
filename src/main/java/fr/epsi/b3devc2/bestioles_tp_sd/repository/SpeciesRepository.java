package fr.epsi.b3devc2.bestioles_tp_sd.repository;

import fr.epsi.b3devc2.bestioles_tp_sd.bo.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SpeciesRepository extends JpaRepository<Species, Integer> {
// tp4
    List<Species> findAllByCommonName (String commonName);

    List<Species> findAllByLatinNameContainingIgnoreCase(String latinName);


    //tp5

    // Trouver toutes les espèces triées par nom commun en ordre ascendant
    @Query("SELECT s FROM Species s ORDER BY s.commonName ASC")
    List<Species> findAllOrderedByCommonName();

    // Trouver les espèces dont le nom commun contient une certaine valeur
    @Query("SELECT s FROM Species s WHERE s.commonName LIKE %:name%")
    List<Species> findByCommonNameLike(@Param("name") String name);

}
