package com.portafolio.loginspring.controller;

import com.portafolio.loginspring.entity.Login;
import com.portafolio.loginspring.entity.Usuario;
import com.portafolio.loginspring.entity.request.AddUserRequest;
import com.portafolio.loginspring.entity.request.LoginUserRequest;
import com.portafolio.loginspring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    public  UserController(UsuarioRepository userRepository){
        this.userRepository = userRepository;
    }

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping(value="/todos")
    public List<Usuario> findAllUsuarios(){
        List<Usuario> usr = new ArrayList<>();
        userRepository.findAll().forEach(usr::add);
        return usr;

    }

    @PostMapping(value="/login")
    public ResponseEntity<?> login(@RequestBody LoginUserRequest loginUserRequest){
        String mensaje;
        //cambiar existebyid por findByid y si != null & loginrequest.contraseña = findusuario.contreseña son iguales
        Usuario u;
        u=userRepository.findById(loginUserRequest.getUsuario()).get();
        if (u!=null){
            mensaje="Bienvenido "+u.getUsuario();
            //Inicio de mensaje Json, se devolverá mensaje con rol y permisos
            return new ResponseEntity<>(u,HttpStatus.OK);
//            u=userRepository.getUsuarioFromId(login.getUsuario());
//            ResponseBodye
        }else{
            mensaje="Error en credenciales";
            return new ResponseEntity<>(mensaje,HttpStatus.UNAUTHORIZED);
        }

    }




    @PostMapping(value="/agregar")
    public void addUser(@RequestBody AddUserRequest addUserRequest ){
        Usuario usuario = new Usuario();
        usuario.setUsuario(addUserRequest.getUsuario());
        usuario.setContraseña(addUserRequest.getContraseña());
        usuario.setNombre(addUserRequest.getNombre());
        usuario.setsNombre(addUserRequest.getsNombre());
        usuario.setRol(addUserRequest.getRol());
        usuario.setIdEmpresa(1);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(usuario);
        entityManager.getTransaction().commit();
        entityManager.close();
        userRepository.save(usuario);

    }





}