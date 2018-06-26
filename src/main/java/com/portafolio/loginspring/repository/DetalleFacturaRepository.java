package com.portafolio.loginspring.repository;

import com.portafolio.loginspring.entity.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Integer> {

}
