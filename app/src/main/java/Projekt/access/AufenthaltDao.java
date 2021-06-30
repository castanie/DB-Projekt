package Projekt.access;

import java.util.LinkedList;
import java.util.List;

import Projekt.data.Aufenthalt;

public class AufenthaltDao implements DataAccessObject<Aufenthalt> {

    private List<Aufenthalt> cache;

    public AufenthaltDao() {
        this.cache = new LinkedList<Aufenthalt>();
    }

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
