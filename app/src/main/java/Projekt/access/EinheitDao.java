package Projekt.access;

import java.sql.*;
import java.util.List;

import Projekt.data.Einheit;

public class EinheitDao extends DataAccessObject<Einheit> {

    public EinheitDao(Connection conn) {
        super(conn);
    }

    // Access:

    @Override
    public void create(Einheit t) {
        
    }

    @Override
    public Einheit read(String key) {
        return null;
    }

    @Override
    public List<Einheit> readAll() {
        return null;
    }

    @Override
    public void update(Einheit t) {
        
    }

    @Override
    public void delete(Einheit t) {
        
    }

}
