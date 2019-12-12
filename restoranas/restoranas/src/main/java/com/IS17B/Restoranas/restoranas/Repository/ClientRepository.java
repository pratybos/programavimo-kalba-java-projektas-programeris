package com.IS17B.Restoranas.restoranas.Repository;

import com.IS17B.Restoranas.restoranas.Model.Client;

import java.util.List;
import java.util.Optional;


public interface ClientRepository {
    int count();
    int save(Client client);
    int update(Client client);
    int deleteById(Integer id);
    List<Client> findAll();
    List<Client> findByNameAndId(String name, Integer Id);
    Optional<Client> findById(Integer id);
    String getFirstNameById(Integer id);
}
