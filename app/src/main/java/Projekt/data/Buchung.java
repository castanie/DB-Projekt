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

    public void setAnreise(Date anreise) {
        this.anreise = anreise;
    }

    public void setAbreise(Date abreise) {
        this.abreise = abreise;
    }

    // Helpers:

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;

        if (obj instanceof Buchung) {
            Buchung com = (Buchung) obj;
            if (this.abreise.equals(com.getAbreise()) && this.anreise.equals(com.getAnreise())
                    && this.buchungNr.equals(com.getBuchungNr()) && this.gastnr.equals(com.getGastnr())
                    && this.uid.equals(com.getUid()) && this.zimmer.equals(com.getZimmer())) {
                equal = true;
            }
        }

        return equal;
    }

}
