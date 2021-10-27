package co.edu.usa.reto4.rest;

import co.edu.usa.reto4.model.Client;
import co.edu.usa.reto4.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/Client/")
@CrossOrigin
public class ClientRest {

    private final ClientService clientService;

    public ClientRest(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("all")
    @ResponseStatus(value = HttpStatus.OK)
    private List<Client> listClient() {
        return clientService.getAll();
    }

    @PostMapping(value = "save")
    @ResponseStatus(value = HttpStatus.CREATED)
    private void saveClient(@Valid @RequestBody Client client) {
        clientService.create(client);
    }

    @GetMapping("{id}")
    @ResponseStatus(value = HttpStatus.OK)
    private Client idClient(@PathVariable("id") Long id) {
        return clientService.findById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    private void removeClient(@PathVariable("id") Long id) {
        clientService.remove(id);
    }

    @PutMapping(value = "update")
    @ResponseStatus(value = HttpStatus.CREATED)
    private void updateClient(@RequestBody Client client) {
        clientService.update(client);
    }

}
