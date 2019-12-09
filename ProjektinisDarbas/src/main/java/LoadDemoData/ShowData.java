package LoadDemoData;

import Model.Client;
import Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ShowData implements ApplicationListener<ContextRefreshedEvent> {

    private ClientRepository clientRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        String pav[] = {"Petraitis", "Jasaitis", "Lempaitis", "Monitoriaitis", "Ubagas"};

        for (int i = 0; i < 15; i++) {
            clientRepository.save(new Client(pav[new Random().nextInt(pav.length)], new Random().nextInt(5000)));
        }
    }

    public ClientRepository getClientRepository() {
        return clientRepository;
    }
    @Autowired
    public void setClientRepository(ClientRepository clientRepositoryRepository) {
        this.clientRepository = clientRepository;
    }
}