package Projekt.access;

import java.sql.*;
import java.util.List;

import Projekt.data.Gast;

public class GastDao extends DataAccessObject<Gast> {

    public GastDao(Connection conn) {
        super(conn);
    }

    // Access:

    @Override
    public void create(Gast t) {
        try {
            update.executeUpdate(
                "INSERT INTO betrieb VALUES("
                + "DEFAULT" + ", "
                + t.getVorname() + ", "
                + t.getNachname() + ", "
                + t.getTitel() + ", "
                + t.getGeburtsdatum() + ", "
                + t.getWohnadresse() + ", "
                + t.getTel() + ", "
                + t.getEmail()
                + ") ON CONFLICT DO NOTHING;"
            );
            this.cache.add(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Gast readOne(String key) {
        Gast g = null;
        try {
            Statement stat;
            stat = conn.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM gast;");

            cache.clear();
            while (result.next()) {
                g = new Gast();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return g;
    }

    @Override
    public List<Gast> readAll() {
        try {
            Statement stat;
            stat = conn.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM gast;");

            cache.clear();
            while (result.next()) {
                Gast g = new Gast();

                cache.add(g);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cache;
    }

    @Override
    public void update(Gast t) {
        try {
            update.executeUpdate(
                "UPDATE person SET"
                + "vorname = " + t.getVorname() + ", "
                + "nachname = " + t.getNachname() + ", "
                + "titel = " + t.getTitel() + ", "
                + "geburtsdatum = " + t.getGeburtsdatum() + ", "
                + "wohnadresse = " + t.getWohnadresse() + ", "
                + "tel = " + t.getTel() + ", "
                + "email = " + t.getEmail()
                + " WHERE gastnr = " + t.getGastnr() + ";"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Gast t) {
        try {
            update.executeUpdate(
                "DELETE FROM gast WHERE gastnr = " + t.getGastnr() + ";"
            );
            this.cache.remove(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
