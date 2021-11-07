/* Crea y usar base de datos*/
CREATE DATABASE lomitos ;
USE lomitos ;

/* Tabla de estado */
CREATE TABLE lomitos.estado (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NULL,
  PRIMARY KEY (id)
);

/* Tabla de raza */
CREATE TABLE lomitos.raza (
  id INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(45) NULL,
  PRIMARY KEY (id)
);

/* Tabla de sexo */
CREATE TABLE lomitos.sexo (
  id INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(45) NULL,
  PRIMARY KEY (id)
);

/* Tabla de tamaño */
CREATE TABLE lomitos.size (
  id INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(45) NULL,
  PRIMARY KEY (id)
);

/* Tabla de color */
CREATE TABLE lomitos.color (
  id INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(45) NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;

/* Tabla direcciones */
CREATE TABLE lomitos.direcciones (
  id INT NOT NULL AUTO_INCREMENT,
  calle VARCHAR(45) NULL,
  colonia VARCHAR(45) NULL,
  numero INT NULL,
  id_estado INT NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_direccion_estado_idx (id_estado ASC) VISIBLE,
  CONSTRAINT fk_direccion_estado
    FOREIGN KEY (id_estado)
    REFERENCES lomitos.estado (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

/* Tabla adoptantes */
CREATE TABLE lomitos.adoptantes (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NULL,
  apellido_paterno VARCHAR(45) NULL,
  apellido_materno VARCHAR(45) NULL,
  fecha_nacimieno DATE NULL,
  correo VARCHAR(45) NULL,
  id_direccion INT NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_adoptantes_direccion_idx (id_direccion ASC) VISIBLE,
  CONSTRAINT fk_adoptantes_direccion
    FOREIGN KEY (id_direccion)
    REFERENCES lomitos.direcciones (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

/* Tabla refugios */
CREATE TABLE lomitos.refugios (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NULL,
  id_direccion INT NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_refugios_direccion_idx (id_direccion ASC) VISIBLE,
  CONSTRAINT fk_refugios_direccion
    FOREIGN KEY (id_direccion)
    REFERENCES lomitos.direcciones (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

/* Tabla perros */
CREATE TABLE lomitos.perros (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NULL,
  id_raza INT NOT NULL,
  id_sexo INT NOT NULL,
  id_size INT NOT NULL,
  id_color INT NOT NULL,
  id_adoptante INT NOT NULL,
  id_refugio INT NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_perros_raza_idx (id_raza ASC) VISIBLE,
  INDEX fk_perros_sexo_idx (id_sexo ASC) VISIBLE,
  INDEX fk_perros_tamaño_idx (id_size ASC) VISIBLE,
  INDEX fk_perros_color_idx (id_color ASC) VISIBLE,
  INDEX fk_perros_adoptantes_idx (id_adoptante ASC) VISIBLE,
  INDEX fk_perros_refugios_idx (id_refugio ASC) VISIBLE,
  CONSTRAINT fk_perros_raza
    FOREIGN KEY (id_raza)
    REFERENCES lomitos.raza (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_perros_sexo
    FOREIGN KEY (id_sexo)
    REFERENCES lomitos.sexo (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_perros_tamaño
    FOREIGN KEY (id_size)
    REFERENCES lomitos.size (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_perros_color
    FOREIGN KEY (id_color)
    REFERENCES lomitos.color (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_perros_adoptantes
    FOREIGN KEY (id_adoptante)
    REFERENCES lomitos.adoptantes (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_perros_refugios
    FOREIGN KEY (id_refugio)
    REFERENCES lomitos.refugios (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

/* Tabla solicitudes */
CREATE TABLE IF NOT EXISTS lomitos.solicitudes (
  id INT NOT NULL AUTO_INCREMENT,
  fecha_solicitud VARCHAR(45) NULL,
  id_refugio INT NOT NULL,
  id_adoptante INT NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_solicitudes_refugios_idx (id_refugio ASC) VISIBLE,
  INDEX fk_solicitudes_adoptantes_idx (id_adoptante ASC) VISIBLE,
  CONSTRAINT fk_solicitudes_refugios
    FOREIGN KEY (id_refugio)
    REFERENCES lomitos.refugios (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_solicitudes_adoptantes
    FOREIGN KEY (id_adoptante)
    REFERENCES lomitos.adoptantes (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);