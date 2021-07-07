package Projekt.access;

import java.sql.*;
import java.util.List;

import Projekt.data.Buchung;

public class BuchungDao extends DataAccessObject<Buchung> {

    public BuchungDao(Connection conn) {
        super(conn);

        try {
            create = conn.prepareStatement("INSERT INTO buchung VALUES(?, ?, ?, ?, ?, ?) ON CONFLICT DO NOTHING;");
            readOne = conn.prepareStatement("SELECT * FROM buchung WHERE buchungNr = ?;");
            readAll = conn.prepareStatement("SELECT * FROM buchung;");
            update = conn.prepareStatement("UPDATE person SET uid = ?, zimmer = ?, anreise = ?, abreise = ?, gastNr = ? WHERE buchungNr = ?;");
            delete = conn.prepareStatement("DELETE FROM buchung WHERE buchungNr = ?;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Access:

    @Override
    public void create(Buchung t) {
        try {
            /*
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
            */

            create.setInt(1, t.getBuchungNr());
            create.setString(2, t.getUid());
            create.setString(3, t.getZimmer());
            create.setDate(4, t.getAnreise());
            create.setDate(5, t.getAbreise());
            create.setInt(6, t.getGastnr());

            create.executeUpdate();
            create.clearParameters();

            this.cache.add(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Buchung readOne(String key) {
        Buchung b = null;
        try {
            /*
            Statement stat;
            stat = conn.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM buchung;");
            */

            readOne.setInt(1, 0);

            ResultSet result = readOne.executeQuery();
            readOne.clearParameters();

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
            /*
            Statement stat;
            stat = conn.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM aufenthalt;");
            */

            ResultSet result = readAll.executeQuery();

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
            /*
            update.executeUpdate(
                "UPDATE person SET"
                + "uid = "+ t.getUid() + ", "
                + "zimmer = "+ t.getZimmer() + ", "
                + "anreise = "+ t.getAnreise() + ", "
                + "abreise = "+ t.getAbreise() + ", "
                + "gastNr = "+ t.getGastnr()
                + " WHERE buchungNr = " + t.getBuchungNr() + ";"
            );
            */

            update.setString(1, t.getUid());
            update.setString(2, t.getZimmer());
            update.setDate(3, t.getAnreise());
            update.setDate(4, t.getAbreise());
            update.setInt(5, t.getGastnr());
            update.setInt(6, t.getBuchungNr());

            update.executeUpdate();
            update.clearParameters();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Buchung t) {
        try {
            update.setInt(1, t.getBuchungNr());

            update.executeUpdate();
            update.clearParameters();

            this.cache.remove(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
