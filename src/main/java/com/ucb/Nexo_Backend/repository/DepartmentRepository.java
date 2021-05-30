package com.ucb.Nexo_Backend.repository;

import com.ucb.Nexo_Backend.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,String> {
    @Query("select sum(cases) from Department")
    public Long getCases();
    @Query("select sum(deaths) from Department")
    public Long getDeaths();
    @Query("select sum(recovered) from Department")
    public Long getRecovered();
    @Query("select sum(vaccine) from Department")
    public Long getVaccine();
    @Query("select sum(population) from Department")
    public Long getPopulation();


}
