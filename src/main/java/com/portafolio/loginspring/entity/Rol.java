package com.portafolio.loginspring.entity;

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
    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
    private List<Usuario> usuarios = new ArrayList<>();




}
