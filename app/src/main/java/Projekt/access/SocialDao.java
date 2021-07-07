package Projekt.access;

import java.sql.*;
import java.util.List;

import Projekt.data.Social;

public class SocialDao extends DataAccessObject<Social> {

    public SocialDao(Connection conn) {
        super(conn);

        try {
            create = conn.prepareStatement("INSERT INTO social VALUES(?, ?, ?) ON CONFLICT DO NOTHING;");
            readOne = conn.prepareStatement("SELECT * FROM social WHERE uid = ? AND plattform = ? AND account = ?;");
            readAll = conn.prepareStatement("SELECT * FROM social;");
            update = conn.prepareStatement("");
            delete = conn.prepareStatement("DELETE FROM social WHERE uid = ? AND plattform = ? AND account = ?;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Access:

    @Override
    public void create(Social t) {
        try {
            create.setString(1, t.getUid());
            create.setString(2, t.getPlattform());
            create.setString(3, t.getAccount());

            create.executeUpdate();
            create.clearParameters();

            this.cache.add(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Social readOne(String key) {
        Social s = null;
        try {
            readOne.setString(1, "");
            readOne.setString(2, "");
            readOne.setString(3, "");

            ResultSet result = readOne.executeQuery();
            readOne.clearParameters();

            cache.clear();
            while (result.next()) {
                s = fill(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    @Override
    public List<Social> readAll() {
        try {
            ResultSet result = readAll.executeQuery();

            cache.clear();
            while (result.next()) {
                Social s = fill(result);

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
            update.executeUpdate();
            this.cache.remove(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    Social fill(ResultSet result) throws SQLException {
        return new Social(
            result.getString(1),
            result.getString(2),
            result.getString(3)
        );
    }

}
