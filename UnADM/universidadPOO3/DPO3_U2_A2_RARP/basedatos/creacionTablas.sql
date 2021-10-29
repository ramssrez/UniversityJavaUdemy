/* Creación de la base de datos */
CREATE DATABASE la_estancia;
/* Uso de las tablas */
USE la_estancia;

/* Creación de la tabla tipo_habitaciones */
CREATE TABLE la_estancia.tipo_habitaciones (
  id_tipo_habitacion INT NOT NULL AUTO_INCREMENT,
  tipo VARCHAR(15) NOT NULL,
  costo INT NOT NULL,
  PRIMARY KEY (id_tipo_habitacion)
);

/* Creación de la tabla de status */
CREATE TABLE la_estancia.estatus (
  id_estatus INT NOT NULL AUTO_INCREMENT,
  estatus VARCHAR(15) NOT NULL,
  PRIMARY KEY (id_estatus)
);

/*Creación de la tabla habitaciones*/
CREATE TABLE  la_estancia.habitaciones (
  id_habitacion INT NOT NULL AUTO_INCREMENT,
  no_habitacion INT NOT NULL,
  id_tipo_habitacion INT NOT NULL,
  id_estatus INT NOT NULL,
  PRIMARY KEY (id_habitacion),
  INDEX fk_habitaciones_tipo_habitaciones_idx (id_tipo_habitacion ASC) VISIBLE,
  INDEX fk_habitaciones_estatus_idx (id_estatus ASC) VISIBLE,
  CONSTRAINT fk_habitaciones_tipo_habitaciones
    FOREIGN KEY (id_tipo_habitacion)
    REFERENCES la_estancia.tipo_habitaciones (id_tipo_habitacion)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_habitaciones_estatus
    FOREIGN KEY (id_estatus)
    REFERENCES la_estancia.estatus (id_estatus)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

/* Creación de la tabla reservaciones*/
CREATE TABLE reservaciones(
    id_reservacion INT NOT NULL AUTO_INCREMENT,
    fecha_entrada DATE NOT NULL,
    fecha_salida DATE NOT NULL,
    id_habitacion INT NOT NULL,
    PRIMARY KEY(id_reservacion),
    INDEX fk_reservacion_habitacion_idx (id_habitacion ASC) VISIBLE,
    CONSTRAINT fk_reservacion_habitacion
    FOREIGN KEY(id_habitacion)
    REFERENCES la_estancia.habitaciones(id_habitacion)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

/* Muestra de la tablas creadas */
SHOW TABLES;




