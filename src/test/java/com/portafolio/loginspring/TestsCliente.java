package com.portafolio.loginspring;

import com.portafolio.loginspring.BD.OracleSql;
import com.portafolio.loginspring.entity.request.CreateClientRequest;
import org.junit.Test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class TestsCliente {

    @Test
    public void testEliminar(){
        Connection conn= OracleSql.getConnection();
        CallableStatement storedProc = null;
        try {
            storedProc = conn.prepareCall("call sp_eliminar_cliente(?)");
            storedProc.setInt(1,2);
            storedProc.execute();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCrear(){
        Connection conn= OracleSql.getConnection();
        CallableStatement storedProc = null;
        CreateClientRequest createClientRequest= new CreateClientRequest(1234,"Test","TestApellido","Direccion test 1",1,"TEST@TEST.CL",1);
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

    @Test
    public void testModificar(){
        Connection conn= OracleSql.getConnection();
        CallableStatement storedProc = null;
        CreateClientRequest createClientRequest= new CreateClientRequest(1234,"Test","TestApellido","Direccion test 1",1,"TEST@TEST.CL",1);
        try {
            storedProc = conn.prepareCall("EXECUTE sp_modificar_cliente(?,?,?,?,?,?,?)");
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
}
