package com.projeto.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity
@Table(name = "usuarios")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    @NotNull
    private String nome;

    @Email
    private String email;

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

}
