package com.ucb.Nexo_Backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Municipality {
    @Id
    @GeneratedValue
    @Column(name = "id_municipality")
    private String id;
    @Column(name = "id_department")
    private String regionId;
    private String name;
    private Integer population;
    private Float lat;
    private Float lng;

    public Municipality() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
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

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLng() {
        return lng;
    }

    public void setLng(Float lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Municipio{" +
                "id='" + id + '\'' +
                ", regionId='" + regionId + '\'' +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}