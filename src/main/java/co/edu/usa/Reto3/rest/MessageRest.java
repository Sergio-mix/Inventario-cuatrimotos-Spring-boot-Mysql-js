package co.edu.usa.Reto3.rest;

import co.edu.usa.Reto3.model.Client;
import co.edu.usa.Reto3.model.Message;
import co.edu.usa.Reto3.model.Quadbike;
import co.edu.usa.Reto3.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/Message/")
public class MessageRest {
    private final MessageService messageService;

    public MessageRest(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("all")
    @ResponseStatus(HttpStatus.OK)
    private List<Map<String, Object>> listMessage() {
        return messageService.getAll();
    }

    @PostMapping(value = "save")
    @ResponseStatus(HttpStatus.CREATED)
    private void saveMessage(@RequestBody Message message) {
        messageService.create(message);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    private Message idMessage(@PathVariable("id") Long id) {
        return messageService.findById(id);
    }
}
