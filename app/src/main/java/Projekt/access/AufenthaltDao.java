package Projekt.access;

import java.sql.*;
import java.util.List;

import Projekt.data.Aufenthalt;

public class AufenthaltDao extends DataAccessObject<Aufenthalt> {

    public AufenthaltDao(Connection conn) {
        super(conn);
    }

    // Access:

    @Override
    public void create(Aufenthalt t) {
        try {
            update.executeUpdate(
                "INSERT INTO aufenthalt VALUES("
                + t.getBuchungNr() + ", "
                + t.getGastNr() + ") ON CONFLICT DO NOTHING;"
            );
            this.cache.add(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Aufenthalt read(String key) {
        Aufenthalt a = null;
        try {
            Statement stat;
            stat = conn.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM aufenthalt;");

            cache.clear();
            while (result.next()) {
                a = new Aufenthalt();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    @Override
    public List<Aufenthalt> readAll() {
        try {
            Statement stat;
            stat = conn.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM aufenthalt;");

            cache.clear();
            while (result.next()) {
                Aufenthalt a = new Aufenthalt();

                cache.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cache;
    }

    @Override
    public void update(Aufenthalt t) {
        // Unnecessary.
    }

    @Override
    public void delete(Aufenthalt t) {
        try {
            update.executeUpdate(
                "DELETE FROM aufenthalt WHERE buchungNr = " + t.getBuchungNr() + "AND gastNr = " + t.getGastNr() + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.cache.remove(t);
    }

}
