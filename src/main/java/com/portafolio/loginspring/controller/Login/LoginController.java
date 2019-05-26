package com.portafolio.loginspring.controller.Login;


import com.portafolio.loginspring.BD.OracleSql;
import com.portafolio.loginspring.entity.request.LoginUserRequest;
import org.springframework.web.bind.annotation.*;

import java.sql.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping(value="/autenticar")
    public boolean login(@RequestBody LoginUserRequest loginUserRequest){
        try{
            System.out.println(loginUserRequest.toString());
            Connection conn= OracleSql.getConnection();
            CallableStatement storedProc = conn.prepareCall("call checkLogin(?,?,?,?)");
            storedProc.setString(1, loginUserRequest.getUsuario());
            storedProc.setString(2, loginUserRequest.getContrasena());
            storedProc.registerOutParameter(3, Types.VARCHAR);
            storedProc.registerOutParameter(4, Types.INTEGER);
            Integer result= storedProc.executeUpdate();
            conn.close();
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
}
