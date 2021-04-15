package com.ucb.Nexo_Backend.services;

import com.ucb.Nexo_Backend.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    private CountryRepository repo;
    @Autowired
    public void setRepo(CountryRepository repo){
        this.repo = repo;
    }
    public void getAll(){
        this.repo.findAll();
    }
}
