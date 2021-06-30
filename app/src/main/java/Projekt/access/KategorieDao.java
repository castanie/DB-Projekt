package Projekt.access;

import java.util.LinkedList;
import java.util.List;

import Projekt.data.Kategorie;

public class KategorieDao implements DataAccessObject<Kategorie> {

    private List<Kategorie> cache;

    public KategorieDao() {
        this.cache = new LinkedList<Kategorie>();
    }

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
