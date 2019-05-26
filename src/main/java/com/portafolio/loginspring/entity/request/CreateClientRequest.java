package com.portafolio.loginspring.entity.request;

public class CreateClientRequest {

    Integer rut;
    String nombre;
    String apellido;
    String direccion;
    Integer comuna;
    String correo;
    Integer idUsuario;

    public CreateClientRequest(Integer rut, String nombre, String apellido, String direccion, Integer comuna, String correo, Integer idUsuario) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.comuna = comuna;
        this.correo = correo;
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "CreateClientRequest{" +
                "rut=" + rut +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", comuna=" + comuna +
                ", correo='" + correo + '\'' +
                ", idUsuario=" + idUsuario +
                '}';
    }

    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getComuna() {
        return comuna;
    }

    public void setComuna(Integer comuna) {
        this.comuna = comuna;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
}
