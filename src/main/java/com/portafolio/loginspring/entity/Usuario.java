package com.portafolio.loginspring.entity;

import com.portafolio.loginspring.repository.UsuarioRepository;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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
    private int rol;
    @Column(name="EMPRESA_IDEMPRESA")
    private int idEmpresa;

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
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
}
