package com.disney.alkemy.rest;

import java.util.List;
import java.util.Optional;

import com.disney.alkemy.DAO.UsuarioDAO;
import com.disney.alkemy.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController 
@RequestMapping("/user")
public class UsuarioREST {

    @Autowired
    public UsuarioDAO usuarioDAO;

    @GetMapping("//user/login/{id_usuario}")
    public Optional<Usuario> findById(@PathVariable("id_usuario") Long id_usuario){
        return usuarioDAO.findById(id_usuario);
    }


    @GetMapping("/getAll")
    public List<Usuario> findAll(){
        return usuarioDAO.findAll();
    }

    @PostMapping("/signup")
      public Usuario post(@RequestBody Usuario usuario) {
          return usuarioDAO.save(usuario);
          
      }

     
    @DeleteMapping("/delete/{id_usuario}")
    public void deleteById(@PathVariable("id_usuario") Long id_usuario){
        usuarioDAO.deleteById(id_usuario);
    }

    @PutMapping("/update")
    public void update(@RequestBody Usuario usuario){
        usuarioDAO.save(usuario);
    }
}
