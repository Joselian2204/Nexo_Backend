package com.ucb.Nexo_Backend.services;

import com.ucb.Nexo_Backend.models.DepartmentCases;
import com.ucb.Nexo_Backend.repository.DepartmentCasesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class DepartmentCasesService {
    private DepartmentCasesRepository repo;
    @Autowired
    public void setRepo(DepartmentCasesRepository repo){
        this.repo = repo;
    }
    public List<DepartmentCases> getByDepartmentId(String id){
        return repo.findByDepartmentIdOrderByDate(id);
    }

    public List<DepartmentCases> getByDateId(String id, String date1, String date2) throws ParseException {
        Date d1=new SimpleDateFormat("yyyy-MM-dd").parse(date1);
        Date d2=new SimpleDateFormat("yyyy-MM-dd").parse(date2);
        return repo.findByDepartmentIdAndDateBetween(id,d1, d2);

    }
    public DepartmentCases getAverage(String id){

        DepartmentCases departmentCases = new DepartmentCases();
        departmentCases.setNewCases(repo.getCasesAverage(id));
        departmentCases.setDeaths(repo.getDeathsAverage(id));
        departmentCases.setVaccine(repo.getVaccineAverage(id));
        departmentCases.setRecovered(repo.getRecoveredAverage(id));
        return departmentCases;
    }
}
