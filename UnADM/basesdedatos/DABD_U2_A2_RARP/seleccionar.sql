/* 
Selecciona la lista de usuarios, incluyendo sólo nombre 
completo, correo y fecha de nacimiento en formato (dd/mm/aaaa).
 */
SELECT nombre, apellido1, apellido2, correo,  DATE_FORMAT( fechanacimiento,'%d-%m-%Y') FROM usuario;
SELECT nombre, apellido1, apellido2, correo,  DATE_FORMAT( fechanacimiento,'%d-%m-%Y') AS "Fecha Nacimiento" FROM usuario;