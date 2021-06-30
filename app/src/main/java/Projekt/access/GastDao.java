package Projekt.access;

import java.util.LinkedList;
import java.util.List;

import Projekt.data.Gast;

public class GastDao implements DataAccessObject<Gast> {

    private List<Gast> cache;

    public GastDao() {
        this.cache = new LinkedList<Gast>();
    }

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
