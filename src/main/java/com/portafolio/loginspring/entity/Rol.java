package com.portafolio.loginspring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name="ROL")
public class Rol {

    @Id
    @Column(name="IDROL")
    private Integer id;

    @Column(name="NOMBRE")
    private String nombre;

    @Column(name="VIGENTE")
    private Integer vigente;
    @OneToOne(targetEntity = Usuario.class,fetch = FetchType.LAZY)

    @JsonIgnore
    @OneToMany(targetEntity = Usuario.class, mappedBy = "rol")
    private List<Usuario> usuarios = new ArrayList<>();
}
