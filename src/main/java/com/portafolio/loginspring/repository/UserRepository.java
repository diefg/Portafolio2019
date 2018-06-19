package com.portafolio.loginspring.repository;

import com.portafolio.loginspring.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface UserRepository extends JpaRepository<Usuario, String> {

//    @Query("select * from User u where u.emailAddress = ?1")
//    Usuario findByEmailAddress(String emailAddress);
    @Query("select * from Usuario")
    List<Usuario> findAll();
}
