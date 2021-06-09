package com.ucb.Nexo_Backend.dto;

public class LinealRequest {
    private float B0 ;
    private float B1 ;
    private float R2 ;
    private float o2;
    private float o;


    public float getO2() {
        return o2;
    }

    public void setO2(float o2) {
        this.o2 = o2;
    }

    public float getO() {
        return o;
    }

    public void setO(float o) {
        this.o = o;
    }

    public float getB0() {

        return B0;
    }

    public void setB0(float b0) {
        B0 = b0;
    }

    public float getB1() {
        return B1;
    }

    public void setB1(float b1) {
        B1 = b1;
    }

    public float getR2() {
        return R2;
    }

    public void setR2(float r2) {
        R2 = r2;
    }

    public LinealRequest() {

    }

    @Override
    public String toString() {
        return "LinealRequest{" +
                "B0=" + B0 +
                ", B1=" + B1 +
                ", R2=" + R2 +
                ", o2=" + o2 +
                ", o=" + o +
                '}';
    }
}
