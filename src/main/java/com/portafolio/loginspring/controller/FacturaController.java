package com.portafolio.loginspring.controller;

import com.portafolio.loginspring.entity.Factura;
import com.portafolio.loginspring.entity.request.FacturaRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/factura")
public class FacturaController {

    @PostMapping(value="/obternerFactura")
    public Factura obtener(@RequestBody FacturaRequest facturaRequest){
        Factura factura = new Factura();
        factura.setIdFactura(123);
        factura.setIdOc(0);
        factura.setTipoMoneda("CLP");
        return factura;
    }
}
