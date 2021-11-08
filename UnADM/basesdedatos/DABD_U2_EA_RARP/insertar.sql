/* Insertar en la tabla colores */
INSERT INTO lomitos.color (descripcion) VALUES ('Negro');
INSERT INTO lomitos.color (descripcion) VALUES ('Blanco');
INSERT INTO lomitos.color (descripcion) VALUES ('Café');
INSERT INTO lomitos.color (descripcion) VALUES ('Golondrino');
INSERT INTO lomitos.color (descripcion) VALUES ('Gris');
INSERT INTO lomitos.color (descripcion) VALUES ('Beige');

/*  Insertar datos en la la tabla tamaños*/
INSERT INTO lomitos.size (descripcion) VALUES ('Chico');
INSERT INTO lomitos.size (descripcion) VALUES ('Mediano');
INSERT INTO lomitos.size (descripcion) VALUES ('Grande');
INSERT INTO lomitos.size (descripcion) VALUES ('Extra Grande');

/* Insertar datos en la tabla sexo */
INSERT INTO lomitos.sexo (descripcion) VALUES ('Macho');
INSERT INTO lomitos.sexo (descripcion) VALUES ('Hembra');

/* Insertar datos en la tabla estado */
INSERT INTO lomitos.estado (nombre) VALUES ('CDMX');
INSERT INTO lomitos.estado (nombre) VALUES ('Estado de México');
INSERT INTO lomitos.estado (nombre) VALUES ('Puebla');
INSERT INTO lomitos.estado (nombre) VALUES ('Morelos');
INSERT INTO lomitos.estado (nombre) VALUES ('Queretaro');

/* Insertar datos en la tabla raza */
INSERT INTO lomitos.raza (descripcion) VALUES ('Pitbull');
INSERT INTO lomitos.raza (descripcion) VALUES ('Labrador');
INSERT INTO lomitos.raza (descripcion) VALUES ('Chihuahua');
INSERT INTO lomitos.raza (descripcion) VALUES ('Hunteraway');
INSERT INTO lomitos.raza (descripcion) VALUES ('Mixto');

/* insertar datos en la tabla direcciones */
INSERT INTO lomitos.direcciones (calle, colonia, municipio, numero, id_estado) VALUES ('Reforma', 'Centro','Cuautemoc', '222',   '1');
INSERT INTO lomitos.direcciones (calle, colonia, municipio, numero, id_estado) VALUES ('Allende', 'La Conchita', 'Texcoco', '205', '2');
INSERT INTO lomitos.direcciones (calle, colonia, municipio, numero, id_estado) VALUES ('Revolución', 'Sanctorum', 'Cuautlacingo', '12', '3');
INSERT INTO lomitos.direcciones (calle, colonia, municipio, numero, id_estado) VALUES ('Lazaron Cardenas', 'Buenos Aires', 'Benito Juarez', '205', '1');
INSERT INTO lomitos.direcciones (calle, colonia, municipio, numero, id_estado) VALUES ('San Agustin', 'Centro', 'Texcoco', '27', '2');
INSERT INTO lomitos.direcciones (calle, colonia, municipio, numero, id_estado) VALUES ('Poniente 15', 'Centro', 'Puebla', '15', '3');

/* Insertar datos en la tabla adoptantes */
INSERT INTO lomitos.adoptantes (nombre, apellido_paterno, apellido_materno, fecha_nacimieno, correo, id_direccion) VALUES ('Pedro', 'Juarez', 'Sanchez', '1996-05-06', 'pjs@gmail.conm', '4');
INSERT INTO lomitos.adoptantes (nombre, apellido_paterno, apellido_materno, fecha_nacimieno, correo, id_direccion) VALUES ('Ernesto', 'Labastida', 'Figueroa', '1990-01-30', 'elf@gmail.com', '5');
INSERT INTO lomitos.adoptantes (nombre, apellido_paterno, apellido_materno, fecha_nacimieno, correo, id_direccion) VALUES ('Frida', 'Rodriguez', 'Martinez', '1980-06-28', 'frm@gmail.com', '6');

/* Insertar datos en la tabla refugios */
INSERT INTO lomitos.refugios (nombre, id_direccion) VALUES ('La esperanza CDMX', '1');
INSERT INTO lomitos.refugios (nombre, id_direccion) VALUES ('La esperanza  EDOMEX', '2');
INSERT INTO lomitos.refugios (nombre, id_direccion) VALUES ('La esperanza Puebla', '3');

/* Insertar datos en la tabla perros */
INSERT INTO lomitos.perros (nombre, id_raza, id_sexo, id_size, id_color, id_adoptante, id_refugio) VALUES ('Kira', '5', '2', '2', '4', '1', '1');
INSERT INTO lomitos.perros (nombre, id_raza, id_sexo, id_size, id_color, id_adoptante, id_refugio) VALUES ('Morena', '3', '2', '1', '1', '2', '2');
INSERT INTO lomitos.perros (nombre, id_raza, id_sexo, id_size, id_color, id_adoptante, id_refugio) VALUES ('Sam', '2', '1', '3', '6', '3', '3');

/* Insertar datos en la tabla solicitudes */
INSERT INTO lomitos.solicitudes (fecha_solicitud, id_refugio, id_adoptante) VALUES ('2021-11-02', '1', '1');
INSERT INTO lomitos.solicitudes (fecha_solicitud, id_refugio, id_adoptante) VALUES ('2021-11-03', '2', '2');
INSERT INTO lomitos.solicitudes (fecha_solicitud, id_refugio, id_adoptante) VALUES ('2021-11-04', '3', '3');


ALTER TABLE `lomitos`.`direcciones` 
DROP FOREIGN KEY `fk_direccion_estado`;
ALTER TABLE `lomitos`.`direcciones` 
DROP COLUMN `id_estado`,
DROP INDEX `fk_direccion_estado_idx` ;
;
