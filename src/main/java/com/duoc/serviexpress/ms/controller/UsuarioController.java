package com.duoc.serviexpress.ms.controller;

import com.duoc.serviexpress.ms.entity.Usuario;
import com.duoc.serviexpress.ms.entity.request.LoginUserRequest;
import com.duoc.serviexpress.ms.repository.UsuarioDAO;
import com.duoc.serviexpress.ms.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping(value="/prueba")
    public boolean login(){
        return usuarioService.getUsuario(1);
        //return userRepository.existsById(login.getUsuario());
    }
}
