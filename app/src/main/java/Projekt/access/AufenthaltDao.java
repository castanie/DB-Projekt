package Projekt.access;

import java.sql.*;
import java.util.List;

import Projekt.data.Aufenthalt;

public class AufenthaltDao extends DataAccessObject<Aufenthalt> {

    public AufenthaltDao(Connection conn) {
        super(conn);

        try {
            create = conn.prepareStatement("INSERT INTO aufenthalt VALUES(?, ?) ON CONFLICT DO NOTHING;");
            readOne = conn.prepareStatement("SELECT * FROM aufenthalt WHERE buchungNr = ? AND gastNr = ?;");
            readAll = conn.prepareStatement("SELECT * FROM aufenthalt;");
            update = conn.prepareStatement("");
            delete = conn.prepareStatement("DELETE FROM aufenthalt WHERE buchungNr = ? AND gastNr = ?;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Access:

    @Override
    public void create(Aufenthalt t) {
        try {
            create.setInt(1, t.getBuchungNr());
            create.setInt(2, t.getGastNr());
            
            create.executeUpdate();
            create.clearParameters();

            this.cache.add(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Aufenthalt readOne(String key) {
        Aufenthalt a = null;
        try {
            readOne.setInt(1, 0);
            readOne.setInt(2, 0);
            
            ResultSet result = readOne.executeQuery();
            readOne.clearParameters();

            cache.clear();
            while (result.next()) {
                a = fill(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    @Override
    public List<Aufenthalt> readAll() {
        try {
            ResultSet result = readAll.executeQuery();

            cache.clear();
            while (result.next()) {
                Aufenthalt a = fill(result);

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
            delete.setInt(1, t.getBuchungNr());
            delete.setInt(2, t.getGastNr());

            delete.executeUpdate();
            delete.clearParameters();

            this.cache.remove(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    Aufenthalt fill(ResultSet result) throws SQLException {
        return new Aufenthalt(
                result.getInt(1),
                result.getInt(2)
            );
    }

}
