package com.IS17B.Restoranas.restoranas.LoadDemoData;

import com.IS17B.Restoranas.restoranas.Model.Client;
import com.IS17B.Restoranas.restoranas.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class LoadData implements ApplicationListener<ContextRefreshedEvent> {
    private ClientRepository clientRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        String firstName[] = {"Jonas", "Giedrius", "Jolanta", "Birute"};
        for(int i = 0; i<15; i++){
            clientRepository.save(new Client(firstName[new Random().nextInt(firstName.length)],
                    new  Random().nextInt(5000)));
        }
    }
    public ClientRepository getClientRepository(){
        return clientRepository;
    }
    @Autowired
    public void setClientRepository(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }
}
