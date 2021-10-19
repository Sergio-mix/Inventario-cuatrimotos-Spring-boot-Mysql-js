package co.edu.usa.Reto3.service;

import co.edu.usa.Reto3.model.Client;

import co.edu.usa.Reto3.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client create(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Client findById(Long id) {
        Optional<Client> client = Optional.of(clientRepository.getById(id));
        return client.orElse(new Client());
    }

}
