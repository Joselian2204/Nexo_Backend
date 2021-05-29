package com.ucb.Nexo_Backend.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Prediction {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_prediction")
    private String id;
    private Date date;
    private long cases;

    public Prediction() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getCases() {
        return cases;
    }

    public void setCases(long cases) {
        this.cases = cases;
    }

    @Override
    public String toString() {
        return "Prediction{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", cases=" + cases +
                '}';
    }
}
