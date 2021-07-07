package Projekt.access;

import java.sql.*;
import java.util.List;

import Projekt.data.Buchung;

public class BuchungDao extends DataAccessObject<Buchung> {

    public BuchungDao(Connection conn) {
        super(conn);

        try {
            create = conn.prepareStatement("INSERT INTO buchung VALUES(DEFAULT, ?, ?, ?, ?, ?) ON CONFLICT DO NOTHING;");
            readOne = conn.prepareStatement("SELECT * FROM buchung WHERE buchungNr = ?;");
            readAll = conn.prepareStatement("SELECT * FROM buchung;");
            update = conn.prepareStatement("UPDATE buchung SET uid = ?, zimmer = ?, anreise = ?, abreise = ?, gastNr = ? WHERE buchungNr = ?;");
            delete = conn.prepareStatement("DELETE FROM buchung WHERE buchungNr = ?;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Access:

    @Override
    public void create(Buchung t) {
        try {
            // create.setString(0, "DEFAULT");
            create.setString(1, t.getUid());
            create.setString(2, t.getZimmer());
            create.setDate(3, t.getAnreise());
            create.setDate(4, t.getAbreise());
            create.setInt(5, t.getGastnr());

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
            readOne.setInt(1, 0);

            ResultSet result = readOne.executeQuery();
            readOne.clearParameters();

            cache.clear();
            while (result.next()) {
                b = fill(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public List<Buchung> readAll() {
        try {
            ResultSet result = readAll.executeQuery();

            cache.clear();
            while (result.next()) {
                Buchung b = fill(result);

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
            delete.setInt(1, t.getBuchungNr());

            delete.executeUpdate();
            delete.clearParameters();

            this.cache.remove(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    Buchung fill(ResultSet result) throws SQLException {
        return new Buchung(
            result.getInt(1),
            result.getString(2),
            result.getString(3),
            result.getDate(4),
            result.getDate(5),
            result.getInt(6)
        );
    }

}
