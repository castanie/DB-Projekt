package Projekt.access;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import Projekt.data.Preis;

public class PreisDao extends DataAccessObject<Preis> {

    public PreisDao(Connection conn) {
        super(conn);
    }

    // Access:

    @Override
    public void create(Preis t) {
        
    }

    @Override
    public Preis read(String key) {
        return null;
    }

    @Override
    public List<Preis> readAll() {
        return null;
    }

    @Override
    public void update(Preis t) {
        
    }

    @Override
    public void delete(Preis t) {
        
    }
    
}
