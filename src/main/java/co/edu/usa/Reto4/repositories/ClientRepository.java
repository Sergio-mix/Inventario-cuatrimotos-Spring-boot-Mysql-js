package co.edu.usa.Reto4.repositories;

import co.edu.usa.Reto4.model.Client;
import co.edu.usa.Reto4.repositories.jpa.ClientJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    @Autowired
    private ClientJpaRepository clientJpaRepository;

    public Client create(Client client) {
        return clientJpaRepository.save(client);
    }

    public List<Client> getAll() {
        return clientJpaRepository.findAll();
    }

    public Client findById(Long id) {
        Optional<Client> client = Optional.of(clientJpaRepository.getById(id));
        return client.orElse(new Client());
    }

    public void remove(Long id) {
        clientJpaRepository.deleteById(id);
    }

    public void update(Client client) {
        clientJpaRepository.saveAndFlush(client);
    }
}
