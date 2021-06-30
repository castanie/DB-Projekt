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

    public Betrieb() {
        
    }

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
    
    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getTyp() {
        return typ;
    }

    public Integer getSterne() {
        return sterne;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public String getFax() {
        return fax;
    }

    public String getWebsite() {
        return website;
    }

    // Setters:

}
