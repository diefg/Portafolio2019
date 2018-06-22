package com.portafolio.loginspring.entity;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.portafolio.loginspring.repository.UsuarioRepository;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    @Column(name="ROL_IDROL")
    private int rolInt;
    @Column(name="EMPRESA_IDEMPRESA")
    private int idEmpresa;


    @ManyToOne(targetEntity = Rol.class)
    @JoinColumn(name = "IDROL")
    private List<Rol> rols = new ArrayList<>();

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getRol() {
        return rolInt;
    }

    public void setRol(int rol) {
        this.rolInt = rol;
    }

    /*
        public long getId() {
            return Id;
        }

        public void setId(long id) {
            Id = id;
        }

    */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getsNombre() {
        return sNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

/*
    @JsonSerialize(using = RolSerializer.class)
    public Rol getRol() {
        return rol;
    }
    */

    public class RolSerializer extends JsonSerializer<Rol> {
        @Override
        public void serialize(Rol rol, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
                throws IOException, JsonProcessingException {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("rol", rol.getNombre());
            jsonGenerator.writeStringField("vigente", String.valueOf(rol.getVigente()));
            jsonGenerator.writeEndObject();
        }
    }
}
