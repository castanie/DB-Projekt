package Projekt.access;

import java.util.LinkedList;
import java.util.List;

import Projekt.data.Social;

public class SocialDao implements DataAccessObject<Social> {

    private List<Social> cache;

    public SocialDao() {
        this.cache = new LinkedList<Social>();
    }

    // Access:

    @Override
    public void create(Social t) {
        
    }

    @Override
    public Social read(String key) {
        return null;
    }

    @Override
    public List<Social> readAll() {
        return null;
    }

    @Override
    public void update(Social t) {
        
    }

    @Override
    public void delete(Social t) {
        
    }

}
