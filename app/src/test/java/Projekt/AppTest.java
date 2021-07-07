package Projekt;

import Projekt.access.*;
import Projekt.data.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.*;

class AppTest {

    Connection conn;

    // Integer gastnr, Integer buchungnr
    Aufenthalt a1;
    Aufenthalt a2;
    Aufenthalt a3;

    // String uid, String name, String typ, Integer sterne, String adresse,
    // String tel, String email, String fax, String website
    Betrieb b1;
    Betrieb b2;
    Betrieb b3;

    // Integer buchungnr, String uid, String zimmer, Date anreise, Date abreise,
    // Integer gastnr
    Buchung bu1;
    Buchung bu2;
    Buchung bu3;

    // String uid, String zimmer, String katbez
    Einheit e1;
    Einheit e2;
    Einheit e3;

    // Integer gastnr, String vorname, String nachname, String titel,
    // Date geburtsdatum, String wohnadresse, String tel, String email
    Gast g1;
    Gast g2;
    Gast g3;

    // String katbez, String beschreibung, Integer betten, Float flaeche
    Kategorie k1;
    Kategorie k2;
    Kategorie k3;

    // String katbez, Date vondatum, Date bisdatum, String pensionsart, Double preis
    Preis p1;
    Preis p2;
    Preis p3;

    // String uid, String plattform, String account
    Social s1;
    Social s2;
    Social s3;


    // Setup & Cleanup:

    @BeforeEach
    public void setup() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        conn = DriverManager.getConnection(url, "postgres", "password");
    }

    @AfterEach
    public void cleanup() throws SQLException {
        conn.close();
    }


    // Tests:

    @Test
    public void test_aufenthalt() {
        b1 = new Betrieb("0123", "Voco", "Hotel", 3, "Villach", "+436346343674", "voco@hotel.at", "+1230",
                "www.hotelvoco.at");
        BetriebDao bd = new BetriebDao(conn);
        bd.create(b1);

        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        g1 = new Gast(1, "Max", "Mustermann", "Herr", date, "Villach", "+439844295847", "maxmustermann@villach.at");
        g2 = new Gast(2, "Linda", "Müller", "Frau", date, "Klagenfurt", "+438729380192", "lindamüller@klagenfurt.at");
        g3 = new Gast(3, "Thomas", "Bacher", "Herr", date, "Wien", "+438392038727", "thomasbacher@wien.at");

        GastDao gd = new GastDao(conn);

        gd.create(g1);
        gd.create(g2);
        gd.create(g3);

        k1 = new Kategorie("Einzelzimmer", "Ein Bett im Zimmer", 1, 2.04f);
        k2 = new Kategorie("Doppelzimmer", "Zwei Betten im Zimmer", 2, 4.08f);
        k3 = new Kategorie("Seeblick Klein", "Ein Bett im Zimmer mit Blick auf See", 1, 3.06f);

        KategorieDao kd = new KategorieDao(conn);

        kd.create(k1);
        kd.create(k2);
        kd.create(k3);

        e1 = new Einheit("0123", "Zimmer 200", "Einzelzimmer");
        e2 = new Einheit("0123", "Zimmer 202", "Doppelzimmer");
        e3 = new Einheit("0123", "Zimmer 203", "Seeblick Klein");

        EinheitDao ed = new EinheitDao(conn);

        ed.create(e1);
        ed.create(e2);
        ed.create(e3);

        bu1 = new Buchung(1, "0123", "Zimmer 200", date, date, 1);
        bu2 = new Buchung(2, "0123", "Zimmer 202", date, date, 2);
        bu3 = new Buchung(3, "0123", "Zimmer 203", date, date, 3);

        BuchungDao bud = new BuchungDao(conn);

        bud.create(bu1);
        bud.create(bu2);
        bud.create(bu3);

        a1 = new Aufenthalt(1, 1);
        a2 = new Aufenthalt(2, 2);
        a3 = new Aufenthalt(3, 3);

        AufenthaltDao ad = new AufenthaltDao(conn);

        ad.readAll();

        ad.readOne("2");

        ad.delete(a2);

        ad.readAll();
    }

    @Test
    public void test_betrieb() {
        b1 = new Betrieb("0123", "Voco", "Hotel", 3, "Villach", "+436346343674", "voco@hotel.at", "+1230",
                "www.hotelvoco.at");
        b2 = new Betrieb("1230", "Holiday Inn", "Apartments", 2, "Klagenfurt", "+437388304758",
                "holidayinn@apartments.at", "+1231", "www.apartmentsholidayinn.at");
        b3 = new Betrieb("2301", "Sheraton", "Vacation Homes", 5, "Wien", "+438393204857", "sheraton@vacationhomes.at",
                "+1232", "www.vacationhomessheraton.at");

        BetriebDao bd = new BetriebDao(conn);

        bd.create(b1);
        bd.create(b2);
        bd.create(b3);

        b1.setSterne(4);
        bd.update(b1);

        bd.readOne("0123");

        bd.delete(b2);

        bd.readAll();
    }

    @Test
    public void test_buchung() {
        b1 = new Betrieb("0123", "Voco", "Hotel", 3, "Villach", "+436346343674", "voco@hotel.at", "+1230",
                "www.hotelvoco.at");
        BetriebDao bd = new BetriebDao(conn);
        bd.create(b1);

        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        g1 = new Gast(1, "Max", "Mustermann", "Herr", date, "Villach", "+439844295847", "maxmustermann@villach.at");
        g2 = new Gast(2, "Linda", "Müller", "Frau", date, "Klagenfurt", "+438729380192", "lindamüller@klagenfurt.at");
        g3 = new Gast(3, "Thomas", "Bacher", "Herr", date, "Wien", "+438392038727", "thomasbacher@wien.at");

        GastDao gd = new GastDao(conn);

        gd.create(g1);
        gd.create(g2);
        gd.create(g3);

        k1 = new Kategorie("Einzelzimmer", "Ein Bett im Zimmer", 1, 2.04f);
        k2 = new Kategorie("Doppelzimmer", "Zwei Betten im Zimmer", 2, 4.08f);
        k3 = new Kategorie("Seeblick Klein", "Ein Bett im Zimmer mit Blick auf See", 1, 3.06f);

        KategorieDao kd = new KategorieDao(conn);

        kd.create(k1);
        kd.create(k2);
        kd.create(k3);

        e1 = new Einheit("0123", "Zimmer 200", "Einzelzimmer");
        e2 = new Einheit("0123", "Zimmer 202", "Doppelzimmer");
        e3 = new Einheit("0123", "Zimmer 203", "Seeblick Klein");

        EinheitDao ed = new EinheitDao(conn);

        ed.create(e1);
        ed.create(e2);
        ed.create(e3);

        bu1 = new Buchung(1, "0123", "Zimmer 200", date, date, 1);
        bu2 = new Buchung(2, "0123", "Zimmer 202", date, date, 2);
        bu3 = new Buchung(3, "0123", "Zimmer 203", date, date, 3);

        BuchungDao bud = new BuchungDao(conn);

        bud.create(bu1);
        bud.create(bu2);
        bud.create(bu3);

        bud.readAll();

        bu1.setAbreise(date);
        bud.update(bu1);

        bud.readOne("2");

        bud.delete(bu2);

        bud.readAll();
    }

    @Test
    public void test_einheit() {
        b1 = new Betrieb("0123", "Voco", "Hotel", 3, "Villach", "+436346343674", "voco@hotel.at", "+1230",
                "www.hotelvoco.at");
        BetriebDao bd = new BetriebDao(conn);
        bd.create(b1);

        k1 = new Kategorie("Einzelzimmer", "Ein Bett im Zimmer", 1, 2.04f);
        k2 = new Kategorie("Doppelzimmer", "Zwei Betten im Zimmer", 2, 4.08f);
        k3 = new Kategorie("Seeblick Klein", "Ein Bett im Zimmer mit Blick auf See", 1, 3.06f);

        KategorieDao kd = new KategorieDao(conn);

        kd.create(k1);
        kd.create(k2);
        kd.create(k3);

        e1 = new Einheit("0123", "Zimmer 200", "Einzelzimmer");
        e2 = new Einheit("0123", "Zimmer 202", "Doppelzimmer");
        e3 = new Einheit("0123", "Zimmer 203", "Seeblick Klein");

        EinheitDao ed = new EinheitDao(conn);

        ed.create(e1);
        ed.create(e2);
        ed.create(e3);

        ed.readAll();

        ed.readOne("0123");

        ed.delete(e2);

        ed.readAll();
    }

    @Test
    public void test_gast() {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        g1 = new Gast(1, "Max", "Mustermann", "Herr", date, "Villach", "+439844295847", "maxmustermann@villach.at");
        g2 = new Gast(2, "Linda", "Müller", "Frau", date, "Klagenfurt", "+438729380192", "lindamüller@klagenfurt.at");
        g3 = new Gast(3, "Thomas", "Bacher", "Herr", date, "Wien", "+438392038727", "thomasbacher@wien.at");

        GastDao gd = new GastDao(conn);

        gd.create(g1);
        gd.create(g2);
        gd.create(g3);

        gd.readAll();

        g3.setWohnadresse("Linz");
        gd.update(g3);

        gd.readOne("3");

        gd.delete(g1);

        gd.readAll();
    }

    @Test
    public void test_kategorie() {
        k1 = new Kategorie("Einzelzimmer", "Ein Bett im Zimmer", 1, 2.04f);
        k2 = new Kategorie("Doppelzimmer", "Zwei Betten im Zimmer", 2, 4.08f);
        k3 = new Kategorie("Seeblick Klein", "Ein Bett im Zimmer mit Blick auf See", 1, 3.06f);

        KategorieDao kd = new KategorieDao(conn);

        kd.create(k1);
        kd.create(k2);
        kd.create(k3);

        kd.readAll();

        k2.setFlaeche(4.42f);
        kd.update(k2);

        kd.readOne("Doppelzimmer");

        kd.delete(k3);

        kd.readAll();
    }

    @Test
    public void test_preis() {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);

        k1 = new Kategorie("Einzelzimmer", "Ein Bett im Zimmer", 1, 2.04f);
        k2 = new Kategorie("Doppelzimmer", "Zwei Betten im Zimmer", 2, 4.08f);
        k3 = new Kategorie("Seeblick Klein", "Ein Bett im Zimmer mit Blick auf See", 1, 3.06f);

        KategorieDao kd = new KategorieDao(conn);

        kd.create(k1);
        kd.create(k2);
        kd.create(k3);

        p1 = new Preis("Einzelzimmer", date, date, "Halbpension", 150.00);
        p2 = new Preis("Dopperlzimmer", date, date, "Vollpension", 250.00);
        p3 = new Preis("Seeblick Klein", date, date, "Halbpension", 275.00);

        PreisDao pd = new PreisDao(conn);

        pd.create(p1);
        pd.create(p2);
        pd.create(p3);

        pd.readAll();

        p2.setPreis(225.00);
        pd.update(p2);

        pd.readOne("Doppelzimmer");

        pd.delete(p3);

        pd.readAll();
    }

    @Test
    public void test_social() {
        b1 = new Betrieb("0123", "Voco", "Hotel", 3, "Villach", "+436346343674", "voco@hotel.at", "+1230",
                "www.hotelvoco.at");
        BetriebDao bd = new BetriebDao(conn);
        bd.create(b1);

        s1 = new Social("0123", "Twitter", "HotelVoco");
        s2 = new Social("0123", "Facebook", "Hotel Voco");
        s3 = new Social("0123", "Instagram", "Hotel_Voco");

        SocialDao sd = new SocialDao(conn);

        sd.create(s1);
        sd.create(s2);
        sd.create(s3);

        sd.readAll();

        sd.readOne("0123");

        sd.delete(s2);

        sd.readAll();
    }

    @Test
    public void test_transactionCommit() {
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        BetriebDao betriebDao = new BetriebDao(conn);
        betriebDao.create(new Betrieb("testUID", ";", ";", -1, ";", ";", ";", ";", ";"));

        SocialDao socialDao = new SocialDao(conn);
        Social social = new Social("testUID", "testPlattform", "testAccount");
        boolean contains = false;

        for (Social s : socialDao.readAll()) {
            if (social.equals(s)) {
                contains = true;
                break;
            }
        }
        assertFalse(contains);

        // First commit, then "try" to rollback:
        socialDao.create(social);
        socialDao.commit();
        socialDao.abort();

        for (Social s : socialDao.readAll()) {
            System.out.println(s.getUid());
            System.out.println(s.getPlattform());
            System.out.println(s.getAccount());
            if (social.equals(s)) {
                contains = true;
                break;
            }
        }
        assertTrue(contains);
    }

    @Test
    public void test_transactionRollback() {
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        BetriebDao betriebDao = new BetriebDao(conn);
        betriebDao.create(new Betrieb("testUID", ";", ";", -1, ";", ";", ";", ";", ";"));

        SocialDao socialDao = new SocialDao(conn);
        Social social = new Social("testUID", "testPlattform", "testAccount");
        boolean contains = false;

        for (Social s : socialDao.readAll()) {
            if (social.equals(s)) {
                contains = true;
                break;
            }
        }
        assertFalse(contains);

        // First rollback, then "try" to commit:
        socialDao.create(social);
        socialDao.abort();
        socialDao.commit();

        for (Social s : socialDao.readAll()) {
            if (social.equals(s)) {
                contains = true;
                break;
            }
        }
        assertFalse(contains);
    }

}
