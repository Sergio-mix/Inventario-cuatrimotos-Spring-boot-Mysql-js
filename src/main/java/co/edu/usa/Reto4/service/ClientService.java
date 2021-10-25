package co.edu.usa.Reto4.service;

import co.edu.usa.Reto4.model.Client;
import co.edu.usa.Reto4.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client create(Client client) {
        return clientRepository.create(client);
    }

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Client findById(Long id) {
        return clientRepository.findById(id);
    }

    public void remove(Long id) {
        clientRepository.remove(id);
    }

    public void update(Client client) {
        clientRepository.update(client);
    }

}
