package com.portafolio.loginspring.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.ref.PhantomReference;

@Data
@Entity
@Table(name = "ESTADO")
public class Estado {
    @Id
    @Column(name = "IDESTADO")
    private Integer id;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "ENTIDAD")
    private String entidad;
}
