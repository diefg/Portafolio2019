package com.portafolio.loginspring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.List;

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

    @JsonIgnore
    @OneToMany(targetEntity = Habitacion.class, mappedBy = "estado")
    private List<Habitacion> habitaciones = new ArrayList<>();


}
