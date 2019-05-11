package com.portafolio.loginspring.controller;


import com.portafolio.loginspring.entity.request.LoginUserRequest;
import org.springframework.web.bind.annotation.*;

import java.sql.*;

@RestController
@RequestMapping("/usuarios")
public class LoginController {

    @PostMapping(value="/login")
    public boolean login(@RequestBody LoginUserRequest loginUserRequest){
        try{
            System.out.println(loginUserRequest.toString());
            Connection conn=getConnection();
            CallableStatement storedProc = conn.prepareCall("call checkLogin(?,?,?,?)");
            storedProc.setString(1, loginUserRequest.getUsuario());
            storedProc.setString(2, loginUserRequest.getContrasena());
            storedProc.registerOutParameter(3, Types.VARCHAR);
            storedProc.registerOutParameter(4, Types.INTEGER);
            Integer result= storedProc.executeUpdate();
            if (!storedProc.getString(3).isEmpty()){
                System.out.println("todo bien");
                System.out.println(storedProc.getString(3));
                System.out.println(storedProc.getString(4));


                return true;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @GetMapping(value="/saludar")
    public String prueba(){
        return "hola";
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
