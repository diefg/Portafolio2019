package com.portafolio.loginspring.repository;

import com.portafolio.loginspring.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface LoginRepository extends JpaRepository<Usuario, String> {
}
