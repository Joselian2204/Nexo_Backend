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
        total.setCases(repo.getCases());
        total.setDeaths(repo.getCases());
        total.setRecovered(repo.getCases());
        total.setVaccine(repo.getCases());
        return total;
    }
}
