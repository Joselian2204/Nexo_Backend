package com.ucb.Nexo_Backend.services;
import com.ucb.Nexo_Backend.models.Country;
import com.ucb.Nexo_Backend.models.CountryCases;
import com.ucb.Nexo_Backend.models.Prediction;
import com.ucb.Nexo_Backend.repository.PharmacyRepository;
import com.ucb.Nexo_Backend.repository.PredictionRepository;
import com.ucb.Nexo_Backend.repository.TransactionRepository;
import com.ucb.Nexo_Backend.util.PredictionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PredictionService {
    private PredictionRepository repo;

    @Autowired
    public void setRepo(PredictionRepository repo) {
        this.repo = repo;
    }
    public List<Prediction> getByDateCountryId(String id,Integer cant){
        List<CountryCases> listcases= new ArrayList<>();
        listcases= repo.findByCountryIdOrderByDateAsc(id);
        List<Prediction> listcasespredic= PredictionUtil.predictionAR1(listcases,cant);
        return listcasespredic;

    }

}

