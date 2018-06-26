package com.portafolio.loginspring.controller;

import com.portafolio.loginspring.entity.Factura;
import com.portafolio.loginspring.entity.Usuario;
import com.portafolio.loginspring.entity.request.FacturaRequest;
import com.portafolio.loginspring.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/factura")
public class FacturaController {

    @Autowired
    private FacturaRepository facturaRepository;
    @PostMapping(value="/obternerFactura")
    public Optional<Factura> obtener(@RequestBody FacturaRequest facturaRequest){
        Optional<Factura> facturaOptional = facturaRepository.findById(facturaRequest.getIdfactura());
        return facturaOptional;
    }

    @GetMapping(value="/todos")
    public List<Factura> findAllFacturas(){
        List<Factura> facturas = new ArrayList<>();
        facturaRepository.findAll().forEach(facturas::add);
        return facturas;
    }

    @PostMapping(value = "agregar")
    public void addFactura(@RequestBody FacturaRequest facturaRequest){

    }

}
