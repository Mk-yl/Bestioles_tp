package fr.epsi.b3devc2.bestioles_tp_sd.repository;

public interface PersonRepositoryCustom {

    //tp6
    void deletePersonsWithoutAnimals();

    void generateRandomPersons(int numberOfPersons);
}
