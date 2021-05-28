package com.ucb.Nexo_Backend.repository;

import com.ucb.Nexo_Backend.models.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRepository extends JpaRepository<Administrator, Integer>{

//    @Query("SELECT LAST_INSERT_ID ()")
  //  public Integer getLastInsertId();
}
