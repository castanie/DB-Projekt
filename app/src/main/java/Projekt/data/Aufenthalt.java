package Projekt.data;

public class Aufenthalt {

    private int buchungNr;
    private int gastNr;

    public Aufenthalt(int buchungNr, int gastNr) {
        this.buchungNr = buchungNr;
        this.gastNr = gastNr;
    }

    // Getters:

    public int getGastNr() {
        return gastNr;
    }

    public int getBuchungNr() {
        return buchungNr;
    }
    // Setters:

    public void setGastNr(int gastNr) {
        this.gastNr = gastNr;
    }

    public void setBuchungNr(int buchungNr) {
        this.buchungNr = buchungNr;
    }
}
