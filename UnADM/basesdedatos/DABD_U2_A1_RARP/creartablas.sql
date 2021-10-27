/* Creacion y uso de la base de datos */
CREATE DATABASE es1921023412;
USE es1921023412;

/* Creación de la tabla Servicio */
CREATE TABLE IF NOT EXISTS es1921023412.servicio (
  idservicio INT NOT NULL AUTO_INCREMENT,
  fecha DATE NOT NULL,
  origen VARCHAR(20) NOT NULL,
  destino VARCHAR(45) NOT NULL,
  hora TIME NOT NULL,
  clase VARCHAR(45) NOT NULL,
  corrida VARCHAR(45) NOT NULL,
  costototal VARCHAR(45) NOT NULL,
  asiento INT NOT NULL,
  numcomprobante INT NOT NULL,
  vendedor VARCHAR(45) NOT NULL,
  idcajero INT NOT NULL,
  idusuario INT NOT NULL,
  PRIMARY KEY (idservicio),
  INDEX fk_servicio_vendedor_index (idcajero ASC) INVISIBLE,
  INDEX fk_servicio_usuario_index (idusuario ASC) INVISIBLE,
  CONSTRAINT fk_servicio_vendedor
    FOREIGN KEY (idcajero)
    REFERENCES es1921023412.vendedor (idcajero)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_servicio_usuario
    FOREIGN KEY (idusuario)
    REFERENCES es1921023412.Usuario (idusuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


