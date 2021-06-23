package com.FirstCrud.demo;

import java.util.List;

public interface ClientService {

    void addClient(Client client);
    Client getClientById(Long id);
    void updateClient(Long id);
    void deleteClientById(Long id);
}
