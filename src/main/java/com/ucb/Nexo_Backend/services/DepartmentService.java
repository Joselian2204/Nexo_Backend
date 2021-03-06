package com.ucb.Nexo_Backend.services;

import com.ucb.Nexo_Backend.models.Department;
import com.ucb.Nexo_Backend.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private DepartmentRepository repo;
    @Autowired
    public void setRepo(DepartmentRepository repo){
        this.repo = repo;
    }
    public List<Department> getAll(){
        return repo.findAll();
    }
    public Department getTotal(){
        Department total = new Department();
        total.setPopulation(repo.getPopulation());
        total.setCases(repo.getCases());
        total.setDeaths(repo.getDeaths());
        total.setRecovered(repo.getRecovered());
        total.setVaccine(repo.getVaccine());
        return total;
    }
}