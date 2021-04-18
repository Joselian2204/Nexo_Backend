package com.ucb.Nexo_Backend.repository;

import com.ucb.Nexo_Backend.models.Municipality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MunicipalityRepository extends JpaRepository<Municipality, String > {
    public List<Municipality> findByRegionId(String  id);
}
