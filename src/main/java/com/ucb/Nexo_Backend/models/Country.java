package com.ucb.Nexo_Backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Country {
    @Id
    @GeneratedValue
    @Column(name = "id_country")
    private String id;
    @Column(name = "id_continent")
    private String continentId;
    private String name;
    private Long population;
    @Column(name = "year_census")
    private Integer censusYear;
    private String lat;
    private String lng;
    private Long cases;
    private Long deaths;
    private Long recovered;
    private Long vaccine;

    public Country() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContinentId() {
        return continentId;
    }

    public void setContinentId(String continentId) {
        this.continentId = continentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Integer getCensusYear() {
        return censusYear;
    }

    public void setCensusYear(Integer censusYear) {
        this.censusYear = censusYear;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public Long getCases() {
        return cases;
    }

    public void setCases(Long cases) {
        this.cases = cases;
    }

    public Long getDeaths() {
        return deaths;
    }

    public void setDeaths(Long deaths) {
        this.deaths = deaths;
    }

    public Long getRecovered() {
        return recovered;
    }

    public void setRecovered(Long recovered) {
        this.recovered = recovered;
    }

    public Long getVaccine() {
        return vaccine;
    }

    public void setVaccine(Long vaccine) {
        this.vaccine = vaccine;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id='" + id + '\'' +
                ", continentId='" + continentId + '\'' +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", censusYear=" + censusYear +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", cases=" + cases +
                ", deaths=" + deaths +
                ", recovered=" + recovered +
                ", vaccine=" + vaccine +
                '}';
    }
}
