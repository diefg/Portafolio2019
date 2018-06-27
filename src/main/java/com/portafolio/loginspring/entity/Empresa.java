package com.portafolio.loginspring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @JsonIgnore
    @OneToMany(targetEntity = Usuario.class, mappedBy = "empresa")
    private List<Usuario> usuarios = new ArrayList<>();


}
