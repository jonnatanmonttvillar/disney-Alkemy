package com.disney.alkemy.model;

import javax.persistence.*;

@Entity
public class Personajes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_personaje;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_pelicula")
    private Peliculas peliculas;
    
    private String imagen;
    private String nombre;
    private Integer edad;
    private Float peso;
    private String historia;
    

    public Long getId_personaje() {
        return this.id_personaje;
    }

    public void setId_personaje(Long id_personaje) {
        this.id_personaje = id_personaje;
    }

    public Peliculas getPeliculas() {
        return this.peliculas;
    }

    public void setPeliculas(Peliculas peliculas) {
        this.peliculas = peliculas;
    }

    public String getImagen() {
        return this.imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return this.edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Float getPeso() {
        return this.peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public String getHistoria() {
        return this.historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }


}
