package Projekt.data;

import java.sql.Date;

public class Preis {

    private String katbez;
    private Date vondatum;
    private Date bisdatum;
    private String pensionsart;
    private Double preis;

    public Preis(String katbez, Date vondatum, Date bisdatum, String pensionsart, Double preis) {

        this.katbez = katbez;
        this.vondatum = vondatum;
        this.bisdatum = bisdatum;
        this.pensionsart = pensionsart;
        this.preis = preis;

    }

    // Getters:

    public String getKatbez() {
        return katbez;
    }

    public Date getVondatum() {
        return vondatum;
    }

    public Date getBisdatum() {
        return bisdatum;
    }

    public String getPensionsart() {
        return pensionsart;
    }

    public Double getPreis() {
        return preis;
    }

// Setters:


    public void setKatbez(String katbez) {
        this.katbez = katbez;
    }

    public void setVondatum(Date vondatum) {
        this.vondatum = vondatum;
    }

    public void setBisdatum(Date bisdatum) {
        this.bisdatum = bisdatum;
    }

    public void setPensionsart(String pensionsart) {
        this.pensionsart = pensionsart;
    }

    public void setPreis(Double preis) {
        this.preis = preis;
    }
}
