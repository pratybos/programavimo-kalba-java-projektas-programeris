package Service;

import Model.Client;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface ClientService {
    Iterable<Client> showClient();
    Optional<Client> idClient(Long id);
    Client saveClient(Client client);
    void killClient(Long id);
}