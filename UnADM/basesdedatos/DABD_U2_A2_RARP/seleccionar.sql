/* 
Selecciona la lista de usuarios, incluyendo sólo nombre 
completo, correo y fecha de nacimiento en formato (dd/mm/aaaa).
 */
SELECT nombre, apellido1, apellido2, correo,  DATE_FORMAT( fechanacimiento,'%d-%m-%Y') FROM usuario;
SELECT nombre, apellido1, apellido2, correo,  DATE_FORMAT( fechanacimiento,'%d-%m-%Y') AS "Fecha Nacimiento" FROM usuario;

/* Selecciona el número de usuarios registrados agrupados por sexo. */
SELECT * FROM usuario ORDER BY sexo;

/* Muestra la lista Facturación de los usuarios que han realizado este servicio
 y que contenga los siguientes 
 datos: id del usuario, nombre completo del usuario, fecha y autorización. */
 SELECT usuario.idusuario, nombre, apellido1, apellido2,fecha, autorizacion FROM usuario
 INNER JOIN facturacion WHERE usuario.idusuario = facturacion.idusuario;