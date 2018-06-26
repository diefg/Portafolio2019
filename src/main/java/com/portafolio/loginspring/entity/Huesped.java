package com.portafolio.loginspring.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "HUESPED")
public class Huesped {

    @Id
    @Column(name = "RUTHUESPED")
    private String rut;

    @Column(name = "APELLIDOHUESPED")
    private String apellidoHuesped;

    @Column(name = "FECHAENTRADA")
    private java.sql.Date fechaEntrada;

    @Column(name = "FECHAENTRADA")
    private java.sql.Date fechaSalida;

    @Column(name = "NOMBREUSUARIO")
    private String nombreHuesped;



}
