/* Creación del procedimiento para un nuevo usuario */
DELIMITER //
CREATE PROCEDURE nuevoUsuario(IN na VARCHAR(45), ape1 VARCHAR(45),
ape2 VARCHAR(45), fecha DATE, email VARCHAR(45), sexo CHAR(10))
BEGIN
INSERT INTO usuario(nombre, apellido1, apellido2, fechanacimiento, correo, sexo) VALUES (na,ape1,ape2,fecha,email,sexo);
END//
DELIMITER ;

/* Insertar datos del usuario */
CALL nuevoUsuario('Jose', 'Martinez', 'Martinez', '1989-10-01', 'jmm@gmail.com', 'Masculino');
CALL nuevoUsuario('Fiona', 'Sanchez', 'Sanchez', '1990-08-02', 'fss@gmail.com', 'Femenino');
CALL nuevoUsuario('Jesus', 'Garcia', 'Garcia', '1991-02-28', 'jgg@gmail.com', 'Masculino');
CALL nuevoUsuario('Monica', 'Hernandez', 'Hernandez', '1992-03-29', 'mhh@gmail.com', 'Femenino');
CALL nuevoUsuario('Miguel', 'Cordova', 'Cordova', '1992-04-14', 'jcc@gmail.com', 'Masculino');
CALL nuevoUsuario('Noemi', 'Prado', 'Prado', '1994-08-15', 'npp@gmail.com', 'Femenino');

/* Muestra del procedimiento creado */
SHOW PROCEDURE STATUS LIKE 'nuevoUsuario';

/* Creación del procedimiento de salida con las ventas totales */
DELIMITER // 
CREATE PROCEDURE ventas_totales_cajero(IN id_caj INT, OUT numero INT)
BEGIN
SELECT SUM(costototal) INTO numero FROM servicio INNER JOIN cajero ON 
cajero.idcajero=servicio.idcajero WHERE cajero.idcajero=id_caj;
END//
DELIMITER ;
CALL ventas_totales_cajero(1,@numero);
SELECT @numero AS "Total Ventas";

SHOW PROCEDURE STATUS LIKE 'ventas_totales_cajero';

/* Sentencia para la suma */
SELECT SUM(costototal) from servicio inner join cajero on cajero.idcajero=servicio.idcajero where cajero.idcajero=2;

SELECT nombre, SUM(costototal) AS suma from servicio inner join cajero on cajero.idcajero=servicio.idcajero where cajero.idcajero=2;

SELECT nombre, SUM(costototal) AS suma from servicio inner join cajero on cajero.idcajero=servicio.idcajero where cajero.idcajero=1;

SELECT concat(nombre, " ", apellido1) AS Cajero, SUM(costototal) AS suma from servicio inner join cajero on cajero.idcajero=servicio.idcajero where cajero.idcajero=1;

/* Retorno de dos valores */
DELIMITER // 
CREATE PROCEDURE ventas_totales_cajero(IN idCaj INT, OUT nom varchar(60), numero INT)
BEGIN
SELECT CONCAT(nombre, " ", apellido1, " ",apellido2), SUM(costototal) INTO nom, numero from servicio inner join cajero on cajero.idcajero=servicio.idcajero where cajero.idcajero=idCaj;
END//
DELIMITER ;

CALL ventas_totales_cajero(1,@nombre,@numero);
SELECT @nombre AS "Nombre cajero", @numero AS "Ventas Totales";

/* Retorno de dos valores */
DELIMITER // 
CREATE PROCEDURE ventas_totales_cajero(IN idcaj INT, OUT nom VARCHAR(45), numero VARCHAR(10))
BEGIN
SELECT CONCAT(nombre, " ", apellido1), SUM(servicio.costototal) INTO nom, numero FROM servicio INNER JOIN cajero ON cajero.idcajero=servicio.idcajero WHERE cajero.idcajero=idcaj;
END//
DELIMITER ;

CALL ventas_totales_cajero(1,@nombre,@numero);
SELECT @nombre AS "Nombre cajero", @numero AS "Ventas Totales";

/* Insertar datos de cajeros */
INSERT INTO cajero (nombre, apellido1, apellido2, turno) VALUES ('Sandra', 'Ortiz', 'Ortiz', 'Vespertino');
INSERT INTO cajero (nombre, apellido1, apellido2, turno) VALUES ('Rogelio', 'Luna', 'Luna', 'Matutino');
INSERT INTO cajero (nombre, apellido1, apellido2, turno) VALUES ('Elena', 'Rodriguez', 'Rodriguez', 'Vespertino');

UPDATE servicio SET idcajero = '2' WHERE (idservicio = '6');
UPDATE servicio SET idcajero = '3' WHERE (idservicio = '7');
UPDATE servicio SET idcajero = '3' WHERE (idservicio = '8');
UPDATE servicio SET idcajero = '4' WHERE (idservicio = '9');
UPDATE servicio SET idcajero = '4' WHERE (idservicio = '10');
UPDATE servicio SET idcajero = '5' WHERE (idservicio = '11');
UPDATE servicio SET idcajero = '5' WHERE (idservicio = '12');
UPDATE servicio SET idcajero = '5' WHERE (idservicio = '13');

/* Creación del procedimiento de INOUT */
DELIMITER // 
CREATE PROCEDURE mostrarCorreo(INOUT nom VARCHAR(45), OUT email VARCHAR(45))
BEGIN
SELECT correo INTO email FROM usuario WHERE nombre = nom;
END//
DELIMITER ;

SHOW PROCEDURE STATUS LIKE 'mostrarCorreo';

SET @nombre = "Miguel";
CALL mostrarCorreo(@nombre,@correo);
SELECT @nombre as "Nombre", @correo AS "Correo";

SELECT email FROM usuario WHERE nombre = "Jose";