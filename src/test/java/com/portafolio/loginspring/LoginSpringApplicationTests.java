package com.portafolio.loginspring;

import com.portafolio.loginspring.BD.OracleSql;
import com.portafolio.loginspring.entity.request.CreateClientRequest;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.Null;
import java.sql.*;

public class LoginSpringApplicationTests {

    @Test
    public void contextLoads() {
        try
        {
            Connection conn=getConnection();
            CallableStatement storedProc = conn.prepareCall("call checkLogin(?,?,?,?)");
            storedProc.setString(1, "admin");
            storedProc.setString(2, "admin");
            storedProc.registerOutParameter(3, Types.VARCHAR);
            storedProc.registerOutParameter(4, Types.INTEGER);
            Integer result= storedProc.executeUpdate();
            if (!storedProc.getString(3).isEmpty()){
                System.out.println("existe algo");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }catch (NullPointerException nul){
            System.out.println("no hay nada");
        }
    }

    @Test
    public void testCrearUsuario(){
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



    public Connection getConnection(){
        System.out.println("-------- Oracle JDBC Connection Testing ------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();

        }

        System.out.println("Oracle JDBC Driver Registered!");

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "PORTAFOLIO1", "123");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
        return connection;
    }

}
