package com.portafolio.loginspring.controller.cliente;

import com.portafolio.loginspring.BD.OracleSql;
import com.portafolio.loginspring.entity.request.CreateClientRequest;
import com.portafolio.loginspring.entity.request.CreateUserRequest;
import org.springframework.web.bind.annotation.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {

    @PostMapping(value = "/crear")
    public void crearUsuario(@RequestBody CreateClientRequest createClientRequest) {
        Connection conn= OracleSql.getConnection();
        CallableStatement storedProc = null;
        try {
            storedProc = conn.prepareCall("call sp_insertar_cliente(?,?,?,?,?,?,?)");
            storedProc.setInt(1,createClientRequest.getRut());
            storedProc.setString(2, createClientRequest.getNombre());
            storedProc.setString(3, createClientRequest.getApellido());
            storedProc.setString(4, createClientRequest.getDireccion());
            storedProc.setInt(5, createClientRequest.getComuna());
            storedProc.setString(6, createClientRequest.getCorreo());
            storedProc.setInt(7, createClientRequest.getIdUsuario());
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
            storedProc = conn.prepareCall("call sp_eliminar_cliente(?)");
            storedProc.setInt(1,id);
            storedProc.execute();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
