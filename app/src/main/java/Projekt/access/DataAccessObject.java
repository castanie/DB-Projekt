package Projekt.access;

import java.util.List;
import java.util.Optional;

public interface DataAccessObject<T> {

    // Create:
    void create(T t);

    // Read:
    T read(String key);
    List<T> readAll();

    // Update:
    void update(T t);

    // Delete:
    void delete(T t);
    
}
