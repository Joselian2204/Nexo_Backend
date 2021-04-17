package com.ucb.Nexo_Backend.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "day_municipio")
public class MunicipioCases {
    @Id
    @GeneratedValue
    @Column(name = "id_day_municipio")
    private Integer id;
    @Column(name = "id_municipio")
    private String regionId;
    private Date date;
    @Column(name = "new_cases")
    private Long newCases;
    private Long actives;
    private Long deaths;
    private Long recovered;
    private Long vaccine;

    public MunicipioCases() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getNewCases() {
        return newCases;
    }

    public void setNewCases(Long newCases) {
        this.newCases = newCases;
    }

    public Long getActives() {
        return actives;
    }

    public void setActives(Long actives) {
        this.actives = actives;
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
        return "MunicipioCases{" +
                "id=" + id +
                ", regionId='" + regionId + '\'' +
                ", date=" + date +
                ", newCases=" + newCases +
                ", actives=" + actives +
                ", deaths=" + deaths +
                ", recovered=" + recovered +
                ", vaccine=" + vaccine +
                '}';
    }
}
