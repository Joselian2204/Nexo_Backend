package com.ucb.Nexo_Backend.dto;

import java.util.Date;

public class PredictionRequest {
    private String id;
    private Date date;
    private long cases;
    private Integer status;

    public PredictionRequest() {
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Prediction{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", cases=" + cases +
                ", status=" + status +
                '}';
    }
}
