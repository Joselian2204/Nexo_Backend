package com.ucb.Nexo_Backend.repository;
import com.ucb.Nexo_Backend.models.Prediction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PredictionRepository extends JpaRepository<Prediction,String> {

    public List<Prediction> findByIdOrderByDateAsc(String id);
}
