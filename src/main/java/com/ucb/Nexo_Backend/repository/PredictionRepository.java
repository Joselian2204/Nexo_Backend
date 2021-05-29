package com.ucb.Nexo_Backend.repository;
import com.ucb.Nexo_Backend.models.Country;
import com.ucb.Nexo_Backend.models.CountryCases;
import com.ucb.Nexo_Backend.models.Prediction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PredictionRepository extends JpaRepository<CountryCases,String> {

    public List<CountryCases> findByCountryIdOrderByDateAsc(String countryId);
}
