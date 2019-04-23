package com.duoc.serviexpress.ms.repository;

import com.duoc.serviexpress.ms.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDAO extends JpaRepository <Usuario, Integer>  {
}
