package com.ucb.Nexo_Backend.repository;

import com.ucb.Nexo_Backend.models.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MunicipioRepository extends JpaRepository<Municipio, String > {
    public List<Municipio> findByRegionId(String  id);
}
