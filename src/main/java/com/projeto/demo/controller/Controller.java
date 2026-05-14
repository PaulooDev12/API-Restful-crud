package com.projeto.demo.controller;

import com.projeto.demo.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.demo.service.UserService;
import java.util.List;


@RestController

@RequestMapping("/users")

public class Controller {

    private final UserService service;

    public Controller(UserService service){
        this.service = service;
    }
    @PostMapping("/usuario")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(user));
    }
    @GetMapping("/listar")
    public List<User> listar(){
        return service.listar();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
            service.deletar(id);
            return ResponseEntity.noContent().build();
        }
        @PutMapping("/edit/{id}")
        public ResponseEntity<User> atualizar(@PathVariable Long id, @RequestBody User user){

        return ResponseEntity.ok(service.atualizar(id, user));
        }
    }






