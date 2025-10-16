package ru.task8.layouts;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.task8.layouts.client.AuthClient;
import ru.task8.layouts.model.Layout;
import ru.task8.layouts.repo.LayoutRepository;

@RestController
@RequestMapping("/layouts")
public class LayoutController {

    private final LayoutRepository repo;
    private final AuthClient authClient;

    public LayoutController(LayoutRepository repo, AuthClient authClient) {
        this.repo = repo;
        this.authClient = authClient;
    }

    @GetMapping
    public List<Layout> all() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Layout> get(@PathVariable("id") Long id) {
        return repo.findById(id)
                   .map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Layout layout, 
                                    @RequestHeader("Authorization") String token) {
        Map<String, String> userInfo = authClient.whoami(token);
        String username = userInfo.get("username");

        if (!username.equals(layout.getCreator())) {
            return ResponseEntity.status(403).body("Creator username does not match the authenticated user");
        }

        Layout saved = repo.save(layout);
        return ResponseEntity.ok(saved);
    }
}
