package Projekt.access;

import java.sql.*;
import java.util.List;

import Projekt.data.Social;

public class SocialDao extends DataAccessObject<Social> {

    public SocialDao(Connection conn) {
        super(conn);
    }

    // Access:

    @Override
    public void create(Social t) {
        try {
            update.executeUpdate(
                "INSERT INTO social VALUES("
                + t.getUid() + ", "
                + t.getPlattform() + ", "
                + t.getAccount()
                + ") ON CONFLICT DO NOTHING;"
            );
            this.cache.add(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Social readOne(String key) {
        Social s = null;
        try {
            Statement stat;
            stat = conn.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM social;");

            cache.clear();
            while (result.next()) {
                s = new Social();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    @Override
    public List<Social> readAll() {
        try {
            Statement stat;
            stat = conn.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM social;");

            cache.clear();
            while (result.next()) {
                Social s = new Social();

                cache.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cache;
    }

    @Override
    public void update(Social t) {
        // Unnecessary.
    }

    @Override
    public void delete(Social t) {
        try {
            update.executeUpdate(
                "DELETE FROM social WHERE uid = " + t.getUid()
                + " AND plattform = " + t.getPlattform() + ", "
                + " AND account = " + t.getAccount() + ";"
            );
            this.cache.remove(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
