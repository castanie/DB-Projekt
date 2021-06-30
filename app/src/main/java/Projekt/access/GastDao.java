package Projekt.access;

import java.sql.*;
import java.util.List;

import Projekt.data.Gast;

public class GastDao extends DataAccessObject<Gast> {

    public GastDao(Connection conn) {
        super(conn);
    }

    // Access:

    @Override
    public void create(Gast t) {
        
    }

    @Override
    public Gast read(String key) {
        return null;
    }

    @Override
    public List<Gast> readAll() {
        return null;
    }

    @Override
    public void update(Gast t) {
        
    }

    @Override
    public void delete(Gast t) {
        
    }

}
