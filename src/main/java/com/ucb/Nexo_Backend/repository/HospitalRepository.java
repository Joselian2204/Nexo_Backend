package com.ucb.Nexo_Backend.repository;
import com.ucb.Nexo_Backend.models.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital,Integer> {
    public List<Hospital> findByStatus(int status);

    @Modifying
    @Transactional
    @Query("update Hospital h SET h.status = ?1, h.txHost = ?3, h.txIdAdministrator = ?4, h.txUpdate = ?5 WHERE h.idHospital = ?2")
    public void updateStatus(Integer status, Integer idHospital, String txHost, Integer txIdAdmi, Date txUpdate);
}
