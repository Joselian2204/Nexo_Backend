package com.ucb.Nexo_Backend.services;
import com.ucb.Nexo_Backend.models.*;
import com.ucb.Nexo_Backend.repository.MunicipalityCasesRepository;
import com.ucb.Nexo_Backend.repository.PredictionCountryRepository;
import com.ucb.Nexo_Backend.repository.PredictionDepartmentRepository;
import com.ucb.Nexo_Backend.repository.PredictionRegionRepository;
import com.ucb.Nexo_Backend.util.PredictionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PredictionService {
    private PredictionCountryRepository repo;
    private PredictionDepartmentRepository repo1;
    private MunicipalityCasesRepository repo2;

    @Autowired
    public void setRepo(PredictionCountryRepository repo) {
        this.repo = repo;
    }
    public List<Prediction> getByDateCountryId(String id,Integer cant,Integer filter){
        List<CountryCases> listcases= new ArrayList<>();
        listcases= repo.findByCountryIdOrderByDateAsc(id);
        List<Prediction> listcasespredic= PredictionUtil.predictionCAR1(listcases,cant,filter);
        return listcasespredic;

    }
    public List<DepartmentCases> getByDateDepartmentId(String id,Integer cant,Integer filter){
        List<DepartmentCases> listcases1= new ArrayList<>();
        listcases1 = repo1.findByDepartmentIdOrderByDateAsc(id);
        //List<Prediction> listcasespredic2= PredictionUtil.predictionDAR1(listcases1,cant,filter);
        return listcases1;

    }
    public List<MunicipalityCases> getByDateMunicipalityId(String id,Integer cant,Integer filter){
        List<MunicipalityCases> listcases2= new ArrayList<>();
        listcases2= repo2.findByRegionIdOrderByDateAsc(id);
        //List<Prediction> listcasespredic3= PredictionUtil.predictionMAR1(listcases2,cant,filter);
        return listcases2;

    }

}

