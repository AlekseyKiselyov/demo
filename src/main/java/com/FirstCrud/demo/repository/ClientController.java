package com.FirstCrud.demo.repository;

import com.FirstCrud.demo.Client;
import com.FirstCrud.demo.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {
    private final ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(value = "/clients")
    public ResponseEntity<?> addClient(@RequestBody Client client) {
        clientService.addClient(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/clients/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable(name = "id") long id) {
        final Client client = clientService.getClientById(id);

        return client != null
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/clients/{id}")
    public ResponseEntity<?> updateClient(@PathVariable(name = "id") long id, @RequestBody Client client) {
        final boolean updated = clientService.updateClient(client, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/clients/{id}")
    public ResponseEntity<?> deleteClientById(@PathVariable(name = "id") long id) {
        final boolean deleted = clientService.deleteClientById(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
