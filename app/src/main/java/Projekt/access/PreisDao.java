package Projekt.access;

import java.sql.*;
import java.util.List;

import Projekt.data.Preis;

public class PreisDao extends DataAccessObject<Preis> {

    public PreisDao(Connection conn) {
        super(conn);

        try {
            create = conn.prepareStatement("INSERT INTO preis VALUES(?, ?, ?, ?, ?) ON CONFLICT DO NOTHING;");
            readOne = conn.prepareStatement("SELECT * FROM preis WHERE katbez = ? AND vondatum = ? AND bisdatum = ? AND pensionsart = ?;");
            readAll = conn.prepareStatement("SELECT * FROM preis;");
            update = conn.prepareStatement("UPDATE preis SET preis = ? WHERE katbez = ? AND vondatum = ? AND bisdatum = ? AND pensionsart = ?;");
            delete = conn.prepareStatement("DELETE FROM preis WHERE katbez = ? AND vondatum = ? AND bisdatum = ? AND pensionsart = ?;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Access:

    @Override
    public void create(Preis t) {
        try {
            create.setString(1, t.getKatbez());
            create.setDate(2, t.getVondatum());
            create.setDate(3, t.getBisdatum());
            create.setString(4, t.getPensionsart());
            create.setDouble(5, t.getPreis());

            create.executeUpdate();
            create.clearParameters();

            this.cache.add(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Preis readOne(String key) {
        Preis p = null;
        try {
            ResultSet result = readOne.executeQuery();
            readOne.clearParameters();

            cache.clear();
            while (result.next()) {
                p = fill(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public List<Preis> readAll() {
        try {
            ResultSet result = readAll.executeQuery();

            cache.clear();
            while (result.next()) {
                Preis a = fill(result);

                cache.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cache;
    }

    @Override
    public void update(Preis t) {
        try {
            update.setDouble(1, t.getPreis());
            update.setString(2, t.getKatbez());
            update.setDate(3, t.getVondatum());
            update.setDate(4, t.getBisdatum());
            update.setString(5, t.getPensionsart());

            update.executeUpdate();
            update.clearParameters();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Preis t) {
        try {
            update.executeUpdate();
            this.cache.remove(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    Preis fill(ResultSet result) throws SQLException {
        return new Preis(
            result.getString(1),
            result.getDate(2),
            result.getDate(3),
            result.getString(4),
            result.getDouble(5)
        );
    }
    
}
