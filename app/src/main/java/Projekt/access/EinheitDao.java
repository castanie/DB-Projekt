package Projekt.access;

import java.util.LinkedList;
import java.util.List;

import Projekt.data.Einheit;

public class EinheitDao implements DataAccessObject<Einheit> {

    private List<Einheit> cache;

    public EinheitDao() {
        this.cache = new LinkedList<Einheit>();
    }

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
