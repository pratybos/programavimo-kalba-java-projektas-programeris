package com.IS17B.Restoranas.restoranas.Service;

import com.IS17B.Restoranas.restoranas.Model.Client;

import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public interface ClientService {
    Iterable<Client> showClients();
    Optional<Client> clientShowId(Integer id);
    int saveClient(Client client);
    void exterminatusClient(Integer id);
}
