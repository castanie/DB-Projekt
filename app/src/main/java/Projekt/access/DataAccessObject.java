package Projekt.access;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public abstract class DataAccessObject<T> {

    protected Connection conn;
    protected Statement update;

    protected List<T> cache;

    public DataAccessObject(Connection conn) {
        this.conn = conn;
        try {
            this.update = conn.createStatement();
            update.executeUpdate("BEGIN TRANSACTION;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        this.cache = new LinkedList<T>();
    }

    // Create:
    abstract void create(T t);

    // Read:
    abstract T read(String key);
    abstract List<T> readAll();

    // Update:
    abstract void update(T t);

    // Delete:
    abstract void delete(T t);

    ///////////////////////////

    // Commit:
    void commit() {
        try {
            update.executeUpdate("COMMIT TRANSACTION;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Abort:
    void abort() {
        try {
            update.executeUpdate("ROLLBACK TRANSACTION;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
