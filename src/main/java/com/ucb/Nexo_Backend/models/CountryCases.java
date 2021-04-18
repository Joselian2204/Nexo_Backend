package com.ucb.Nexo_Backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "day_country")
public class CountryCases {
    @Id
    @Column(name = "id_day_country")
    private Integer id;
    @Column(name = "id_country")
    private String countryId;
    private Date date;
    @Column(name = "cases")
    private Long newCases;
    private Long actives;
    private Long deaths;
    private Long recovered;
    private Long vaccine;

    public CountryCases() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
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
        return "CountryCases{" +
                "id=" + id +
                ", countryId='" + countryId + '\'' +
                ", date=" + date +
                ", newCases=" + newCases +
                ", actives=" + actives +
                ", deaths=" + deaths +
                ", recovered=" + recovered +
                ", vaccine=" + vaccine +
                '}';
    }
}
