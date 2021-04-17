package com.ucb.Nexo_Backend.services;

import com.ucb.Nexo_Backend.models.MunicipioCases;
import com.ucb.Nexo_Backend.repository.MunicipioCasesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipioCasesService {
    private MunicipioCasesRepository repo;
    @Autowired
    public void setRepo(MunicipioCasesRepository repo){
        this.repo = repo;
    }
    public List<MunicipioCases> getByRegionId(String id){
        return this.repo.findByRegionIdOrderByDate(id);
    }
}
