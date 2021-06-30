package Projekt.access;

import java.sql.*;
import java.util.List;

import Projekt.data.Betrieb;

public class BetriebDao extends DataAccessObject<Betrieb> {

    public BetriebDao(Connection conn) {
        super(conn);
    }

    // Access:

    @Override
    public void create(Betrieb t) {
        
    }

    @Override
    public Betrieb read(String key) {
        return null;
    }

    @Override
    public List<Betrieb> readAll() {
        return null;
    }

    @Override
    public void update(Betrieb t) {
        
    }

    @Override
    public void delete(Betrieb t) {
        
    }

}
