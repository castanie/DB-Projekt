package Projekt.access;

import java.sql.*;
import java.util.List;

import Projekt.data.Kategorie;

public class KategorieDao extends DataAccessObject<Kategorie> {

    public KategorieDao(Connection conn) {
        super(conn);
    }

    // Access:

    @Override
    public void create(Kategorie t) {
        try {
            update.executeUpdate(
                "INSERT INTO betrieb VALUES("
                + t.getKatbez() + ", "
                + t.getBeschreibung() + ", "
                + t.getBetten() + ", "
                + t.getFlaeche()
                + ") ON CONFLICT DO NOTHING;"
            );
            this.cache.add(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Kategorie readOne(String key) {
        Kategorie k = null;
        try {
            Statement stat;
            stat = conn.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM kategorie;");

            cache.clear();
            while (result.next()) {
                k = new Kategorie();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return k;
    }

    @Override
    public List<Kategorie> readAll() {
        try {
            Statement stat;
            stat = conn.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM kategorie;");

            cache.clear();
            while (result.next()) {
                Kategorie k = new Kategorie();

                cache.add(k);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cache;
    }

    @Override
    public void update(Kategorie t) {
        try {
            update.executeUpdate(
                "UPDATE person SET"
                + "beschreibung = " + t.getBeschreibung() + ", "
                + "betten = " + t.getBetten() + ", "
                + "flaeche = " + t.getFlaeche()
                + " WHERE katbez = " + t.getKatbez() + ";"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Kategorie t) {
        try {
            update.executeUpdate(
                "DELETE FROM betrieb WHERE katbez = " + t.getKatbez() + ";"
            );
            this.cache.remove(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
