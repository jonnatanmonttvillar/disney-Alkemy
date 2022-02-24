package com.disney.alkemy.rest;

import java.util.*;
import com.disney.alkemy.DAO.GeneroDAO;
import com.disney.alkemy.model.Genero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/genero")
public class GeneroREST {
       
    @Autowired
    public GeneroDAO generoDAO;


    @GetMapping("/getOne/{id_genero}")
    public Optional<Genero> findById(@PathVariable("id_genero") Long id_genero){
        return generoDAO.findById(id_genero);
    }


    @GetMapping("/getAll")
    public List<Genero> findAll(){
        return generoDAO.findAll();
    }

    @PostMapping("/post")
      public Genero post(@RequestBody Genero genero) {
          return generoDAO.save(genero);
      }

    @DeleteMapping("/delete/{id_genero}")
    public void deleteById(@PathVariable("id_genero") Long id_genero){
        generoDAO.deleteById(id_genero);
    }

    @PutMapping("/update")
    public void update(@RequestBody Genero genero){
        generoDAO.save(genero);
    }
    
}
