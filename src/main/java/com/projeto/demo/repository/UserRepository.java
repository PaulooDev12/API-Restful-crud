package com.projeto.demo.repository;

import com.projeto.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {

}
