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
;
