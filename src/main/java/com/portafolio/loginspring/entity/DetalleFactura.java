package com.portafolio.loginspring.entity;

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

    @ManyToOne(targetEntity = Factura.class)
    private Factura factura;
}

