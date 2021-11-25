/* Creación de la base de datos */
CREATE DATABASE la_estancia;
/* Uso de las tablas */
USE la_estancia;

/*Creación de la tabla habitaciones*/
CREATE TABLE habitaciones(
    id_habitacion INT NOT NULL AUTO_INCREMENT,
    tipo_habitación VARCHAR(25) NOT NULL,
    no_habitacion INT NOT NULL,
    estatus VARCHAR(10) NOT NULL,
    costo FLOAT NOT NULL,
    PRIMARY KEY(id_habitacion) 
);

/* Creación de la tabla reservaciones*/
CREATE TABLE reservaciones(
    id_reservacion INT NOT NULL AUTO_INCREMENT,
    fecha_entrada DATE NOT NULL,
    fecha_salida DATE NOT NULL,
    dias VARCHAR(15) NOT NULL,
    id_habitacion INT NOT NULL,
    PRIMARY KEY(id_reservacion)
    PRIMARY KEY(id_reservacion),
    INDEX fk_reservacion_habitacion_idx (id_habitacion ASC) VISIBLE,
    CONSTRAINT fk_reservacion_habitacion
    FOREIGN KEY(id_habitacion)
    REFERENCES la_estancia.habitaciones(id_habitacion)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);
