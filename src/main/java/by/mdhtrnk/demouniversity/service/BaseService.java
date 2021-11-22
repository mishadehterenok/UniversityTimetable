package by.mdhtrnk.demouniversity.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T>{

    List<T> findAll();
    T save(T t);
    Optional<T> findById(Long id);
    void saveAll(Iterable<T> entities);
    void deleteById(Long id);
}
