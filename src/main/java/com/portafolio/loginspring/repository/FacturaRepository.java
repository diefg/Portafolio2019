package com.portafolio.loginspring.repository;

import com.portafolio.loginspring.entity.Factura;
import com.portafolio.loginspring.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Integer> {
}
