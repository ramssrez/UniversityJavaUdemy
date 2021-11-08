/* Cambio de nombre de la llave foranea */
ALTER TABLE lomitos.direcciones 
DROP FOREIGN KEY fk_direccion_estado;

ALTER TABLE lomitos.direcciones 
CHANGE COLUMN id_estado idEstado INT NOT NULL ;

ALTER TABLE lomitos.direcciones 
ADD CONSTRAINT fk_direccion_estado
  FOREIGN KEY (idEstado)
  REFERENCES lomitos.estado (id);

  /* Eliminación de relaciones */
ALTER TABLE lomitos.perros 
DROP FOREIGN KEY fk_perros_sexo;

ALTER TABLE lomitos.perros 
DROP INDEX fk_perros_sexo_idx ;

/* Creación del un rol */
 CREATE ROLE 'analista';
 GRANT SELECT ON lomitos.* TO analista; 

 GRANT analista TO 'RaulRamirez'@'localhost';

 INSERT INTO lomitos.estado (nombre) VALUES ('Aguascalientes');
 DELETE FROM lomitos.estado WHERE (id = '5');