package com.portafolio.loginspring.entity;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.portafolio.loginspring.repository.UsuarioRepository;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@Table(name="USUARIO")
public class Usuario {

    /*
    @GeneratedValue(generator = "incrementor")
    @GenericGenerator(name = "incrementator",strategy = "increment")
    private long Id;
    */
    @Id
    @Column(name="USUARIO")
    private String usuario;
    @Column(name="NOMBREUSUARIO")
    private String nombre;
    @Column(name="APELLIDOUSUARIO")
    private String sNombre;
    @Column(name="CONTRASEÑA")
    private String contraseña;

    @Column(name="EMPRESA_IDEMPRESA")
    private int idEmpresa;

    @ManyToOne(cascade = CascadeType.DETACH)
    private Rol rol;
}
