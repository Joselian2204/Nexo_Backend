package com.ucb.Nexo_Backend.services;

import com.ucb.Nexo_Backend.models.Municipality;
import com.ucb.Nexo_Backend.repository.MunicipalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipalityService {
    private MunicipalityRepository repo;
    @Autowired
    public void setRepo(MunicipalityRepository repo){
        this.repo = repo;
    }
    public List<Municipality> getAll(){
        return this.repo.findAll();
    }
    public List<Municipality> getByDepartmentId(String id){
        return repo.findByRegionId(id);
    }
}
