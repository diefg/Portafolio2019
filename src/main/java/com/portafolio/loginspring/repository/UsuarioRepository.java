package com.portafolio.loginspring.repository;

import com.portafolio.loginspring.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface UsuarioRepository extends CrudRepository<Usuario, String> {

    //List<Usuario> findAll();


    //EmployeeBE saveEmployee(EmployeeBE employeeBE);

   // EmployeeBE updateEmployee(EmployeeBE employeeBE);

    //EmployeeBE findById(int id);

}