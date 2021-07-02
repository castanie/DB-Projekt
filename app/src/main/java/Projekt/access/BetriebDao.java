package Projekt.access;

import java.sql.*;
import java.util.List;

import Projekt.data.Betrieb;

public class BetriebDao extends DataAccessObject<Betrieb> {

    public BetriebDao(Connection conn) {
        super(conn);
    }

    // Access:

    @Override
    public void create(Betrieb t) {
        try {
            update.executeUpdate(
                "INSERT INTO betrieb VALUES("
                + t.getUid() + ", "
                + t.getName() + ", "
                + t.getTyp() + ", "
                + t.getSterne() + ", "
                + t.getAdresse() + ", "
                + t.getTel() + ", "
                + t.getEmail() + ", "
                + t.getFax() + ", "
                + t.getWebsite()
                + ") ON CONFLICT DO NOTHING;"
            );
            this.cache.add(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Betrieb read(String key) {
        Betrieb b = null;
        try {
            Statement stat;
            stat = conn.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM betrieb;");

            cache.clear();
            while (result.next()) {
                b = new Betrieb();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public List<Betrieb> readAll() {
        try {
            Statement stat;
            stat = conn.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM betrieb;");

            cache.clear();
            while (result.next()) {
                Betrieb a = new Betrieb();

                cache.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cache;
    }

    @Override
    public void update(Betrieb t) {
        try {
            update.executeUpdate(
                "UPDATE person SET"
                + "name = " + t.getName() + ", "
                + "typ = " + t.getTyp() + ", "
                + "sterne = " + t.getSterne() + ", "
                + "adresse = " + t.getAdresse() + ", "
                + "tel = " + t.getTel() + ", "
                + "email = " + t.getEmail() + ", "
                + "fax = " + t.getFax() + ", "
                + "website = " + t.getWebsite()
                + " WHERE uid = " + t.getUid() + ";"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Betrieb t) {
        try {
            update.executeUpdate(
                "DELETE FROM betrieb WHERE uid = " + t.getUid() + ";"
            );
            this.cache.remove(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
