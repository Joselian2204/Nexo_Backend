package com.ucb.Nexo_Backend.repository;
import com.ucb.Nexo_Backend.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PredictionCountryRepository extends JpaRepository<CountryCases,String> {

    public List<CountryCases> findByCountryIdOrderByDateAsc(String countryId);


}
