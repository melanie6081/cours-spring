package monprojet.dao;

import java.util.ArrayList;
import java.util.List;

import monprojet.dto.PopulationParPays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import monprojet.entity.City;
import monprojet.entity.Country;

// This will be AUTO IMPLEMENTED by Spring 

public interface CountryRepository extends JpaRepository<Country, Integer> {
@Query(value="SELECT SUM(CITY.POPULATION) " +
        "FROM CITY " +
        "WHERE CITY.COUNTRY_ID=:id",
nativeQuery = true)
    public Integer populationPourCountryID(Integer id);

@Query(value="SELECT COUNTRY.NAME as name, SUM(CITY.POPULATION) as population "+
        "FROM COUNTRY INNER JOIN CITY ON COUNTRY.ID=CITY.COUNTRY_ID " +
        "GROUP BY COUNTRY.NAME, COUNTRY.ID, CITY.ID",
        nativeQuery = true)
    public ArrayList<PopulationParPays> populationParPays();
}

