package com.ucb.Nexo_Backend.services;

import com.ucb.Nexo_Backend.models.MunicipalityCases;
import com.ucb.Nexo_Backend.repository.MunicipalityCasesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipalityCasesService {
    private MunicipalityCasesRepository repo;
    @Autowired
    public void setRepo(MunicipalityCasesRepository repo){
        this.repo = repo;
    }
    public List<MunicipalityCases> getByRegionId(String id){
        return this.repo.findByRegionIdOrderByDate(id);
    }
}
