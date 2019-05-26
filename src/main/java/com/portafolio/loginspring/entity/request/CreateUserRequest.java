package com.portafolio.loginspring.entity.request;

public class CreateUserRequest {
    String usuario;
    String password;
    Integer numUsuario;
    Integer idAdmin;

    public CreateUserRequest(String usuario, String password, Integer numUsuario, Integer idAdmin) {
        this.usuario = usuario;
        this.password = password;
        this.numUsuario = numUsuario;
        this.idAdmin = idAdmin;
    }

    @Override
    public String toString() {
        return "CreateUserRequest{" +
                "usuario='" + usuario + '\'' +
                ", password='" + password + '\'' +
                ", numUsuario=" + numUsuario +
                ", idAdmin=" + idAdmin +
                '}';
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getNumUsuario() {
        return numUsuario;
    }

    public void setNumUsuario(Integer numUsuario) {
        this.numUsuario = numUsuario;
    }

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }
}
