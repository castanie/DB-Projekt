package Projekt.data;

public class Kategorie {

    private String katbez;
    private String beschreibung;
    private Integer betten;
    private Float flaeche;

    public Kategorie() {

    }

    public Kategorie(String katbez, String beschreibung, Integer betten, Float flaeche) {

        this.katbez = katbez;
        this.beschreibung = beschreibung;
        this.betten = betten;
        this.flaeche = flaeche;

    }

    // Getters:

    public String getKatbez() {
        return katbez;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public Integer getBetten() {
        return betten;
    }

    public Float getFlaeche() {
        return flaeche;
    }

    // Setters:

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public void setBetten(Integer betten) {
        this.betten = betten;
    }

    public void setFlaeche(Float flaeche) {
        this.flaeche = flaeche;
    }

    // Helpers:

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;

        if (obj instanceof Kategorie) {
            Kategorie com = (Kategorie) obj;
            if (this.beschreibung.equals(com.getBeschreibung()) && this.betten.equals(com.getBetten())
                    && this.flaeche.equals(com.getFlaeche()) && this.katbez.equals(com.getKatbez())) {
                equal = true;
            }
        }

        return equal;
    }

}
