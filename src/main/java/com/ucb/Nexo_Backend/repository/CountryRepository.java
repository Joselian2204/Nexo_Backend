package com.ucb.Nexo_Backend.repository;

import com.ucb.Nexo_Backend.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CountryRepository extends JpaRepository<Country, String> {
    @Query("select sum(cases) from Country")
    public Long getCases();
    @Query("select sum(deaths) from Country")
    public Long getDeaths();
    @Query("select sum(recovered) from Country")
    public Long getRecovered();
    @Query("select sum(vaccine) from Country ")
    public Long getVaccine();

}
