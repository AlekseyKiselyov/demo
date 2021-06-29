package com.FirstCrud.demo;

import java.util.List;

public interface ClientService {

    void addClient(Client client);
    Client getClientById(Long id);
    boolean updateClient(Client client, Long id);
    boolean deleteClientById(Long id);
}
