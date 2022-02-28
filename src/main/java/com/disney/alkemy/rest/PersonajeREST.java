package com.disney.alkemy.rest;

import java.util.*;
import com.disney.alkemy.DAO.PersonajeDAO;
import com.disney.alkemy.model.Personajes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/characters")
public class PersonajeREST{
    
    @Autowired
    public PersonajeDAO personajeDAO;

    @GetMapping("/getAll")
    public List<Personajes> findAll(){
       return personajeDAO.findAll();
    }

    @GetMapping("/getOne/{id_personaje}")
    public Optional<Personajes> findById(@PathVariable("id_personaje") Long id_personaje){
        return personajeDAO.findById(id_personaje);
    }

    @GetMapping(value = "/name={nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional(readOnly = true)
    public ResponseEntity<List<Personajes>> findAll(@PathVariable("nombre") String nombre){
        return ResponseEntity.ok(this.personajeDAO.findByNombre(nombre));
    }

    @GetMapping("/age={edad}")
    @Transactional(readOnly = true)
    public ResponseEntity<List<Personajes>> findByEdad(@PathVariable("edad") Integer edad){
        return ResponseEntity.ok(this.personajeDAO.findByEdad(edad));
    }

    @PostMapping("/post")
      public Personajes post(@RequestBody Personajes personajes) {
          return personajeDAO.save(personajes);
      }

    @DeleteMapping("/delete/{id_personaje}")
    public void deleteById(@PathVariable("id_personaje") Long id_personaje){
        personajeDAO.deleteById(id_personaje);
    }

    @PutMapping("/update")
    public void update(@RequestBody Personajes personajes){
        personajeDAO.save(personajes);
    }
    
}
