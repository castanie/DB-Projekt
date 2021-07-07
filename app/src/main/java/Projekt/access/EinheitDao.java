package Projekt.access;

import java.sql.*;
import java.util.List;

import Projekt.data.Einheit;

public class EinheitDao extends DataAccessObject<Einheit> {

    public EinheitDao(Connection conn) {
        super(conn);

        try {
            create = conn.prepareStatement("INSERT INTO einheit VALUES(?, ?, ?) ON CONFLICT DO NOTHING;");
            readOne = conn.prepareStatement("SELECT * FROM aufenthalt WHERE uid = ? AND zimmer = ?;");
            readAll = conn.prepareStatement("SELECT * FROM aufenthalt;");
            update = conn.prepareStatement("UPDATE person SET katbez = ? WHERE uid = ? AND zimmer = ?;");
            delete = conn.prepareStatement("DELETE FROM betrieb WHERE uid = ? AND zimmer = ?;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Access:

    @Override
    public void create(Einheit t) {
        try {
            /*
            update.executeUpdate(
                "INSERT INTO einheit VALUES("
                + t.getUid() + ", "
                + t.getZimmer()
                + t.getKatbez()
                + ") ON CONFLICT DO NOTHING;"
            );
            */

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
            /*
            Statement stat;
            stat = conn.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM aufenthalt;");
            */

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
            /*
            Statement stat;
            stat = conn.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM einheit;");
            */

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
            /*
            update.executeUpdate(
                "UPDATE person SET"
                + "katbez = " + t.getKatbez()
                + " WHERE uid = " + t.getUid()
                + " AND zimmer = " + t.getZimmer() + ";"
            );
            */

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
            update.executeUpdate();
            this.cache.remove(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
