package com.ucb.Nexo_Backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Pharmacy {
    @Id
    @GeneratedValue
    @Column(name = "id_pharmacy")
    private int idPharmacy;
    @Column(name = "id_department")
    private String idDepartment;
    private String name ;
    private String location ;
    @Column(name = "phone_number")
    private String phoneNumber ;
    private String lng;
    @Column(name = "tx_date")
    private Date txDate;
    @Column(name = "tx_id_administrator")
    private int txIdAdministrator;
    @Column(name = "tx_host")
    private String txHost;
    @Column(name = "tx_update")
    private Date txUpdate;

    public Pharmacy() {

    }

    public int getIdPharmacy() {
        return idPharmacy;
    }

    public void setIdPharmacy(int idPharmacy) {
        this.idPharmacy = idPharmacy;
    }

    public String getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(String idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public Date getTxDate() {
        return txDate;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }

    public int getTxIdAdministrator() {
        return txIdAdministrator;
    }

    public void setTxIdAdministrator(int txIdAdministrator) {
        this.txIdAdministrator = txIdAdministrator;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    public Date getTxUpdate() {
        return txUpdate;
    }

    public void setTxUpdate(Date txUpdate) {
        this.txUpdate = txUpdate;
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "idPharmacy=" + idPharmacy +
                ", idDepartment='" + idDepartment + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", lng='" + lng + '\'' +
                ", txDate=" + txDate +
                ", txIdAdministrator=" + txIdAdministrator +
                ", txHost='" + txHost + '\'' +
                ", txUpdate=" + txUpdate +
                '}';
    }
}
