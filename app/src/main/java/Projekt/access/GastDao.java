package Projekt.access;

import java.sql.*;
import java.util.List;

import Projekt.data.Gast;

public class GastDao extends DataAccessObject<Gast> {

    public GastDao(Connection conn) {
        super(conn);

        try {
            create = conn.prepareStatement("INSERT INTO betrieb VALUES(DEFAULT, ?, ?, ?, ?, ?, ?, ?) ON CONFLICT DO NOTHING;");
            readOne = conn.prepareStatement("SELECT * FROM gast WHERE gastnr = ?;");
            readAll = conn.prepareStatement("SELECT * FROM gast;");
            update = conn.prepareStatement("UPDATE person SET vorname = ?, nachname = ?, titel = ?, geburtsdatum = ?, wohnadresse = ?, tel = ?, email = ? WHERE gastnr = ?;");
            delete = conn.prepareStatement("DELETE FROM gast WHERE gastnr = ?;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Access:

    @Override
    public void create(Gast t) {
        try {
            /*
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
            */

            create.setString(1, "DEFAULT");
            create.setString(2, t.getVorname());
            create.setString(3, t.getNachname());
            create.setString(4, t.getTitel());
            create.setDate(5, t.getGeburtsdatum());
            create.setString(6, t.getWohnadresse());
            create.setString(7, t.getTel());
            create.setString(8, t.getEmail());

            create.executeUpdate();
            create.clearParameters();

            this.cache.add(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Gast readOne(String key) {
        Gast g = null;
        try {
            /*
            Statement stat;
            stat = conn.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM gast;");
            */

            ResultSet result = readOne.executeQuery();
            readOne.clearParameters();

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
            /*
            Statement stat;
            stat = conn.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM gast;");
            */

            ResultSet result = readAll.executeQuery();

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
            /*
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
            */

            update.setString(1, t.getVorname());
            update.setString(2, t.getNachname());
            update.setString(3, t.getTitel());
            update.setDate(4, t.getGeburtsdatum());
            update.setString(5, t.getWohnadresse());
            update.setString(6, t.getTel());
            update.setString(7, t.getEmail());
            update.setInt(8, t.getGastnr());

            update.executeUpdate();
            update.clearParameters();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Gast t) {
        try {
            update.executeUpdate();
            this.cache.remove(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
