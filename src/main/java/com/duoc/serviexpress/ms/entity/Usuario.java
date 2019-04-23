package com.duoc.serviexpress.ms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")
public class Usuario {

    //http://www.oracle.com/technetwork/middleware/ias/id-generation-083058.html
    @Id
    @Column(name="idusuario")
    Integer idUsuario;
    @Column(name="user")
    String user;
    @Column(name="pass")
    String pass;
    @Column(name="nro_usuario")
    Integer NRO_USUARIO;
    @Column(name="id_admin")
    Integer ID_ADMIN;

    public Usuario(Integer idUsuario, String user, String pass, Integer NRO_USUARIO, Integer ID_ADMIN) {

        this.idUsuario = idUsuario;
        this.user = user;
        this.pass = pass;
        this.NRO_USUARIO = NRO_USUARIO;
        this.ID_ADMIN = ID_ADMIN;
    }

    public Usuario() {
    }

    @Override
    public String toString() {
        return "Usuario{" +
                ", idUsuario=" + idUsuario +
                ", user='" + user + '\'' +
                ", pass='" + pass + '\'' +
                ", NRO_USUARIO=" + NRO_USUARIO +
                ", ID_ADMIN=" + ID_ADMIN +
                '}';
    }


    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer getNRO_USUARIO() {
        return NRO_USUARIO;
    }

    public void setNRO_USUARIO(Integer NRO_USUARIO) {
        this.NRO_USUARIO = NRO_USUARIO;
    }

    public Integer getID_ADMIN() {
        return ID_ADMIN;
    }

    public void setID_ADMIN(Integer ID_ADMIN) {
        this.ID_ADMIN = ID_ADMIN;
    }
}

