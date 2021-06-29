package com.FirstCrud.demo;

import com.FirstCrud.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceImpl implements ClientService{
    ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository){
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
    public boolean updateClient(Client client, Long id) {
        if(clientRepository.existsById(id)){
            client.setClientID(id);
            clientRepository.save(client);
            return true;
        }
        else return false;
    }

    @Override
    public boolean deleteClientById(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        } else return false;
    }
}
