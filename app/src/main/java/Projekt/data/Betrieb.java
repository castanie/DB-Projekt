package Projekt.data;

public class Betrieb {

    private String uid;
    private String name;
    private String typ;
    private Integer sterne;
    private String adresse;
    private String tel;
    private String email;
    private String fax;
    private String website;

    public Betrieb(String uid, String name, String typ, Integer sterne, String adresse, String tel, String email, String fax, String website) {

        this.uid = uid;
        this.name = name;
        this.typ = typ;
        this.sterne = sterne;
        this.adresse = adresse;
        this.tel = tel;
        this.email = email;
        this.fax = fax;
        this.website = website;

    }

    // Getters:

    // Setters:


    public void setName(String name) {
        this.name = name;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public void setSterne(Integer sterne) {
        this.sterne = sterne;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
