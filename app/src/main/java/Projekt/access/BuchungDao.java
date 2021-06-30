package Projekt.access;

import java.sql.*;
import java.util.List;

import Projekt.data.Buchung;

public class BuchungDao extends DataAccessObject<Buchung> {

    public BuchungDao(Connection conn) {
        super(conn);
    }

    // Access:

    @Override
    public void create(Buchung t) {
        
    }

    @Override
    public Buchung read(String key) {
        return null;
    }

    @Override
    public List<Buchung> readAll() {
        return null;
    }

    @Override
    public void update(Buchung t) {
        
    }

    @Override
    public void delete(Buchung t) {
        
    }

}
