package Projekt.access;

import java.util.LinkedList;
import java.util.List;

import Projekt.data.Betrieb;

public class BetriebDao implements DataAccessObject<Betrieb> {

    private List<Betrieb> cache;

    public BetriebDao() {
        this.cache = new LinkedList<Betrieb>();
    }

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
