package com.ucb.Nexo_Backend.repository;

import com.ucb.Nexo_Backend.models.CountryCases;
import com.ucb.Nexo_Backend.models.DepartmentCases;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface DepartmentCasesRepository extends JpaRepository<DepartmentCases, Integer> {
    public List<DepartmentCases> findByDepartmentIdOrderByDate(String id);

    public List<DepartmentCases> findByDepartmentIdAndDateBetween(String id, Date date1, Date date2);
}
