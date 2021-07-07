package Projekt.data;

public class Einheit {

    private String uid;
    private String zimmer;
    private String katbez;

    public Einheit() {
        
    }

    public Einheit(String uid, String zimmer, String katbez) {

        this.uid = uid;
        this.zimmer = zimmer;
        this.katbez = katbez;

    }


    // Getters:

    public String getUid() {
        return uid;
    }

    public String getZimmer() {
        return zimmer;
    }

    public String getKatbez() {
        return katbez;
    }


    // Setters:


    // Helpers:

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}
