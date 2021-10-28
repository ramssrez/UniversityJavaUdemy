/* Insertar 5 valores a la tabla de usuario */
INSERT INTO usuario (nombre, apellido1, apellido2, fechanacimiento, correo, sexo) VALUES ('Jose', 'Martinez', 'Sanchez', '1969-12-01', 'jms@gmail.com', 'Masculino');
INSERT INTO usuario (nombre, apellido1, apellido2, fechanacimiento, correo, sexo) VALUES ('Maria', 'Lopez', 'Reyna', '1980-05-13', 'mlr@gmail.com', 'Femenino');
INSERT INTO usuario (nombre, apellido1, apellido2, fechanacimiento, correo, sexo) VALUES ('Enrique', 'Jimenez', 'Rodriguez', '1970-10-12', 'ejr@gmail.com', 'Masculino');
INSERT INTO usuario (nombre, apellido1, apellido2, fechanacimiento, correo, sexo) VALUES ('Elizabeth', 'Nuñez', 'Fernandez', '1985-01-25', 'enf@gmail.com', 'Femenino');
INSERT INTO usuario (nombre, apellido1, apellido2, fechanacimiento, correo, sexo) VALUES ('Raúl', 'Ramírez', 'Pérez', '1992-06-27', 'rrp@gmail.com', 'Masculino');

/* Insertar dos cajeros a la tabla cajero */
INSERT INTO cajero (nombre, apellido1, apellido2, turno) VALUES ('Lourdes', 'Sanchez', 'Padilla', 'Matutino');
INSERT INTO cajero (nombre, apellido1, apellido2, turno) VALUES ('Mario', 'Sandoval', 'Sandoval', 'Vespertino');

/*Insertarregistros a la tabla del servicio */
INSERT INTO servicio (fecha, origen, destino, hora, clase, corrida, costototal, asiento, numcomprobante, idcajero, idusuario) VALUES ('2021-06-26', 'Texcoco', 'CDMX', '06:30:00', 'Segunda', '1', '35.00', '48', '123456', '1', '1');
INSERT INTO servicio (fecha, origen, destino, hora, clase, corrida, costototal, asiento, numcomprobante, idcajero, idusuario) VALUES ('2021-06-27', 'Texcoco', 'CDMX', '10:00:00', 'Segunda', '3', '35.00', '25', '123457', '1', '3');
INSERT INTO servicio (fecha, origen, destino, hora, clase, corrida, costototal, asiento, numcomprobante, idcajero, idusuario) VALUES ('2021-06-28', 'Texcoco', 'CDMX', '12:00:00', 'Segunda', '5', '35.00', '01', '123458', '1', '5');
INSERT INTO servicio (fecha, origen, destino, hora, clase, corrida, costototal, asiento, numcomprobante, idcajero, idusuario) VALUES ('2021-06-29', 'CDMX', 'Texcoco', '18:00:00', 'Primera', '10', '50.00', '13', '123459', '2', '2');
INSERT INTO servicio (fecha, origen, destino, hora, clase, corrida, costototal, asiento, numcomprobante, idcajero, idusuario) VALUES ('2021-06-30', 'CDMX', 'Texcoco', '20:00:00', 'Primera', '12', '50.00', '11', '123460', '2', '4');