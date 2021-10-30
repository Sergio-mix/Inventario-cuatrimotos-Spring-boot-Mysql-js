package co.edu.usa.inventario_cuatrimotos.service;

import co.edu.usa.inventario_cuatrimotos.model.Client;
import co.edu.usa.inventario_cuatrimotos.repositories.ClientRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client create(Client client) {
//        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
//        client.setPassword(argon2.hash(1, 1024, 1, client.getPassword()));
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
