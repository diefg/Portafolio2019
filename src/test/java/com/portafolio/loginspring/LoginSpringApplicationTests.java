package com.portafolio.loginspring;

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
