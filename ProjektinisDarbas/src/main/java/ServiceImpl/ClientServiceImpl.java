package ServiceImpl;

import Model.Client;
import Repository.ClientRepository;
import Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Override
    public Iterable<Client> showClient() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> idClient(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void killClient(Long id) {
        clientRepository.deleteById(id);
    }

    public ClientRepository getClientRepository() {
        return clientRepository;
    }

    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
}