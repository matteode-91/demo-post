package it.scuola.demo_post;
import java.util.List;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/messages")
public class MessageController {
private final MessageRepository repo;
public MessageController(MessageRepository repo) {
this.repo = repo;
}

@GetMapping
public List<Message> all() {
return repo.findAll();
}

@PostMapping
public Message create(@RequestBody Message msg) {
return repo.save(msg);
}

@DeleteMapping
public Map<String, Integer> delete(@RequestBody Message msg) {
    List<Message> messagesToDelete = repo.findByText(msg.getText());
    int count = messagesToDelete.size();
    repo.deleteAll(messagesToDelete);
    return Map.of("deleted", count);
}
}