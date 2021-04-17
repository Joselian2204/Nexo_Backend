package com.ucb.Nexo_Backend.repository;

import com.ucb.Nexo_Backend.models.Municipio;
import com.ucb.Nexo_Backend.models.MunicipioCases;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MunicipioCasesRepository extends JpaRepository<MunicipioCases,Integer> {
    public List<MunicipioCases> findByRegionIdOrderByDate(String id);
}
