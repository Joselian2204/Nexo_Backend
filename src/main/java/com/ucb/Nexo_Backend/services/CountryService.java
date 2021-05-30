package com.ucb.Nexo_Backend.services;

import com.ucb.Nexo_Backend.models.Country;
import com.ucb.Nexo_Backend.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    private CountryRepository repo;
    @Autowired
    public void setRepo(CountryRepository repo){
        this.repo = repo;
    }
    public List<Country> getAll(){
        return this.repo.findAll();
    }
    public Country getTotal(){
        Country total = new Country();
        total.setPopulation(7673533970L);
        total.setCases(repo.getCases());
        total.setDeaths(repo.getDeaths());
        total.setRecovered(repo.getRecovered());
        total.setVaccine(repo.getVaccine());
        return total;
    }
}
