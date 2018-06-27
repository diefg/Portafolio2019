package com.portafolio.loginspring.entity;


import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.omg.CORBA.PRIVATE_MEMBER;

import javax.persistence.*;

@Data
@Entity
@Table(name = "HABITACION")
public class Habitacion {
    @Id
    @Column(name = "IDHABITACION")
    private Integer id;

    @Column(name = "ACCESORIOSHABITACION")
    private String accesorios;

    @Column(name = "NOMBREHABITACION")
    private String nombre;

    @Column(name = "PRECIOHABITACION")
    private Integer precio;

    @Column(name = "TIPOCAMA")
    private String tipoCama;

    @ManyToOne(cascade = CascadeType.DETACH)
    private Estado estado;

}
