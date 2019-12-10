package com.IS17B.Restoranas.restoranas.Repository;

import com.IS17B.Restoranas.restoranas.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
}
