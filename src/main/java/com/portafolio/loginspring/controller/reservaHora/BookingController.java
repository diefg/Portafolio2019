package com.portafolio.loginspring.controller.reservaHora;

import com.portafolio.loginspring.BD.OracleSql;
import com.portafolio.loginspring.entity.request.CreateBookingRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

@RestController
@RequestMapping("/reserva")
public class BookingController {

    @PostMapping(value="/crear")
    public void crear(@RequestBody CreateBookingRequest createBookingRequest){
        Connection conn= OracleSql.getConnection();
        CallableStatement storedProc = null;
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
