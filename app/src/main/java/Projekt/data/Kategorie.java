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
        return super.equals(obj);
    }

}
