/* Particiones a realizar
 • En la tabla usuario un particionamiento por hash, con al menos 4 particiones.
• En la tabla cajero un particionamiento por key con al menos 2 particiones.
• En la tabla servicio un particionamiento por rango con al menos 3 particiones.
 */

ALTER TABLE usuario PARTITION BY HASH(idusuario) PARTITIONS 4;