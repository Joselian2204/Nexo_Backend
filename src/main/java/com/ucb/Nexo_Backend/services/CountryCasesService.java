package com.ucb.Nexo_Backend.services;

import com.ucb.Nexo_Backend.models.CountryCases;
import com.ucb.Nexo_Backend.repository.CountryCasesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryCasesService {
    private CountryCasesRepository repo;
    @Autowired
    public void setRepo(CountryCasesRepository repo){
        this.repo = repo;
    }
    public List<CountryCases> getByCountryId(String id){
        return repo.findByCountryId(id);
    }
}
