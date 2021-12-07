/* Particiones a realizar
 • En la tabla usuario un particionamiento por hash, con al menos 4 particiones.
• En la tabla cajero un particionamiento por key con al menos 2 particiones.
• En la tabla servicio un particionamiento por rango con al menos 3 particiones.
 */


/* Eliminación de llaves foraneas */
/* Eliminación para la tabla servio */
ALTER TABLE servicio DROP FOREIGN KEY fk_servicio_usuario;
ALTER TABLE servicio DROP FOREIGN KEY fk_servicio_vendedor;
SHOW CREATE TABLE servicio;

/* Eliminación para la tabla y llave primaria para kilometros */
ALTER TABLE kilometros  DROP PRIMARY KEY;
ALTER TABLE kilometros DROP FOREIGN KEY fk_millas_usuario, DROP FOREIGN KEY fk_millas_servicio;
SHOW CREATE TABLE kilometros;


/* Eliminación para la tabla facturas */
ALTER TABLE facturacion DROP FOREIGN KEY fk_facturacion_usuario,DROP FOREIGN KEY fk_facturacion_servicio;
SHOW CREATE TABLE facturacion;

ALTER TABLE usuario PARTITION BY HASH(idusuario) PARTITIONS 4;

ALTER TABLE cajero PARTITION BY KEY(idcajero) PARTITIONS 2;

ALTER TABLE servicio PARTITION BY RANGE(idservicio)
(
PARTITION uno VALUES less than(5) ,
PARTITION dos VALUES less than(10),
PARTITION tres VALUES less than(15)
);

/* Seleccion de usuairo por  */
SELECT * FROM servicio PARTITION(uno, dos, tres);
SELECT * FROM usuario PARTITION(p0);
SELECT * FROM usuario PARTITION(p1);
SELECT * FROM usuario PARTITION(p2);
SELECT * FROM usuario PARTITION(p3);


/* Creacion de las vistas como ejemplo*/
CREATE VIEW ejemplo AS
SELECT idusuario, nombre, apellido1 FROM usuario;

CREATE VIEW ejemplo AS
SELECT nombre, apellido1 FROM usuario;

CREATE VIEW usuario_factura AS
SELECT nombre, apellido1,apellido2, razonsocial, direccion, autorizacion, facturacion.fecha,costototal FROM usuario 
INNER JOIN facturacion INNER JOIN servicio WHERE usuario.idusuario = facturacion.idusuario AND facturacion.idservicio = servicio.idservicio;

CREATE VIEW servicios_solicitados AS
SELECT usuario.nombre, usuario.apellido1,usuario.apellido2, servicio.fecha, origen, destino, costototal,asiento, cajero.nombre AS "Nombre Cajero" FROM usuario 
INNER JOIN servicio INNER JOIN cajero WHERE usuario.idusuario = servicio.idusuario AND servicio.idcajero = cajero.idcajero;