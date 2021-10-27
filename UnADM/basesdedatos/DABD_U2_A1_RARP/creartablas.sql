/* Creacion y uso de la base de datos */
CREATE DATABASE es1921023412;
USE es1921023412;
/* Creción de la tabla usuario */
CREATE TABLE IF NOT EXISTS es1921023412.usuario (
  idusuario INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(20) NOT NULL,
  apellido1 VARCHAR(15) NOT NULL,
  apellido2 VARCHAR(15) NOT NULL,
  edad INT NOT NULL,
  correo VARCHAR(25) NOT NULL,
  PRIMARY KEY (idusuario))
ENGINE = InnoDB;

/* Creación de la tabla cajero */
CREATE TABLE IF NOT EXISTS es1921023412.vendedor (
  idcajero INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(20) NOT NULL,
  apellido1 VARCHAR(15) NOT NULL,
  apellido2 VARCHAR(15) NOT NULL,
  turno VARCHAR(15) NOT NULL,
  PRIMARY KEY (idcajero))
ENGINE = InnoDB;

/* Creación de la tabla Servicio */
CREATE TABLE IF NOT EXISTS es1921023412.servicio (
  idservicio INT NOT NULL AUTO_INCREMENT,
  fecha DATE NOT NULL,
  origen VARCHAR(20) NOT NULL,
  destino VARCHAR(45) NOT NULL,
  hora TIME NOT NULL,
  clase VARCHAR(45) NOT NULL,
  corrida VARCHAR(45) NOT NULL,
  costototal VARCHAR(45) NOT NULL,
  asiento INT NOT NULL,
  numcomprobante INT NOT NULL,
  vendedor VARCHAR(45) NOT NULL,
  idcajero INT NOT NULL,
  idusuario INT NOT NULL,
  PRIMARY KEY (idservicio),
  INDEX fk_servicio_vendedor_index (idcajero ASC) INVISIBLE,
  INDEX fk_servicio_usuario_index (idusuario ASC) INVISIBLE,
  CONSTRAINT fk_servicio_vendedor
    FOREIGN KEY (idcajero)
    REFERENCES es1921023412.vendedor (idcajero)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_servicio_usuario
    FOREIGN KEY (idusuario)
    REFERENCES es1921023412.Usuario (idusuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

/* Creación de la tabla facturación */
CREATE TABLE IF NOT EXISTS es1921023412.facturacion (
  idfaturacion INT NOT NULL AUTO_INCREMENT,
  razonsocial VARCHAR(20) NOT NULL,
  direccion VARCHAR(150) NOT NULL,
  autorizacion VARCHAR(45) NOT NULL,
  fecha DATE NOT NULL,
  idservicio INT NOT NULL,
  idusuario INT NOT NULL,
  PRIMARY KEY (idfaturacion),
  INDEX fk_facturacion_servicio_index (idservicio ASC) VISIBLE,
  INDEX fk_facturacion_usuario_index (idusuario ASC) VISIBLE,
  CONSTRAINT fk_facturacion_servicio
    FOREIGN KEY (idservicio)
    REFERENCES es1921023412.servicio (idservicio)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_facturacion_usuario
    FOREIGN KEY (idusuario)
    REFERENCES es1921023412.usuario (idusuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

/* Creación de la tabla millas*/
CREATE TABLE es1921023412.millas (
  idusuario INT NOT NULL,
  idservicio INT NOT NULL,
  kmrecorridos INT NOT NULL,
  descuento INT NOT NULL,
  INDEX fk_millas_servicio_index (idservicio ASC) VISIBLE,
  INDEX fk_millas_usuario_index (idusuario ASC) INVISIBLE,
  PRIMARY KEY (idusuario, idservicio),
  CONSTRAINT fk_millas_usuario
    FOREIGN KEY (idusuario)
    REFERENCES es1921023412.Usuario (idusuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_millas_servicio
    FOREIGN KEY (idservicio)
    REFERENCES es1921023412.servicio (idservicio)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;