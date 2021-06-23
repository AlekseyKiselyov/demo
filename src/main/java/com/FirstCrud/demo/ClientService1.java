package com.FirstCrud.demo;

import com.FirstCrud.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientService1 implements ClientService{
    ClientRepository clientRepository;

    @Autowired
    public ClientService1(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }


    @Override
    public void addClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.getById(id);
    }

    @Override
    public void updateClient(Long id) {
        // спросить
    }

    @Override
    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }
}
