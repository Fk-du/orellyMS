package com.fkadu.rest.webservices.rest_web_servises.user;

import com.fkadu.rest.webservices.rest_web_servises.exception.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static Long userid = 0L;
    static {
        users.add(new User(++userid, "fkadu", "emplotyee", LocalDateTime.now().minusYears(30)));
        users.add(new User(++userid, "dejen", "emplotyee", LocalDateTime.now().minusYears(30)));
        users.add(new User(++userid, "gelila", "emplotyee", LocalDateTime.now().minusYears(30)));
    }
    public List<User> getUsers() {
        return users;
    }

    public User getUser(Long id) throws UserNotFoundException {
        return users.stream()
                .filter(u -> Objects.equals(u.getId(), id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }


    public User addUser(User user) {
        user.setId(++userid);
        users.add(user);
        return user;
    }

    public void deleteById(Long id) {
        users.removeIf(u -> u.getId().equals(id));
    }
}
