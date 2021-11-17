USE es1921023412;

/* Creación del trigger */
CREATE TRIGGER bienvenida AFTER INSERT ON usuario FOR EACH ROW
INSERT INTO  servicio
(fecha, origen, destino, hora, clase, corrida, costototal, asiento, numcomprobante,idcajero,idusuario)
VALUES (NOW(), 'Bienvenida', 'Bienvenida','06:00:00','Bienvenida','85','1000','25','89','1',NEW.idusuario);

/* Verificar estado bitácora */
SHOW VARIABLES like '%eneral_log%';

/* Activar la bitácora general */
SET GLOBAL general_log=1;

/* Insertando datos */
INSERT INTO usuario (nombre, apellido1, apellido2, fechanacimiento, correo, sexo) VALUES ('Carlos', 'León', 'Martinez', '1985-07-24', 'clm@gmail.com', 'Masculino');
INSERT INTO usuario (nombre, apellido1, apellido2, fechanacimiento, correo, sexo) VALUES ('Isamar', 'Baldera', 'Pérez', '1992-09-02', 'ibp@gmail.com', 'Femenino');

SELECT * FROM usuario;

/* Describir la bitácora */
DESCRIBE mysql.general_log;