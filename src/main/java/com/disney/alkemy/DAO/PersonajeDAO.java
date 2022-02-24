package com.disney.alkemy.DAO;

import java.util.List;

import com.disney.alkemy.model.Personajes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface PersonajeDAO extends JpaRepository<Personajes, Long>{
  
    @Transactional(readOnly = true)
    List<Personajes> findByNombre(String nombre);

    @Transactional(readOnly = true)
    List<Personajes> findByEdad(Integer edad);
    
}

