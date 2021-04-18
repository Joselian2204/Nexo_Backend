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
    private Integer population;
    @Column(name = "year_census")
    private Integer censusYear;
    private String lat;
    private String lng;
    private Long cases;
    private Long deaths;
    private Long recovered;
    private Long vaccine;
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

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
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
                '}';
    }
}
