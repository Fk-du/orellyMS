package com.fkadu.rest.webservices.rest_web_servises.user;

import com.fkadu.rest.webservices.rest_web_servises.exception.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
    public EntityModel<User> getUser(@PathVariable Long id) throws UserNotFoundException {
        if (userDaoService.getUser(id) == null) {
            throw new  UserNotFoundException("User not found");
        }
        EntityModel<User> entityModel = EntityModel.of(userDaoService.getUser(id));
        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(methodOn(
                this.getClass()).getUsers());
        entityModel.add(linkTo.withRel("all-users"));
        return entityModel;
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
