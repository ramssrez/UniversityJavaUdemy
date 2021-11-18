/* Creación de la base de datos y tabla */
CREATE DATABASE hospital;
USE hospital;

CREATE TABLE paciente(
id INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR (20) NOT NULL,
apellido VARCHAR (20) NOT NULL,
PRIMARY KEY (id)
);

/* Insertar datos dentro de la tabla */
INSERT INTO paciente (nombre, apellido) values ('Rosa', 'Chávez') ,
('Juan', 'Perez'), ('Manuel', 'Rivera'), ('Rogelio', 'Chávez'),
('Luisa', 'Mares');

/* Cambio del delimiter con // */
Delimiter //

/* Creación del procedimiento para un nuevo paciente */
CREATE PROCEDURE nuevoPaciente(IN n VARCHAR(20), ap VARCHAR(20))
BEGIN
Insert into paciente (nombre, apellido) values (n, ap);
END//
Delimiter ;

/* Llamado a un nuevo paciente */
CALL nuevoPaciente('Ricardo', 'Rivera');