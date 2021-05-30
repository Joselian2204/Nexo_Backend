package com.ucb.Nexo_Backend.services;

import com.ucb.Nexo_Backend.models.MunicipalityCases;
import com.ucb.Nexo_Backend.repository.MunicipalityCasesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public List<MunicipalityCases> getByDateId(String id, String date1, String date2) throws ParseException {
        Date d1=new SimpleDateFormat("yyyy-MM-dd").parse(date1);
        Date d2=new SimpleDateFormat("yyyy-MM-dd").parse(date2);
        return repo.findByRegionIdAndDateBetween(id,d1, d2);

    }
    public MunicipalityCases getAverage(String id){

        MunicipalityCases municipalityCases= new MunicipalityCases();
        municipalityCases.setNewCases(repo.getCasesAverage(id));
        municipalityCases.setDeaths(repo.getDeathsAverage(id));
        municipalityCases.setVaccine(repo.getVaccineAverage(id));
        municipalityCases.setRecovered(repo.getRecoveredAverage(id));
        return municipalityCases;
    }
}
