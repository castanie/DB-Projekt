package Projekt.data;

public class Aufenthalt {

    private int buchungNr;
    private int gastNr;

    public Aufenthalt() {

    }

    public Aufenthalt(int buchungNr, int gastNr) {
        this.buchungNr = buchungNr;
        this.gastNr = gastNr;
    }

    // Getters:

    public int getBuchungNr() {
        return buchungNr;
    }

    public int getGastNr() {
        return gastNr;
    }

    // Setters:

}
