package Projekt.data;

public class Social {

    private String uid;
    private String plattform;
    private String account;

    public Social() {

    }

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

    // Helpers:

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;

        if (obj instanceof Social) {
            Social com = (Social) obj;
            if (this.account.equals(com.getAccount()) && this.plattform.equals(com.getPlattform())
                    && this.uid.equals(com.getUid())) {
                equal = true;
            }
        }

        return equal;
    }

}
