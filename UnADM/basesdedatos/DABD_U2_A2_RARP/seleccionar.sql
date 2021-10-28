/* 
Selecciona la lista de usuarios, incluyendo sólo nombre 
completo, correo y fecha de nacimiento en formato (dd/mm/aaaa).
 */
SELECT nombre, apellido1, apellido2, correo,  DATE_FORMAT( fechanacimiento,'%d-%m-%Y') FROM usuario;
SELECT nombre, apellido1, apellido2, correo,  DATE_FORMAT( fechanacimiento,'%d-%m-%Y') AS "Fecha Nacimiento" FROM usuario;

/* Selecciona el número de usuarios registrados agrupados por sexo. */
SELECT * FROM usuario ORDER BY sexo;

/* Muestra la lista Facturación de los usuarios que han realizado este servicio
 y que contenga los siguientes datos: id del usuario, nombre completo del usuario, fecha y autorización. */
 SELECT usuario.idusuario, nombre, apellido1, apellido2,fecha, autorizacion FROM usuario
 INNER JOIN facturacion WHERE usuario.idusuario = facturacion.idusuario;

/* Elimina los datos de usuario que pertenece a tu nombre. (utilizar subconsulta). */
 DELETE FROM usuario WHERE (idusuario = 6);
 SELECT * FROM usuario;


/*  Muestra los Usuarios que recibirán descuentos por los kilómetros acumulados.*/
 SELECT nombre, apellido1, apellido2, descuento, kmrecorridos  FROM usuario
 INNER JOIN kilometros WHERE usuario.idusuario = kilometros.idusuario;

 SELECT nombre, apellido1, apellido2, descuento AS "descuento %", kmrecorridos AS "Km recorridos"  FROM usuario
 INNER JOIN kilometros WHERE usuario.idusuario = kilometros.idusuario;

/* Selecciona al último usuario registrado en la base de datos. */


/* Actualiza la fecha de nacimiento de un usuario registrado a 03/06/1976. */
UPDATE usuario SET fechanacimiento = '1976-06-03' WHERE (idusuario = 3);


/* Selecciona los usuarios registrados con su edad (calcular a partir de la fecha de nacimiento almacenada). */
SELECT TIMESTAMPDIFF(YEAR,fechanacimiento,CURDATE()) AS edad
FROM clientes;

SELECT nombre, apellido1, apellido2, TIMESTAMPDIFF(YEAR,fechanacimiento,CURDATE()) AS edad
FROM usuario;
/* Selecciona los usuarios que tengan un descuento cuyo sexo sea femenino y sean mayores de 35 años y menores a 50 años. */


/* Ordena los usuarios de manera ascendente respecto de su Apellido1. */
SELECT * FROM usuario ORDER BY apellido1 asc;
SELECT * FROM usuario WHERE idusuario > 2 ORDER BY apellido1 asc;

/* Selecciona el nombre y apellido1 de los usuarios, así como el asiento, fecha,origen, destino, hora y clase del servicio. */
 SELECT nombre, apellido1, fecha, origen, destino, hora, clase FROM usuario
 INNER JOIN servicio WHERE usuario.idusuario = servicio.idusuario;
