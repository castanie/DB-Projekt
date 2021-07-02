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

    // Setters:


    public void setAnreise(Date anreise) {
        this.anreise = anreise;
    }

    public void setAbreise(Date abreise) {
        this.abreise = abreise;
    }
}
