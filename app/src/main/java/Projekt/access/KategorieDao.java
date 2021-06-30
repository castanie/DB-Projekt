package Projekt.access;

import java.sql.*;
import java.util.List;

import Projekt.data.Kategorie;

public class KategorieDao extends DataAccessObject<Kategorie> {

    public KategorieDao(Connection conn) {
        super(conn);
    }

    // Access:

    @Override
    public void create(Kategorie t) {
        
    }

    @Override
    public Kategorie read(String key) {
        return null;
    }

    @Override
    public List<Kategorie> readAll() {
        return null;
    }

    @Override
    public void update(Kategorie t) {
        
    }

    @Override
    public void delete(Kategorie t) {
        
    }

}
