package com.ucb.Nexo_Backend.repository;

import com.ucb.Nexo_Backend.models.Country;
import com.ucb.Nexo_Backend.models.CountryCases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface CountryCasesRepository extends JpaRepository<CountryCases, Integer> {
    public List<CountryCases> findByCountryIdOrderByDate(String id);
    public List<CountryCases> findByCountryIdAndDateBetween(String id,Date date1, Date date2);

   // @Query("select avg(cases) from CountryCases where countryId= #{countryId}")
   // public Long getCasesAverage(String countryId);
}
