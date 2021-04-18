package com.ucb.Nexo_Backend.repository;

import com.ucb.Nexo_Backend.models.MunicipalityCases;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MunicipalityCasesRepository extends JpaRepository<MunicipalityCases,Integer> {
    public List<MunicipalityCases> findByRegionIdOrderByDate(String id);
}
