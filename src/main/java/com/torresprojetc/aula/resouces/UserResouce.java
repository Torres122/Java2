package com.torresprojetc.aula.resouces;

import com.torresprojetc.aula.entities.User;
import com.torresprojetc.aula.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (value = "/users")
public class UserResouce {


    @Autowired
        private UserService userService;


    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> userList = userService.findAll();
        return ResponseEntity.ok().body(userList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return userService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado com id: " + id)
                );
    }

}
