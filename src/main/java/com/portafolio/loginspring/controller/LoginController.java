package com.portafolio.loginspring.controller;


import com.portafolio.loginspring.entity.Login;
import com.portafolio.loginspring.entity.Usuario;
import com.portafolio.loginspring.entity.request.LoginUserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@RestController
@RequestMapping("/usuarios")
public class LoginController {

    @PostMapping(value="/loginViejo")
    public boolean login(@RequestBody LoginUserRequest loginUserRequest){


        Login login = new Login();
        login.setUsuario(loginUserRequest.getUsuario());
        login.setContraseña(loginUserRequest.getContraseña());
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        login=entityManager.find(login.getClass(),login.getUsuario());
        //entityManager.getTransaction().commit();
        entityManager.close();
        if (login!=null){
            System.out.println(login.getUsuario());
            return true;
        }else{
            return false;
        }
        //return userRepository.existsById(login.getUsuario());
    }
}
