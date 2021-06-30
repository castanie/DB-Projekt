package Projekt.data;

public class Social {

    private String uid;
    private String plattform;
    private String account;

    public Social(String uid, String plattform, String account) {

        this.uid = uid;
        this.plattform = plattform;
        this.account = account;

    }

    // Getters:

    public String getUid() {
        return uid;
    }

    public String getPlattform() {
        return plattform;
    }

    public String getAccount() {
        return account;
    }

    // Setters:

}
