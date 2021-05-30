package com.ucb.Nexo_Backend.services;

import com.ucb.Nexo_Backend.models.CountryCases;
import com.ucb.Nexo_Backend.repository.CountryCasesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CountryCasesService {
    private CountryCasesRepository repo;
    @Autowired
    public void setRepo(CountryCasesRepository repo){
        this.repo = repo;
    }
    public List<CountryCases> getByCountryId(String id){
        return repo.findByCountryIdOrderByDate(id);
    }
    public List<CountryCases> getByDateId(String id, String date1, String date2) throws ParseException {
        Date d1=new SimpleDateFormat("yyyy-MM-dd").parse(date1);
        Date d2=new SimpleDateFormat("yyyy-MM-dd").parse(date2);
        return repo.findByCountryIdAndDateBetween(id,d1, d2);

    }
    public CountryCases getAverage(String id){
        System.out.println("Estoy en servicio");
        CountryCases countryCases = new CountryCases();
        countryCases.setNewCases(repo.getCasesAverage(id));
        countryCases.setDeaths(repo.getDeathsAverage(id));
        countryCases.setVaccine(repo.getVaccineAverage(id));
        countryCases.setRecovered(repo.getRecoveredAverage(id));
        return countryCases;
    }
}
