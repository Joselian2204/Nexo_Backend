package com.ucb.Nexo_Backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Department {
    @Id
    @GeneratedValue
    @Column(name = "id_department")
    private String id;
    @Column(name = "id_country")
    private String countryId;
    private String name;
    private String population;
    @Column(name = "year_census")
    private String censusYear;
    private String latitud;
    private String longitud;

    public Department() {
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId='" + id + '\'' +
                ", countryId='" + countryId + '\'' +
                ", name='" + name + '\'' +
                ", population='" + population + '\'' +
                ", censusYear='" + censusYear + '\'' +
                ", latitud='" + latitud + '\'' +
                ", longitud='" + longitud + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setDepartmentId(String id) {
        this.id =id;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getCensusYear() {
        return censusYear;
    }

    public void setCensusYear(String censusYear) {
        this.censusYear = censusYear;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
}
