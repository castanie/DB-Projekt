package Projekt.access;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public abstract class DataAccessObject<T> {

    protected Connection conn;

    protected Statement trans;
    protected PreparedStatement create;
    protected PreparedStatement readOne;
    protected PreparedStatement readAll;
    protected PreparedStatement update;
    protected PreparedStatement delete;

    protected List<T> cache;

    public DataAccessObject(Connection conn) {
        this.conn = conn;
        try {
            this.trans = conn.createStatement();
            trans.executeUpdate("BEGIN TRANSACTION;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        this.cache = new LinkedList<T>();
    }

    // Create:
    abstract void create(T t);

    // Read:
    abstract T readOne(String key);
    abstract List<T> readAll();

    // Update:
    abstract void update(T t);

    // Delete:
    abstract void delete(T t);

    ///////////////////////////

    // Commit:
    void commit() {
        try {
            trans.executeUpdate("COMMIT TRANSACTION;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Abort:
    void abort() {
        try {
            trans.executeUpdate("ROLLBACK TRANSACTION;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
