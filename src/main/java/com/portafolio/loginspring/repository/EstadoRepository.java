package com.portafolio.loginspring.repository;

import com.portafolio.loginspring.entity.Estado;
import com.portafolio.loginspring.entity.Habitacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface EstadoRepository extends CrudRepository<Estado,Integer> {
}
