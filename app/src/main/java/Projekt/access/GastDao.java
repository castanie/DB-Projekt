package Projekt.access;

import java.sql.*;
import java.util.List;

import Projekt.data.Gast;

public class GastDao extends DataAccessObject<Gast> {

    public GastDao(Connection conn) {
        super(conn);

        try {
            create = conn.prepareStatement("INSERT INTO gast VALUES(DEFAULT, ?, ?, ?, ?, ?, ?, ?) ON CONFLICT DO NOTHING;");
            readOne = conn.prepareStatement("SELECT * FROM gast WHERE gastnr = ?;");
            readAll = conn.prepareStatement("SELECT * FROM gast;");
            update = conn.prepareStatement("UPDATE gast SET vorname = ?, nachname = ?, titel = ?, geburtsdatum = ?, wohnadresse = ?, tel = ?, email = ? WHERE gastnr = ?;");
            delete = conn.prepareStatement("DELETE FROM gast WHERE gastnr = ?;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Access:

    @Override
    public void create(Gast t) {
        try {
            // create.setString(0, "DEFAULT");
            create.setString(1, t.getVorname());
            create.setString(2, t.getNachname());
            create.setString(3, t.getTitel());
            create.setDate(4, t.getGeburtsdatum());
            create.setString(5, t.getWohnadresse());
            create.setString(6, t.getTel());
            create.setString(7, t.getEmail());

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
            readOne.setInt(1, 0);

            ResultSet result = readOne.executeQuery();
            readOne.clearParameters();

            cache.clear();
            while (result.next()) {
                g = fill(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return g;
    }

    @Override
    public List<Gast> readAll() {
        try {
            ResultSet result = readAll.executeQuery();

            cache.clear();
            while (result.next()) {
                Gast g = fill(result);

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
            delete.setInt(1, t.getGastnr());
            delete.executeUpdate();
            this.cache.remove(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    Gast fill(ResultSet result) throws SQLException {
        return new Gast(
            result.getInt(1),
            result.getString(2),
            result.getString(3),
            result.getString(4),
            result.getDate(5),
            result.getString(6),
            result.getString(7),
            result.getString(8)
        );
    }

}
