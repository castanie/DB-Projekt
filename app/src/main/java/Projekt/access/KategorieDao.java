package Projekt.access;

import java.sql.*;
import java.util.List;

import Projekt.data.Kategorie;

public class KategorieDao extends DataAccessObject<Kategorie> {

    public KategorieDao(Connection conn) {
        super(conn);

        try {
            create = conn.prepareStatement("INSERT INTO betrieb VALUES(?, ?, ?, ?) ON CONFLICT DO NOTHING;");
            readOne = conn.prepareStatement("SELECT * FROM kategorie WHERE katbez = ?;");
            readAll = conn.prepareStatement("SELECT * FROM kategorie;");
            update = conn.prepareStatement("UPDATE person SET beschreibung = ?, betten = ?, flaeche = ? WHERE katbez = ?;");
            delete = conn.prepareStatement("DELETE FROM betrieb WHERE katbez = ?;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Access:

    @Override
    public void create(Kategorie t) {
        try {
            /*
            update.executeUpdate(
                "INSERT INTO betrieb VALUES("
                + t.getKatbez() + ", "
                + t.getBeschreibung() + ", "
                + t.getBetten() + ", "
                + t.getFlaeche()
                + ") ON CONFLICT DO NOTHING;"
            );
            */

            create.setString(1, t.getKatbez());
            create.setString(2, t.getBeschreibung());
            create.setInt(3, t.getBetten());
            create.setFloat(4, t.getFlaeche());

            create.executeUpdate();
            create.clearParameters();

            this.cache.add(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Kategorie readOne(String key) {
        Kategorie k = null;
        try {
            /*
            Statement stat;
            stat = conn.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM kategorie;");
            */

            ResultSet result = readOne.executeQuery();
            readOne.clearParameters();

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
            /*
            Statement stat;
            stat = conn.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM kategorie;");
            */

            ResultSet result = readAll.executeQuery();

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
            /*
            update.executeUpdate(
                "UPDATE person SET"
                + "beschreibung = " + t.getBeschreibung() + ", "
                + "betten = " + t.getBetten() + ", "
                + "flaeche = " + t.getFlaeche()
                + " WHERE katbez = " + t.getKatbez() + ";"
            );
            */

            update.setString(1, t.getBeschreibung());
            update.setInt(2, t.getBetten());
            update.setFloat(3, t.getFlaeche());
            update.setString(4, t.getKatbez());

            update.executeUpdate();
            update.clearParameters();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Kategorie t) {
        try {
            update.executeUpdate();
            this.cache.remove(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
