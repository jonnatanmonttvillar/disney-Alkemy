package com.disney.alkemy.rest;

import java.util.*;
import com.disney.alkemy.DAO.PeliculaDAO;
import com.disney.alkemy.model.Peliculas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class PeliculaREST {
    
    @Autowired
    public PeliculaDAO peliculaDAO;


    @GetMapping("/getOne/{id_pelicula}")
    public Optional<Peliculas> findById(@PathVariable("id_pelicula") Long id_pelicula){
        return peliculaDAO.findById(id_pelicula);
    }


    @GetMapping("/getAll")
    public List<Peliculas> findAll(){
        return peliculaDAO.findAll();
    }

    @PostMapping("/post")
      public Peliculas post(@RequestBody Peliculas peliculas) {
          return peliculaDAO.save(peliculas);
      }

    @DeleteMapping("/delete/{id_pelicula}")
    public void deleteById(@PathVariable("id_pelicula") Long id_pelicula){
        peliculaDAO.deleteById(id_pelicula);
    }

    @PutMapping("/update")
    public void update(@RequestBody Peliculas peliculas){
        peliculaDAO.save(peliculas);
    }
    
}
