package com.projeto.demo.service;

import com.projeto.demo.exception.ResourceNotFoundException;
import com.projeto.demo.repository.UserRepository;
import com.projeto.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;

    }
    public User criar(User user){
        return repository.save(user);

    }
    public List<User> listar(){
        return repository.findAll();
    }
    public void deletar(Long id){
        if(!repository.existsById(id)){
            throw new ResourceNotFoundException("Usuario não encontrado");
        }
        repository.deleteById(id);


    }
    public User atualizar(Long id, User userAtualizado){
        User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("usuario nao encontrado"));
        user.setNome(userAtualizado.getNome());
        user.setEmail(userAtualizado.getEmail());

        return repository.save(user);
    }

}
