package com.portafolio.loginspring.repository;

import com.portafolio.loginspring.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
