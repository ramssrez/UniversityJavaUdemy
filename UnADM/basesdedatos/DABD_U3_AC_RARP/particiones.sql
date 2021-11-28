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

select table_name,partition_name,partition_description,table_rows from
information_schema.partitions where table_name =  servicio;