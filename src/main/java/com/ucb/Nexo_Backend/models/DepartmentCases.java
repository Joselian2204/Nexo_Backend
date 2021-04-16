package com.ucb.Nexo_Backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "day_department")
public class DepartmentCases {
    @Id
    @Column(name = "id_day_department")
    private Integer id;
    @Column(name = "id_department")
    private String departmentId;
    private Date date;

    public DepartmentCases() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
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
        return "DepartmentCases{" +
                "id=" + id +
                ", departmentId='" + departmentId + '\'' +
                ", date=" + date +
                ", newCases=" + newCases +
                ", actives=" + actives +
                ", deaths=" + deaths +
                ", recovered=" + recovered +
                ", vaccine=" + vaccine +
                '}';
    }

    @Column(name = "new_cases")
    private Long newCases;
    private Long actives;
    private Long deaths;
    private Long recovered;
    private Long vaccine;
}
