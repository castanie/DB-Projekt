package Projekt.data;

public class Aufenthalt {

    private Integer buchungNr;
    private Integer gastNr;

    public Aufenthalt() {

    }

    public Aufenthalt(Integer buchungNr, Integer gastNr) {
        this.buchungNr = buchungNr;
        this.gastNr = gastNr;
    }

    // Getters:

    public Integer getBuchungNr() {
        return buchungNr;
    }

    public Integer getGastNr() {
        return gastNr;
    }

    // Setters:

    // Helpers:

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;

        if (obj instanceof Aufenthalt) {
            Aufenthalt com = (Aufenthalt) obj;
            if (this.buchungNr.equals(com.getBuchungNr()) && this.gastNr.equals(com.getGastNr())) {
                equal = true;
            }
        }

        return equal;
    }

}
