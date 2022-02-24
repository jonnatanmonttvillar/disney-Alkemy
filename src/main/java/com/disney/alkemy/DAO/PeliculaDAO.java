package com.disney.alkemy.DAO;

import com.disney.alkemy.model.Peliculas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaDAO extends JpaRepository<Peliculas, Long>{
    
}
