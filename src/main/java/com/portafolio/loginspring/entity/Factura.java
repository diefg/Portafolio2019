package com.portafolio.loginspring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FACTURA")
public class Factura {
    @Id
    @Column(name="IDFACTURA")
    int idFactura;
    @Column(name="ORDENCOMPRA_IDDOC")
    int idOc;
    @Column(name="TIPOMONEDA")
    String tipoMoneda;

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdOc() {
        return idOc;
    }

    public void setIdOc(int idOc) {
        this.idOc = idOc;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }
}
