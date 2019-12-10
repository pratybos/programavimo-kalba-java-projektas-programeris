package com.IS17B.Restoranas.restoranas.Service;

import com.IS17B.Restoranas.restoranas.Model.Client;

import java.util.Iterator;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public interface ClientService {
    Iterable<Client> showClients();
    Optional<Client> clientShowId(Long id);
    Client saveClient(Client client);
    void exterminatusClient(Long id);
}
