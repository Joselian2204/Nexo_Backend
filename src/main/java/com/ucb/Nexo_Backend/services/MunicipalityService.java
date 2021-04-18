package com.ucb.Nexo_Backend.services;

import com.ucb.Nexo_Backend.models.Municipality;
import com.ucb.Nexo_Backend.repository.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipalityService {
    private MunicipioRepository repo;
    @Autowired
    public void setRepo(MunicipioRepository repo){
        this.repo = repo;
    }
    public List<Municipality> getAll(){
        return this.repo.findAll();
    }
    public List<Municipality> getByDepartmentId(String id){
        return repo.findByRegionId(id);
    }
}
