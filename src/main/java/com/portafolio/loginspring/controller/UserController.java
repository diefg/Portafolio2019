package com.portafolio.loginspring.controller;

import com.portafolio.loginspring.entity.Usuario;
import com.portafolio.loginspring.entity.request.AddUserRequest;
import com.portafolio.loginspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public  UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping(value="/todos")
    public List<Usuario> findAllUsers(){

        return userRepository.findAll();
    }

    @PostMapping(value="/agregar")
    public void addUser(@RequestBody AddUserRequest addUserRequest ){
        Usuario usuario = new Usuario();
        usuario.setUsuario(addUserRequest.getUsuario());
        usuario.setContraseña(addUserRequest.getContraseña());
        usuario.setNombre(addUserRequest.getNombre());
        usuario.setsNombre(addUserRequest.getsNombre());
        usuario.setRol(addUserRequest.getRol());

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(usuario);
        entityManager.getTransaction().commit();
        entityManager.close();
        userRepository.save(usuario);

    }





}
