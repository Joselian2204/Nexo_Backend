package com.ucb.Nexo_Backend.repository;

import com.ucb.Nexo_Backend.models.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface PharmacyRepository extends JpaRepository<Pharmacy,Integer> {
    public List<Pharmacy> findByStatus(int status);

    @Modifying
    @Transactional
    @Query("update Pharmacy f SET f.status = ?1 WHERE f.idPharmacy = ?2")
    public void updateStatus(Integer status, Integer idPharmacy);
}
