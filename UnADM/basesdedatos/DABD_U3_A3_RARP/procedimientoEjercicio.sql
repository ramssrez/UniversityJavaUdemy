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

