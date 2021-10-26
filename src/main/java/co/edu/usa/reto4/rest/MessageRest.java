package co.edu.usa.reto4.rest;

import co.edu.usa.reto4.model.Message;
import co.edu.usa.reto4.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/Message/")
//@CrossOrigin
public class MessageRest {
    private final MessageService messageService;

    public MessageRest(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("all")
    @ResponseStatus(value = HttpStatus.OK)
    private List<Message> listMessage() {
        return messageService.getAll();
    }

    @PostMapping(value = "save")
    @ResponseStatus(value = HttpStatus.CREATED)
    private void saveMessage(@Valid @RequestBody Message message) {
        messageService.create(message);
    }

    @GetMapping("{id}")
    @ResponseStatus(value = HttpStatus.OK)
    private Message idMessage(@PathVariable("id") Long id) {
        return messageService.findById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    private void removeMessage(@PathVariable("id") Long id) {
        messageService.remove(id);
    }

    @PutMapping(value = "update")
    @ResponseStatus(value = HttpStatus.CREATED)
    private void updateMessage(@RequestBody Message message) {
        messageService.update(message);
    }
}
