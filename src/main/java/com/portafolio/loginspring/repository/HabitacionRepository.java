package com.portafolio.loginspring.repository;


import com.portafolio.loginspring.entity.Habitacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface HabitacionRepository extends CrudRepository<Habitacion,Integer> {
}
