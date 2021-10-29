CREATE DATABASE la_estancia;
USE la_estancia;
CREATE TABLE habitaciones(
    id_habitacion INT NOT NULL AUTO_INCREMENT,
    tipo_habitación VARCHAR(25) NOT NULL,
    no_habitacion INT NOT NULL,
    estatus VARCHAR(10) NOT NULL,
    costo FLOAT,
    PRIMARY KEY(id_habitacion) 
);

CREATE TABLE reservaciones(
    id_reservacion INT NOT NULL AUTO_INCREMENT,
    fecha_entrada DATE NOT NULL,
    fecha_salida DATE NOT NULL,
    dias VARCHAR(15) NOT NULL,
    id_habitacion INT NOT NULL,
    PRIMARY KEY(id_reservacion)
);




Tabla RESERVACIONES
id_reservacion
fecha_entrada
fecha_salida
dias (se calculará con las columnas de fecha_entrada y fecha_salida)
id_habitacion


Tabla HABITACIONES
id_habitacion
tipo_habitación (sencilla, doble, triple y cuádruple)
no_habitacion
estatus (ocupado, disponible)
costo (costo de la habitación por noche).