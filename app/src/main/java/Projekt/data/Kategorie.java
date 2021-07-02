package Projekt.data;

public class Kategorie {

    private String katbez;
    private String beschreibung;
    private Integer betten;
    private Float flaeche;

    public Kategorie(String katbez, String beschreibung, Integer betten, Float flaeche) {

        this.katbez = katbez;
        this.beschreibung = beschreibung;
        this.betten = betten;
        this.flaeche = flaeche;

    }

    // Getters:

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
}
