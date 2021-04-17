package com.ucb.Nexo_Backend.repository;

import com.ucb.Nexo_Backend.models.CountryCases;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryCasesRepository extends JpaRepository<CountryCases, Integer> {
    public List<CountryCases> findByCountryIdOrderByDate(String id);
}
