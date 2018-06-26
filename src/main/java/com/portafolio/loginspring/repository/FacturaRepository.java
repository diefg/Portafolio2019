package com.portafolio.loginspring.repository;

import com.portafolio.loginspring.entity.Factura;
import com.portafolio.loginspring.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface FacturaRepository extends CrudRepository<Factura, Integer> {
}
