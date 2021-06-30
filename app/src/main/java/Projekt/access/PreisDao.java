package Projekt.access;

import java.util.LinkedList;
import java.util.List;

import Projekt.data.Preis;

public class PreisDao implements DataAccessObject<Preis> {

    private List<Preis> cache;

    public PreisDao() {
        this.cache = new LinkedList<Preis>();
    }

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
