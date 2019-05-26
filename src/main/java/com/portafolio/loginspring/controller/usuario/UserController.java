package com.portafolio.loginspring.controller.usuario;


import com.portafolio.loginspring.BD.OracleSql;
import com.portafolio.loginspring.entity.request.CreateUserRequest;
import org.springframework.web.bind.annotation.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

@RestController
@RequestMapping("/usuario")
public class UserController {

    @PostMapping(value = "/crear")
    public void crearUsuario(@RequestBody CreateUserRequest createUserRequest) {
        Connection conn= OracleSql.getConnection();
        CallableStatement storedProc = null;
        try {
            storedProc = conn.prepareCall("call sp_insertar_usuario(?,?,?,?)");
            storedProc.setString(1, createUserRequest.getUsuario());
            storedProc.setString(2, createUserRequest.getPassword());
            storedProc.setInt(3,createUserRequest.getNumUsuario());
            storedProc.setInt(4,createUserRequest.getIdAdmin());
            storedProc.execute();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/borrar")
    public void eliminarUsuario(@RequestParam("id") Integer id){
        Connection conn= OracleSql.getConnection();
        CallableStatement storedProc = null;
        try {
            storedProc = conn.prepareCall("call sp_eliminar_usuario(?)");
            storedProc.setInt(1,id);
            storedProc.execute();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/obtener")
    public void getUser(){

    }
    @PostMapping(value = "/modificar")
    public void modifyUser(){

    }


}
