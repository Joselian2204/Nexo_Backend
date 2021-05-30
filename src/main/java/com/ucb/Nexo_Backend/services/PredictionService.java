package com.ucb.Nexo_Backend.services;
import com.ucb.Nexo_Backend.models.Country;
import com.ucb.Nexo_Backend.models.CountryCases;
import com.ucb.Nexo_Backend.models.Prediction;

import com.ucb.Nexo_Backend.models.*;
import com.ucb.Nexo_Backend.repository.*;
import com.ucb.Nexo_Backend.util.PredictionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PredictionService {
    private CountryCasesRepository repo;
    private DepartmentCasesRepository repo1;
    private MunicipalityCasesRepository repo2;

    @Autowired
    public void setRepo(CountryCasesRepository repo,DepartmentCasesRepository repo1,MunicipalityCasesRepository repo2) {
        this.repo = repo;
        this.repo1 = repo1;
        this.repo2 =repo2;
    }
    public List<Prediction> getByDateCountryId(String id,Integer cant,Integer filter){
        List<CountryCases> listcases= new ArrayList<>();
        listcases= repo.findByCountryIdOrderByDateAsc(id);
        List<Prediction> listcasespredic= PredictionUtil.predictionCAR1(listcases,cant,filter);
        return listcasespredic;

    }
    public List<Prediction> getLinealPredictionByDateCountryId(String id,Integer cant){
        List<CountryCases>  listcases= repo.findByCountryIdOrderByDateAsc(id);
        List<Prediction> listcasespredic= PredictionUtil.predictionMatrices(listcases,cant);
        return listcasespredic;

    }
    public List<Prediction> getByDateDepartmentId(String id,Integer cant,Integer filter){
        List<DepartmentCases> listcases1= new ArrayList<>();
        listcases1 = repo1.findByDepartmentIdOrderByDate(id);
        List<Prediction> listcasespredic2= PredictionUtil.predictionDAR1(listcases1,cant,filter);
        return listcasespredic2;

    }
    public List<Prediction> getByDateMunicipalityId(String id,Integer cant,Integer filter){
        List<MunicipalityCases> listcases2= new ArrayList<>();
        listcases2= repo2.findByRegionIdOrderByDateAsc(id);
        List<Prediction> listcasespredic3= PredictionUtil.predictionMAR1(listcases2,cant,filter);
        return listcasespredic3;

    }

}

