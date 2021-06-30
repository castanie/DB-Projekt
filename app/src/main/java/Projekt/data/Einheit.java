package Projekt.data;

public class Einheit {

    private String uid;
    private String zimmer;
    private String katbez;

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

}
