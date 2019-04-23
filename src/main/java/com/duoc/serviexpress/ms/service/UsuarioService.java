package com.duoc.serviexpress.ms.service;

import com.duoc.serviexpress.ms.entity.Usuario;
import com.duoc.serviexpress.ms.repository.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioDAO usuarioDAO;

    public Boolean getUsuario(Integer id ){
       return this.usuarioDAO.existsById(id);
    }
}

