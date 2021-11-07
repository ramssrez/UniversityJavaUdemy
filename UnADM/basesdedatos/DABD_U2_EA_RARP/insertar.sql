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
INSERT INTO lomitos.direcciones (calle, colonia, municipio, numero, id_estado) VALUES ('Revolución', 'Sanctorum', 'Cuautlacingo', '12', '3');
INSERT INTO lomitos.direcciones (calle, colonia, municipio, numero, id_estado) VALUES ('Reforma', 'Centro', '222', 'Cuautemoc',  '1');
INSERT INTO lomitos.direcciones (calle, colonia, municipio, numero, id_estado) VALUES ('Allende', 'La Conchita', 'Texcoco', '205', '2');
INSERT INTO lomitos.direcciones (calle, colonia, municipio, numero, id_estado) VALUES ('San Agustin', 'Centro', 'Texcoco', '27', '2');
INSERT INTO lomitos.direcciones (calle, colonia, municipio, numero, id_estado) VALUES ('Lazaron Cardenas', 'Buenos Aires', 'Benito Juarez', '205', '1');
INSERT INTO lomitos.direcciones (calle, colonia, municipio, numero, id_estado) VALUES ('Poniente 15', 'Centro', 'Puebla', '15', '3');

