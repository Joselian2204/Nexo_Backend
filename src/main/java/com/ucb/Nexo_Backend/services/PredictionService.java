package com.ucb.Nexo_Backend.services;
import com.ucb.Nexo_Backend.models.Prediction;
import com.ucb.Nexo_Backend.repository.PredictionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PredictionService {
    private PredictionRepository repo;

    @Autowired
    public void setRepo(PredictionRepository repo) {
        this.repo = repo;
    }
    public List<Prediction> getByDateCountryId(String id){


        return repo.findByIdOrderByDateAsc(id);
    }

}

