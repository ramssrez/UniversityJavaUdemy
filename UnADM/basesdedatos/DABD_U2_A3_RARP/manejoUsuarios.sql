/*Creación de un nuevo usuario profesora  */
CREATE USER 'AnaKarenCamacho'@'localhost' IDENTIFIED BY 'passAKC';

/*Asignar privilegios */
GRANT ALL PRIVILEGES ON * . * TO 'AnaKarenCamacho'@'localhost';

/* Aseguramiento para refrecar todo los permisos */
FLUSH PRIVILEGES;


/* Creación de mi usuario */
CREATE USER 'RaulRamirez'@'localhost' IDENTIFIED BY 'passRR';

/* Eliminación del usuario creado */
DROP USER 'RaulRamirez'@'localhost' IDENTIFIED BY 'passRR';

/* Asignación de permisos a la base de datos */
GRANT INSERT, SELECT ON es1921023412.* to 'RaulRamirez'@'localhost';

/* Muestra el usuario  en donde nos ubicamos */
SELECT CURRENT_USER();

/* Muestra los permisos del usuario */
SHOW GRANTS;

/* Modificacion de la tabla usuario */
UPDATE es1921023412.usuario SET fechanacimiento = '1970-12-01' WHERE (idusuario = '1');


 SELECT nombre, apellido1, apellido2,fechanacimiento,razonsocial, direccion,fecha, autorizacion FROM usuario
 INNER JOIN facturacion WHERE usuario.idusuario = facturacion.idusuario;