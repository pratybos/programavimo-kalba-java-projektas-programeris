package com.IS17B.Restoranas.restoranas.ServiceImpl;

import com.IS17B.Restoranas.restoranas.Model.Client;
import com.IS17B.Restoranas.restoranas.Repository.ClientRepository;
import com.IS17B.Restoranas.restoranas.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;

    @Override
    public Iterable<Client> showClients() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> clientShowId(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void exterminatusClient(Long id) {
        clientRepository.deleteById(id);
    }
    public ClientRepository getClientRepository() {
    return clientRepository;
    }
    @Autowired
    public void setClientRepository(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }
}
