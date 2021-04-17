package com.ucb.Nexo_Backend.services;

import com.ucb.Nexo_Backend.models.Municipio;
import com.ucb.Nexo_Backend.repository.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipioService {
    private MunicipioRepository repo;
    @Autowired
    public void setRepo(MunicipioRepository repo){
        this.repo = repo;
    }
    public List<Municipio> getAll(){
        return this.repo.findAll();
    }
}
