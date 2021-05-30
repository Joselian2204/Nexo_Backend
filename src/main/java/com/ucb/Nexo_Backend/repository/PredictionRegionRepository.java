
package com.ucb.Nexo_Backend.repository;
import com.ucb.Nexo_Backend.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PredictionRegionRepository extends JpaRepository<MunicipalityCases,String> {

    public List<MunicipalityCases> findByRegionIdOrderByDateAsc(String Id);

}