package co.edu.usa.Reto3.rest;

import co.edu.usa.Reto3.model.Client;
import co.edu.usa.Reto3.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Client/")
public class ClientRest {

    private final ClientService clientService;

    public ClientRest(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("all")
    @ResponseStatus(HttpStatus.OK)
    private List<Client> listClient() {
        return clientService.getAll();
    }

    @PostMapping(value = "save")
    @ResponseStatus(HttpStatus.CREATED)
    private void saveclient(@RequestBody Client client) {
        clientService.create(client);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    private Client idclient(@PathVariable("id") Long id) {
        return clientService.findById(id);
    }

}
