package Projekt.access;

import java.sql.*;
import java.util.List;

import Projekt.data.Buchung;

public class BuchungDao extends DataAccessObject<Buchung> {

    public BuchungDao(Connection conn) {
        super(conn);
    }

    // Access:

    @Override
    public void create(Buchung t) {
        try {
            update.executeUpdate(
                "INSERT INTO buchung VALUES("
                + t.getBuchungNr() + ", "
                + t.getUid() + ", "
                + t.getZimmer() + ", "
                + t.getAnreise() + ", "
                + t.getAbreise() + ", "
                + t.getGastnr()
                + ") ON CONFLICT DO NOTHING;"
            );
            this.cache.add(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Buchung read(String key) {
        Buchung b = null;
        try {
            Statement stat;
            stat = conn.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM buchung;");

            cache.clear();
            while (result.next()) {
                b = new Buchung();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public List<Buchung> readAll() {
        try {
            Statement stat;
            stat = conn.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM aufenthalt;");

            cache.clear();
            while (result.next()) {
                Buchung b = new Buchung();

                cache.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cache;
    }

    @Override
    public void update(Buchung t) {
        try {
            update.executeUpdate(
                "UPDATE person SET"
                + "buchungNr = " + t.getBuchungNr() + ", "
                + "uid = "+ t.getUid() + ", "
                + "zimmer = "+ t.getZimmer() + ", "
                + "anreise = "+ t.getAnreise() + ", "
                + "abreise = "+ t.getAbreise() + ", "
                + "gastNr = "+ t.getGastnr()
                + " WHERE buchungNr = " + t.getBuchungNr() + ";"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Buchung t) {
        try {
            update.executeUpdate(
                "DELETE FROM buchung WHERE buchungNr = " + t.getBuchungNr() + ";"
            );
            this.cache.remove(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
