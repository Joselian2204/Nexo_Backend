package com.ucb.Nexo_Backend.repository;

import com.ucb.Nexo_Backend.models.DepartmentCases;
import com.ucb.Nexo_Backend.models.MunicipalityCases;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface MunicipalityCasesRepository extends JpaRepository<MunicipalityCases,Integer> {
    public List<MunicipalityCases> findByRegionIdOrderByDate(String id);

    public List<MunicipalityCases> findByRegionIdAndDateBetween(String id, Date date1, Date date2);

    public List<MunicipalityCases> findByRegionIdOrderByDateAsc(String Id);
}
