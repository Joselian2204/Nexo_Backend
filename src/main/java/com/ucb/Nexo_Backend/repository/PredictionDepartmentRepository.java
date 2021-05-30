package com.ucb.Nexo_Backend.repository;
import com.ucb.Nexo_Backend.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PredictionDepartmentRepository extends JpaRepository<DepartmentCases,String> {

    public List<DepartmentCases> findByDepartmentIdOrderByDateAsc(String Id);



}
