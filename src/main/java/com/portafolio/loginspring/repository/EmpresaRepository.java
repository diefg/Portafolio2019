package com.portafolio.loginspring.repository;

import com.portafolio.loginspring.entity.Empresa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface EmpresaRepository extends CrudRepository<Empresa,Integer> {

}
