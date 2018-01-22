package org.wtm.wtmwebsite.repository;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface Repository<T> {

    void createCollection();
    Object create(T object);
    List<T> findAll(Pageable pageable);
    Object findById(String uuid);
    Object update(T object);
    void delete(String uuid);

}
