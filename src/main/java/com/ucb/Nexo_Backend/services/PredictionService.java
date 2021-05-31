package com.ucb.Nexo_Backend.services;
import com.ucb.Nexo_Backend.dto.PredictionRequest;
import com.ucb.Nexo_Backend.models.CountryCases;

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
    public List<PredictionRequest> getByDateCountryId(String id,Integer cant,Integer filter){
        List<CountryCases> listcases= new ArrayList<>();
        listcases= repo.findByCountryIdOrderByDateAsc(id);
        List<PredictionRequest> listcasespredic= PredictionUtil.predictionCAR1(listcases,cant,filter);
        return listcasespredic;

    }
    public List<PredictionRequest> getByDateDepartmentId(String id,Integer cant,Integer filter){
        List<DepartmentCases> listcases1= new ArrayList<>();
        listcases1 = repo1.findByDepartmentIdOrderByDate(id);
        List<PredictionRequest> listcasespredic2= PredictionUtil.predictionDAR1(listcases1,cant,filter);
        return listcasespredic2;

    }
    public List<PredictionRequest> getByDateMunicipalityId(String id,Integer cant,Integer filter){
        List<MunicipalityCases> listcases2= new ArrayList<>();
        listcases2= repo2.findByRegionIdOrderByDateAsc(id);
        List<PredictionRequest> listcasespredic3= PredictionUtil.predictionMAR1(listcases2,cant,filter);
        return listcasespredic3;

    }
    public List<PredictionRequest> getLinealPredictionByDateCountryId(String id, Integer cant, Integer filter){
        List<CountryCases>  listcases= repo.findByCountryIdOrderByDateAsc(id);
        List<PredictionRequest> listcasespredic= PredictionUtil.predictionMatrixCountries(listcases,cant, filter);
        return listcasespredic;

    }
    public List<PredictionRequest> getLinealPredictionByDateDepartmentId(String id, Integer cant, Integer filter){
        List<DepartmentCases>  listcases = repo1.findByDepartmentIdOrderByDate(id);
        List<PredictionRequest> listcasespredic= PredictionUtil.predictionMatrixDepartments(listcases,cant, filter);
        return listcasespredic;

    }
    public List<PredictionRequest> getLinealPredictionByDateMunicipalityId(String id, Integer cant, Integer filter){
        List<MunicipalityCases>  listcases= repo2.findByRegionIdOrderByDateAsc(id);
        List<PredictionRequest> listcasespredic= PredictionUtil.predictionMatrixMunicipality(listcases,cant, filter);
        return listcasespredic;

    }

}

