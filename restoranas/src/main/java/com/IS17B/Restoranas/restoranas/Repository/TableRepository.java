package com.IS17B.Restoranas.restoranas.Repository;

import com.IS17B.Restoranas.restoranas.Model.Table;

import java.util.List;
import java.util.Optional;

public interface TableRepository {
    int count();
    int save(Table table);
    int update(Table table);
    int deleteById(Integer id);
    List<Table> findAll();
    List<Table> findByNameAndId(String name, Integer Id);
    Optional<Table> findById(Integer id);
    String getFirstNameById(Integer id);
}
