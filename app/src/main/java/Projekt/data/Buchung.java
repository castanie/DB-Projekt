package Projekt.data;

import java.sql.Date;

public class Buchung {

    private Integer buchungNr;
    private String uid;
    private String zimmer;
    private Date anreise;
    private Date abreise;
    private Integer gastnr;

    public Buchung(Integer buchungNr, String uid, String zimmer, Date anreise, Date abreise, Integer gastnr) {

        this.buchungNr = buchungNr;
        this.uid = uid;
        this.zimmer = zimmer;
        this.anreise = anreise;
        this.abreise = abreise;
        this.gastnr = gastnr;

    }

    // Getters:

    public Integer getBuchungNr() {
        return buchungNr;
    }

    public String getUid() {
        return uid;
    }

    public String getZimmer() {
        return zimmer;
    }

    public Date getAnreise() {
        return anreise;
    }

    public Date getAbreise() {
        return abreise;
    }

    public Integer getGastNr() {
        return gastnr;
    }
    // Setters:

    public void setBuchungNr(Integer buchungNr) {
        this.buchungNr = buchungNr;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setZimmer(String zimmer) {
        this.zimmer = zimmer;
    }

    public void setAnreise(Date anreise) {
        this.anreise = anreise;
    }

    public void setAbreise(Date abreise) {
        this.abreise = abreise;
    }

    public void setGastNr(Integer gastnr) {
        this.gastnr = gastnr;
    }
}
