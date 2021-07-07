package Projekt.access;

import java.sql.*;
import java.util.List;

import Projekt.data.Einheit;

public class EinheitDao extends DataAccessObject<Einheit> {

    public EinheitDao(Connection conn) {
        super(conn);
    }

    // Access:

    @Override
    public void create(Einheit t) {
        try {
            update.executeUpdate(
                "INSERT INTO einheit VALUES("
                + t.getUid() + ", "
                + t.getZimmer()
                + t.getKatbez()
                + ") ON CONFLICT DO NOTHING;"
            );
            this.cache.add(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Einheit readOne(String key) {
        Einheit z = null;
        try {
            Statement stat;
            stat = conn.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM aufenthalt;");

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
            Statement stat;
            stat = conn.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM einheit;");

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
            update.executeUpdate(
                "UPDATE person SET"
                + "katbez = " + t.getKatbez()
                + " WHERE uid = " + t.getUid()
                + " AND zimmer = " + t.getZimmer() + ";"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Einheit t) {
        try {
            update.executeUpdate(
                "DELETE FROM betrieb WHERE uid = " + t.getUid() + " AND zimmer = " + t.getZimmer() + ";"
            );
            this.cache.remove(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
