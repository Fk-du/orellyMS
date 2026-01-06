package com.fkadu.rest.webservices.rest_web_servises.user;

import com.fkadu.rest.webservices.rest_web_servises.exception.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    private final UserDaoService userDaoService;
    public UserResource(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }
    @GetMapping("/users")
    public List<User> getUsers() {
        return userDaoService.getUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) throws UserNotFoundException {
        return userDaoService.getUser(id);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userDaoService.addUser(user);
        URI location =  ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser( @PathVariable Long id) {
        userDaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
