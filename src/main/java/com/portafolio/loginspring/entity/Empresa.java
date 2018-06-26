package com.portafolio.loginspring.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "EMPRESA")
public class Empresa {

    @Id
    @Column(name = "IDEMPRESA")
    private Integer id;
    @Column(name = "DIRECCIONEMPRESA")
    private String direccionEmpresa;
    @Column(name = "NOMBREEMPRESA")
    private String nombreEmpresa;
    @Column(name = "RUTEMPRESA")
    private String rutEmpresa;
    @Column(name = "TELEFONOEMPRESA")
    private Integer telefono;
    }
