package com.portafolio.loginspring;

//import com.portafolio.loginspring.entity.Usuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;

@SpringBootApplication
public class LoginSpringApplication {

    public static void main(String[] args) {

        SpringApplication.run(LoginSpringApplication.class, args);
    }
}
