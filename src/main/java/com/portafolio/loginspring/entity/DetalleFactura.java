package com.portafolio.loginspring.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "DETALLEFACTURA")
public class DetalleFactura {
    @Id
    @Column(name="DETALLEFACTURA")
    private Integer id;
    private Factura factura;


}
