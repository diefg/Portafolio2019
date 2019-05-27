package com.portafolio.loginspring;

import com.portafolio.loginspring.BD.OracleSql;
import com.portafolio.loginspring.entity.request.CreateBookingRequest;
import com.portafolio.loginspring.entity.request.CreateClientRequest;
import org.junit.Test;

import javax.swing.text.DateFormatter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class ReservaTests {

    @Test
    public void crear(){
        Connection conn= OracleSql.getConnection();
        CallableStatement storedProc = null;
        CreateBookingRequest createBookingRequest=new CreateBookingRequest(LocalDate.now().toString(),"2019/05/29",1,1);
        System.out.println(createBookingRequest.toString());
        try {
            storedProc = conn.prepareCall("call sp_insertar_reserva(?,?,?,?)");
            storedProc.setDate(1, java.sql.Date.valueOf(java.time.LocalDate.now()));
            storedProc.setDate(2, Date.valueOf(createBookingRequest.getHoy()));
            storedProc.setInt(3,createBookingRequest.getIdCliente());
            storedProc.setInt(4,createBookingRequest.getIdServicio());
            storedProc.execute();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
