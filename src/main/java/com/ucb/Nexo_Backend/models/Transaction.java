package com.ucb.Nexo_Backend.models;
import java.util.Date;

public class Transaction {
    private Date txDate;
    private int txIdAdmi;
    private String txHost;
    private Date txUpdate;

    public Transaction() {
    }

    public int getTxIdAdmi() {
        return txIdAdmi;
    }

    public void setTxIdAdmi(int txIdAdmi) {
        this.txIdAdmi = txIdAdmi;
    }

    public Date getTxDate() {
        return txDate;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
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
        return "Transaction{" +
                "txDate=" + txDate +
                ", txIdAdmi=" + txIdAdmi +
                ", txHost='" + txHost + '\'' +
                ", txUpdate=" + txUpdate +
                '}';
    }
}
