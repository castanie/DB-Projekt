package Projekt.access;

import java.sql.*;
import java.util.List;

import Projekt.data.Social;

public class SocialDao extends DataAccessObject<Social> {

    public SocialDao(Connection conn) {
        super(conn);
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
