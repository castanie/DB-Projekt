package Projekt.access;

import java.sql.*;
import java.util.List;

import Projekt.data.Einheit;

public class EinheitDao extends DataAccessObject<Einheit> {

    public EinheitDao(Connection conn) {
        super(conn);

        try {
            create = conn.prepareStatement("INSERT INTO einheit VALUES(?, ?, ?) ON CONFLICT DO NOTHING;");
            readOne = conn.prepareStatement("SELECT * FROM einheit WHERE uid = ? AND zimmer = ?;");
            readAll = conn.prepareStatement("SELECT * FROM einheit;");
            update = conn.prepareStatement("UPDATE einheit SET katbez = ? WHERE uid = ? AND zimmer = ?;");
            delete = conn.prepareStatement("DELETE FROM einheit WHERE uid = ? AND zimmer = ?;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Access:

    @Override
    public void create(Einheit t) {
        try {
            create.setString(1, t.getUid());
            create.setString(2, t.getZimmer());
            create.setString(3, t.getKatbez());

            create.executeUpdate();
            create.clearParameters();

            this.cache.add(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Einheit readOne(String key) {
        Einheit z = null;
        try {
            readOne.setString(1, "");
            readOne.setString(2, "");

            ResultSet result = readOne.executeQuery();
            readOne.clearParameters();

            cache.clear();
            while (result.next()) {
                z = new Einheit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return z;
    }

    @Override
    public List<Einheit> readAll() {
        try {
            ResultSet result = readAll.executeQuery();

            cache.clear();
            while (result.next()) {
                Einheit z = new Einheit();

                cache.add(z);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cache;
    }

    @Override
    public void update(Einheit t) {
        try {
            update.setString(1, t.getKatbez());
            update.setString(2, t.getUid());
            update.setString(3, t.getZimmer());

            update.executeUpdate();
            update.clearParameters();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Einheit t) {
        try {
            delete.setString(1, "");
            delete.setString(2, "");

            delete.executeUpdate();
            delete.clearParameters();

            this.cache.remove(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
