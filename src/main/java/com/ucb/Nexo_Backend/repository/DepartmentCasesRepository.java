package com.ucb.Nexo_Backend.repository;

import com.ucb.Nexo_Backend.models.DepartmentCases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface DepartmentCasesRepository extends JpaRepository<DepartmentCases, Integer> {
    public List<DepartmentCases> findByDepartmentIdOrderByDate(String id);

    public List<DepartmentCases> findByDepartmentIdAndDateBetween(String id, Date date1, Date date2);

    @Query("select avg(newCases) from DepartmentCases where  departmentId= ?1")
    public Long getCasesAverage(String countryId);

    @Query("select avg(deaths) from DepartmentCases where  departmentId= ?1")
    public Long getDeathsAverage(String countryId);

    @Query("select avg(vaccine) from DepartmentCases where  departmentId= ?1")
    public Long getVaccineAverage(String countryId);

    @Query("select avg(recovered) from DepartmentCases where  departmentId= ?1")
    public Long getRecoveredAverage(String countryId);
}
