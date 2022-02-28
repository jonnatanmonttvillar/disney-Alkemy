package com.disney.alkemy.DAO;

import com.disney.alkemy.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDAO extends JpaRepository<Usuario, Long>{
    
    Usuario findByUsername(String username);
}
