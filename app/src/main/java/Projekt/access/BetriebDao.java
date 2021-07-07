package Projekt.access;

import java.sql.*;
import java.util.List;

import Projekt.data.Betrieb;

public class BetriebDao extends DataAccessObject<Betrieb> {

    public BetriebDao(Connection conn) {
        super(conn);

        try {
            create = conn.prepareStatement("INSERT INTO betrieb VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?) ON CONFLICT DO NOTHING;");
            readOne = conn.prepareStatement("SELECT * FROM betrieb WHERE uid = ?;");
            readAll = conn.prepareStatement("SELECT * FROM betrieb;");
            update = conn.prepareStatement("UPDATE betrieb SET name = ?, typ = ?, sterne = ?, adresse = ?, tel = ?, email = ?, fax = ?, website = ? WHERE uid = ?;");
            delete = conn.prepareStatement("DELETE FROM betrieb WHERE uid = ?;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Access:

    @Override
    public void create(Betrieb t) {
        try {
            create.setString(1, t.getUid());
            create.setString(2, t.getName());
            create.setString(3, t.getTyp());
            create.setInt(4, t.getSterne());
            create.setString(5, t.getAdresse());
            create.setString(6, t.getTel());
            create.setString(7, t.getEmail());
            create.setString(8, t.getFax());
            create.setString(9, t.getWebsite());
            create.executeUpdate();
            create.clearParameters();

            this.cache.add(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Betrieb readOne(String key) {
        Betrieb b = null;
        try {
            readOne.setString(1, "");

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
    public List<Betrieb> readAll() {
        try {
            ResultSet result = readAll.executeQuery();

            cache.clear();
            while (result.next()) {
                Betrieb a = fill(result);

                cache.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cache;
    }

    @Override
    public void update(Betrieb t) {
        try {
            update.setString(1, t.getName());
            update.setString(2, t.getTyp());
            update.setInt(3, t.getSterne());
            update.setString(4, t.getAdresse());
            update.setString(5, t.getTel());
            update.setString(6, t.getEmail());
            update.setString(7, t.getFax());
            update.setString(8, t.getWebsite());
            update.setString(9, t.getUid());

            update.executeUpdate();
            update.clearParameters();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Betrieb t) {
        try {
            delete.setString(1, t.getUid());

            delete.executeUpdate();
            delete.clearParameters();
            
            this.cache.remove(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    Betrieb fill(ResultSet result) throws SQLException {
        return new Betrieb(
            result.getString(1),
            result.getString(2),
            result.getString(3),
            result.getInt(4),
            result.getString(5),
            result.getString(6),
            result.getString(7),
            result.getString(8),
            result.getString(9)
        );
    }

}
