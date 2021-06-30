package Projekt;

import java.util.List;
import java.util.Optional;

public interface DataAccessObject<T> {

    Optional<T> get(String key);
    List<T> getAll();
    void save(T t);
    void update(T t);
    void delete(T t);
    
}
