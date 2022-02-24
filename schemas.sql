--ALTER TABLE personajes DROP CONSTRAINT personaje_pelicula_fk;
--ALTER TABLE peliculas DROP CONSTRAINT genero_pelicula_fk;

--DROP TABLE PERSONAJES;
--DROP TABLE PELICULAS; 
--DROP TABLE GENERO;
-- -----------------------------------------------------
-- Table PERSONAJES
-- -----------------------------------------------------
CREATE TABLE  PERSONAJES (
  id_personaje SERIAL PRIMARY KEY,
  id_pelicula INT NOT NULL,
  imagen VARCHAR(500) NULL,
  nombre VARCHAR(45) NULL,
  edad INT NULL,
  peso FLOAT(4) NULL,
  historia VARCHAR(500) NULL
  );
-- -----------------------------------------------------
-- Table PELICULAS
-- -----------------------------------------------------
CREATE TABLE  PELICULAS (
  id_pelicula SERIAL PRIMARY KEY,
  id_genero INT NOT NULL,
  imagen VARCHAR(500) NULL,
  titulo VARCHAR(300) NULL,
  fecha_creacion VARCHAR(20) NULL,
  calificacion INT NULL
);

-- -----------------------------------------------------
-- Table GÉNERO
-- -----------------------------------------------------
CREATE TABLE  GENERO (
  id_genero SERIAL PRIMARY KEY,
  nombre VARCHAR(250) NULL,
  imagen VARCHAR(500) NULL
  );

-- ALTERAMOS LA TABLA PARA AGREGAR FOREING KEY
ALTER TABLE personajes
ADD CONSTRAINT personaje_pelicula_fk
FOREIGN KEY (id_pelicula)
REFERENCES peliculas(id_pelicula);

-- ALTERAMOS LA TABLA PARA AGREGAR FOREING KEY
ALTER TABLE peliculas
ADD CONSTRAINT genero_pelicula_fk
FOREIGN KEY (id_genero) 
REFERENCES genero(id_genero);