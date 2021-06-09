package com.ucb.Nexo_Backend.services;
import com.ucb.Nexo_Backend.dto.LinealRequest;
import com.ucb.Nexo_Backend.dto.PredictionRequest;
import com.ucb.Nexo_Backend.models.CountryCases;

import com.ucb.Nexo_Backend.models.*;
import com.ucb.Nexo_Backend.repository.*;
import com.ucb.Nexo_Backend.util.PrediccionLinealUtil;
import com.ucb.Nexo_Backend.util.PredictionGrayUtil;
import com.ucb.Nexo_Backend.util.PredictionUtil;
import com.ucb.Nexo_Backend.util.PredictionVariables;
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


    //ar1
    public List<PredictionRequest> getAR1ByDateCountryId(String id,Integer cant,Integer filter){
        List<CountryCases> listcases= new ArrayList<>();
        listcases= repo.findByCountryIdOrderByDateAsc(id);
        List<PredictionRequest> listcasespredic= PredictionUtil.predictionCAR1(listcases,cant,filter,1);
        return listcasespredic;

    }
    public List<PredictionRequest> getAR1ByDateDepartmentId(String id,Integer cant,Integer filter){
        List<DepartmentCases> listcases1= new ArrayList<>();
        listcases1 = repo1.findByDepartmentIdOrderByDate(id);
        List<PredictionRequest> listcasespredic2= PredictionUtil.predictionDAR1(listcases1,cant,filter,1);
        return listcasespredic2;

    }
    public List<PredictionRequest> getAR1ByDateMunicipalityId(String id,Integer cant,Integer filter){
        List<MunicipalityCases> listcases2= new ArrayList<>();
        listcases2= repo2.findByRegionIdOrderByDateAsc(id);
        List<PredictionRequest> listcasespredic3= PredictionUtil.predictionMAR1(listcases2,cant,filter,1);
        return listcasespredic3;

    }

    //ar2
    public List<PredictionRequest> getAR2ByDateCountryId(String id,Integer cant,Integer filter){
        List<CountryCases> listcases= new ArrayList<>();
        listcases= repo.findByCountryIdOrderByDateAsc(id);
        List<PredictionRequest> listcasespredic= PredictionUtil.predictionCAR1(listcases,cant,filter,2);
        return listcasespredic;

    }
    public List<PredictionRequest> getAR2ByDateDepartmentId(String id,Integer cant,Integer filter){
        List<DepartmentCases> listcases1= new ArrayList<>();
        listcases1 = repo1.findByDepartmentIdOrderByDate(id);
        List<PredictionRequest> listcasespredic2= PredictionUtil.predictionDAR1(listcases1,cant,filter,2);
        return listcasespredic2;

    }
    public List<PredictionRequest> getAR2ByDateMunicipalityId(String id,Integer cant,Integer filter){
        List<MunicipalityCases> listcases2= new ArrayList<>();
        listcases2= repo2.findByRegionIdOrderByDateAsc(id);
        List<PredictionRequest> listcasespredic3= PredictionUtil.predictionMAR1(listcases2,cant,filter,2);
        return listcasespredic3;

    }

    //arima
    public List<PredictionRequest> getARIMAByDateCountryId(String id,Integer cant,Integer filter){
        List<CountryCases> listcases= new ArrayList<>();
        listcases= repo.findByCountryIdOrderByDateAsc(id);
        List<PredictionRequest> listcasespredic= PredictionUtil.predictionCAR1(listcases,cant,filter,0);
        return listcasespredic;

    }
    public List<PredictionRequest> getARIMAByDateDepartmentId(String id,Integer cant,Integer filter){
        List<DepartmentCases> listcases1= new ArrayList<>();
        listcases1 = repo1.findByDepartmentIdOrderByDate(id);
        List<PredictionRequest> listcasespredic2= PredictionUtil.predictionDAR1(listcases1,cant,filter,0);
        return listcasespredic2;

    }
    public List<PredictionRequest> getARIMAByDateMunicipalityId(String id,Integer cant,Integer filter){
        List<MunicipalityCases> listcases2= new ArrayList<>();
        listcases2= repo2.findByRegionIdOrderByDateAsc(id);
        List<PredictionRequest> listcasespredic3= PredictionUtil.predictionMAR1(listcases2,cant,filter,0);
        return listcasespredic3;

    }



    public List<PredictionRequest> getLinealPredictionByDateCountryId(String id, Integer cant, Integer filter){
        List<CountryCases>  listcases= repo.findByCountryIdOrderByDateAsc(id);
        List<PredictionRequest> listcasespredic= PrediccionLinealUtil.predictionMatrixCountries(listcases,cant, filter);
        return listcasespredic;

    }
    public List<PredictionRequest> getLinealPredictionByDateDepartmentId(String id, Integer cant, Integer filter){
        List<DepartmentCases>  listcases = repo1.findByDepartmentIdOrderByDate(id);
        List<PredictionRequest> listcasespredic= PrediccionLinealUtil.predictionMatrixDepartments(listcases,cant, filter);
        return listcasespredic;

    }
    public List<PredictionRequest> getLinealPredictionByDateMunicipalityId(String id, Integer cant, Integer filter){
        List<MunicipalityCases>  listcases= repo2.findByRegionIdOrderByDateAsc(id);
        List<PredictionRequest> listcasespredic= PrediccionLinealUtil.predictionMatrixMunicipality(listcases,cant, filter);
        return listcasespredic;

    }


    public List<PredictionRequest> getGRAYByDateCountryId(String id,Integer cant,Integer filter){
        List<CountryCases> listcases= new ArrayList<>();
        listcases= repo.findByCountryIdOrderByDateAsc(id);
        List<PredictionRequest> listcasespredic= PredictionGrayUtil.predictionCGRAY(listcases,cant,filter);
        return listcasespredic;

    }
    public List<PredictionRequest> getGRAYByDateDepartmentId(String id,Integer cant,Integer filter){
        List<DepartmentCases> listcases1= new ArrayList<>();
        listcases1 = repo1.findByDepartmentIdOrderByDate(id);
        List<PredictionRequest> listcasespredic2= PredictionGrayUtil.predictionDGRAY(listcases1,cant,filter);
        return listcasespredic2;

    }
    public List<PredictionRequest> getGRAYByDateMunicipalityId(String id,Integer cant,Integer filter){
        List<MunicipalityCases> listcases2= new ArrayList<>();
        listcases2= repo2.findByRegionIdOrderByDateAsc(id);
        List<PredictionRequest> listcasespredic3= PredictionGrayUtil.predictionMGRAY(listcases2,cant,filter);
        return listcasespredic3;

    }

    public LinealRequest getLinealVPredictionByDateCountryId(String id, Integer filter){
        List<CountryCases>  listcases= repo.findByCountryIdOrderByDateAsc(id);
        LinealRequest linealRequest = PredictionVariables.generarBetasCountry(listcases,filter);
        return linealRequest;

    }
    public LinealRequest getLinealVPredictionByDateDepartmentId(String id,  Integer filter){
        List<DepartmentCases>  listcases = repo1.findByDepartmentIdOrderByDate(id);
        LinealRequest linealRequest = PredictionVariables.generarBetasDepartament(listcases,filter);
        return linealRequest;

    }
    public LinealRequest getLinealVPredictionByDateMunicipalityId(String id, Integer filter){
        List<MunicipalityCases>  listcases= repo2.findByRegionIdOrderByDateAsc(id);
        LinealRequest linealRequest = PredictionVariables.generarBetasMunicipios(listcases,filter);
        return linealRequest;

    }






}

