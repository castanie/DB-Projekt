package Projekt.access;

import java.sql.*;
import java.util.List;

import Projekt.data.Aufenthalt;

public class AufenthaltDao extends DataAccessObject<Aufenthalt> {

    public AufenthaltDao(Connection conn) {
        super(conn);
    }

    // Access:

    @Override
    public void create(Aufenthalt t) {
        
    }

    @Override
    public Aufenthalt read(String key) {
        return null;
    }

    @Override
    public List<Aufenthalt> readAll() {
        return null;
    }

    @Override
    public void update(Aufenthalt t) {
        
    }

    @Override
    public void delete(Aufenthalt t) {
        
    }

}
