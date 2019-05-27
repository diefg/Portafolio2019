package com.portafolio.loginspring.entity.request;

import javax.persistence.criteria.CriteriaBuilder;
import javax.swing.text.DateFormatter;
import java.time.LocalDate;

public class CreateBookingRequest {
    String hoy;
    String reserva;
    Integer idCliente;
    Integer idServicio;

    public CreateBookingRequest(String hoy, String reserva, Integer idCliente, Integer idServicio) {
        this.hoy = hoy;
        this.reserva = reserva;
        this.idCliente = idCliente;
        this.idServicio = idServicio;
    }

    @Override
    public String toString() {
        return "CreateBookingRequest{" +
                "hoy='" + hoy + '\'' +
                ", reserva='" + reserva + '\'' +
                ", idCliente=" + idCliente +
                ", idServicio=" + idServicio +
                '}';
    }

    public String getHoy() {
        return hoy;
    }

    public void setHoy(String hoy) {
        this.hoy = hoy;
    }

    public String getReserva() {
        return reserva;
    }

    public void setReserva(String reserva) {
        this.reserva = reserva;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }
}
