package Projekt.data;

import java.sql.Date;

public class Buchung {

    private Integer buchungNr;
    private String uid;
    private String zimmer;
    private Date anreise;
    private Date abreise;
    private Integer gastnr;

    public Buchung() {
        
    }

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
    
    public Integer getGastnr() {
        return gastnr;
    }

    // Setters:

}
