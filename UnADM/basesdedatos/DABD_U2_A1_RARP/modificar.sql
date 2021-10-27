/* Modificar nombre de una tabla*/
ALTER TABLE vendedor RENAME TO cajero;
ALTER TABLE millas RENAME TO kilometros;

/*Cambio de nombre de columna y creación de nuevo campo */
ALTER TABLE usuario CHANGE COLUMN edad fechanacimiento DATE NOT NULL;
ALTER TABLE usuario ADD COLUMNS sexo CHAR(10) NOT NULL AFTER correo;

/* Verificar el estado de unas tablas */
CHECK TABLE usuario;
CHECK TABLE cajero;
CHECK TABLE facturacion;
CHECK TABLE kilometros;
CHECK TABLE servicio;

/* Reparación de tablas */
REPAIR TABLE usuario;
REPAIR TABLE cajero;
REPAIR TABLE facturacion;
REPAIR TABLE kilometros;
REPAIR TABLE servicio;

/* Descripción de las tablas */
SHOW COLUMNS FROM usuario;
SHOW COLUMNS FROM cajero;
SHOW COLUMNS FROM facturacion;
SHOW COLUMNS FROM kilometros;
SHOW COLUMNS FROM servicio;