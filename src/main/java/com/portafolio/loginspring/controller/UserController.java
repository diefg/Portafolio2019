package com.portafolio.loginspring.controller;

import com.portafolio.loginspring.entity.Usuario;
import com.portafolio.loginspring.entity.request.AddUserRequest;
import com.portafolio.loginspring.entity.request.LoginUserRequest;
import com.portafolio.loginspring.repository.EmpresaRepository;
import com.portafolio.loginspring.repository.RolRepository;
import com.portafolio.loginspring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UsuarioRepository userRepository;
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private EmpresaRepository empresaRepository;


    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping(value="/todos")
    public List<Usuario> findAllUsuarios(){
        List<Usuario> usr = new ArrayList<>();
        userRepository.findAll().forEach(usr::add);
        return usr;
    }



    @PostMapping(value="/login")
    public Usuario login(@RequestBody LoginUserRequest loginUserRequest){
        System.out.println("espera");
        String mensaje;
        //cambiar existebyid por findByid y si != null & loginrequest.contraseña = findusuario.contreseña son iguales
        Optional<Usuario> usuarioOptional = userRepository.findById(loginUserRequest.getUsuario());

        if (usuarioOptional.isPresent()){
            //mensaje="Bienvenido "+u.getUsuario();
            //Inicio de mensaje Json, se devolverá mensaje con rol y permisos
            return usuarioOptional.get();
//            u=userRepository.getUsuarioFromId(login.getUsuario());
//            ResponseBodye
        }

        throw new RuntimeException("Error de credenciales");
    }

    @PostMapping(value="/agregar")
    public ResponseEntity<UserController> addUser(@RequestBody AddUserRequest addUserRequest ){
        Usuario usuario = new Usuario();
        usuario.setUsuario(addUserRequest.getUsuario());
        usuario.setContraseña(addUserRequest.getContraseña());
        usuario.setNombre(addUserRequest.getNombre());
        usuario.setSNombre(addUserRequest.getsNombre());
        usuario.setRol(rolRepository.findById(addUserRequest.getRol()).get());
        usuario.setEmpresa(empresaRepository.findById(addUserRequest.getIdEmpresa()).get());
        if (usuario!=null){
            if (!userRepository.existsById(usuario.getUsuario())){
                userRepository.save(usuario);
                return new ResponseEntity<UserController>(HttpStatus.OK);
            }else {
                return new ResponseEntity<UserController>(HttpStatus.CONFLICT);
            }
        }else{
            return new ResponseEntity<UserController>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value="/borrar")
    public ResponseEntity<UserController> deleteUsuario(@RequestParam String usuario){
        if (userRepository.existsById(usuario)){
            userRepository.deleteById(usuario);
            return new ResponseEntity<UserController>(HttpStatus.OK);
        }else{
            //String mensaje="Usuario "+usuario+" No fue encontrado";
            return new ResponseEntity<UserController>(HttpStatus.CONFLICT);
        }
    }

}