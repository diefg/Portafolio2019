package com.portafolio.loginspring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="DETALLEFACTURA")
public class DetalleFactura {
    @Id
    @Column(name="IDDETALLEFACTURA")
    private Integer id;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    @Column(name = "VALORTOTAL")
    private Integer valorTotal;


    //@ManyToOne(cascade = CascadeType.DETACH)
    //@JsonIgnore
    @JsonIgnore
    @ManyToOne(targetEntity = Factura.class)
    @JoinColumn(name = "IDFACTURA")
    private Factura factura;

}

