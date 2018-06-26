package com.portafolio.loginspring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@Table(name="FACTURA")
public class Factura {
    @Id
    @Column(name="IDFACTURA")
    private int idFactura;
    @Column(name="ORDENCOMPRA_IDDOC")
    private int idOc;
    @Column(name="TIPOMONEDA")
    private String tipoMoneda;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "factura")
    private List<DetalleFactura> detalles = new ArrayList<>();

}
