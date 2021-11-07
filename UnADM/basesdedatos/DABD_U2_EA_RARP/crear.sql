/* Crea y usar base de datos*/
CREATE DATABASE lomitos ;
USE lomitos ;


CREATE TABLE lomitos.estado (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NULL,
  PRIMARY KEY (id)
);


-- -----------------------------------------------------
-- Table lomitos.direcciones
-- -----------------------------------------------------
DROP TABLE IF EXISTS lomitos.direcciones ;

CREATE TABLE IF NOT EXISTS lomitos.direcciones (
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
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table lomitos.adoptantes
-- -----------------------------------------------------
DROP TABLE IF EXISTS lomitos.adoptantes ;

CREATE TABLE IF NOT EXISTS lomitos.adoptantes (
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
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table lomitos.raza
-- -----------------------------------------------------
DROP TABLE IF EXISTS lomitos.raza ;

CREATE TABLE IF NOT EXISTS lomitos.raza (
  id INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(45) NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table lomitos.sexo
-- -----------------------------------------------------
DROP TABLE IF EXISTS lomitos.sexo ;

CREATE TABLE IF NOT EXISTS lomitos.sexo (
  id INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(45) NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table lomitos.size
-- -----------------------------------------------------
DROP TABLE IF EXISTS lomitos.size ;

CREATE TABLE IF NOT EXISTS lomitos.size (
  id INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(45) NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table lomitos.color
-- -----------------------------------------------------
DROP TABLE IF EXISTS lomitos.color ;

CREATE TABLE IF NOT EXISTS lomitos.color (
  id INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(45) NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table lomitos.refugios
-- -----------------------------------------------------
DROP TABLE IF EXISTS lomitos.refugios ;

CREATE TABLE IF NOT EXISTS lomitos.refugios (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NULL,
  id_direccion INT NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_refugios_direccion_idx (id_direccion ASC) VISIBLE,
  CONSTRAINT fk_refugios_direccion
    FOREIGN KEY (id_direccion)
    REFERENCES lomitos.direcciones (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table lomitos.perros
-- -----------------------------------------------------
DROP TABLE IF EXISTS lomitos.perros ;

CREATE TABLE IF NOT EXISTS lomitos.perros (
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
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table lomitos.solicitudes
-- -----------------------------------------------------
DROP TABLE IF EXISTS lomitos.solicitudes ;

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
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
