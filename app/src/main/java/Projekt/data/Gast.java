package Projekt.data;

import java.sql.Date;

public class Gast {

    private Integer gastnr;
    private String vorname;
    private String nachname;
    private String titel;
    private Date geburtsdatum;
    private String wohnadresse;
    private String tel;
    private String email;

    public Gast(Integer gastnr, String vorname, String nachname, String titel, Date geburtsdatum, String wohnadresse, String tel, String email) {

        this.gastnr = gastnr;
        this.vorname = vorname;
        this.nachname = nachname;
        this.titel = titel;
        this.geburtsdatum = geburtsdatum;
        this.wohnadresse = wohnadresse;
        this.tel = tel;
        this.email = email;

    }

    // Getters:

    public Integer getGastnr() {
        return gastnr;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getTitel() {
        return titel;
    }

    public Date getGeburtsdatum() {
        return geburtsdatum;
    }

    public String getWohnadresse() {
        return wohnadresse;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

// Setters:

    public void setGastnr(Integer gastnr) {
        this.gastnr = gastnr;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setGeburtsdatum(Date geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public void setWohnadresse(String wohnadresse) {
        this.wohnadresse = wohnadresse;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
