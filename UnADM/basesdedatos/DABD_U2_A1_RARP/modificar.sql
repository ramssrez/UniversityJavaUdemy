/* Modificar nombre de una tabla*/
ALTER TABLE vendedor RENAME TO cajero;
ALTER TABLE millas RENAME TO kilometros;

/*Cambio de nombre de columna y creación de nuevo campo */
ALTER TABLE usuario CHANGE COLUMN edad fechanacimiento DATE NOT NULL;
ALTER TABLE usuario ADD COLUMNS sexo CHAR(10) NOT NULL AFTER correo;