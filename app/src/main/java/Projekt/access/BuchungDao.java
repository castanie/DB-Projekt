package Projekt.access;

import java.util.LinkedList;
import java.util.List;

import Projekt.data.Buchung;

public class BuchungDao implements DataAccessObject<Buchung> {

    private List<Buchung> cache;

    public BuchungDao() {
        this.cache = new LinkedList<Buchung>();
    }

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
