package Projekt.access;

import java.sql.*;
import java.util.List;

import Projekt.data.Preis;

public class PreisDao extends DataAccessObject<Preis> {

    public PreisDao(Connection conn) {
        super(conn);
    }

    // Access:

    @Override
    public void create(Preis t) {
        try {
            update.executeUpdate(
                "INSERT INTO betrieb VALUES("
                + t.getKatbez() + ", "
                + t.getVondatum() + ", "
                + t.getBisdatum() + ", "
                + t.getPensionsart() + ", "
                + t.getPreis()
                + ") ON CONFLICT DO NOTHING;"
            );
            this.cache.add(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Preis readOne(String key) {
        Preis p = null;
        try {
            Statement stat;
            stat = conn.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM preis;");

            cache.clear();
            while (result.next()) {
                p = new Preis();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public List<Preis> readAll() {
        try {
            Statement stat;
            stat = conn.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM preis;");

            cache.clear();
            while (result.next()) {
                Preis a = new Preis();

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
            update.executeUpdate(
                "UPDATE person SET"
                + "preis = " + t.getPreis()
                + " WHERE katbez = " + t.getKatbez() 
                + " AND vondatum = " + t.getVondatum()
                + " AND bisdatum = " + t.getBisdatum()
                + " AND pensionsart = " + t.getPensionsart() + ";"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Preis t) {
        try {
            update.executeUpdate(
                "DELETE FROM preis + WHERE katbez = " + t.getKatbez() 
                + " AND vondatum = " + t.getVondatum()
                + " AND bisdatum = " + t.getBisdatum()
                + " AND pensionsart = " + t.getPensionsart() + ";"
            );
            this.cache.remove(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
