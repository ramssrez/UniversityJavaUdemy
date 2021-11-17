USE es1921023412;

/* Creación del trigger */
CREATE TRIGGER bienvenida AFTER INSERT ON usuario FOR EACH ROW
INSERT INTO  servicio
(fecha, origen, destino, hora, clase, corrida, costototal, asiento, numcomprobante,idcajero,idusuario)
VALUES (NOW(), 'Bienvenida', 'Bienvenida','06:00:00','Bienvenida','85','1000','25','89','1',NEW.idusuario);

/* Verificar estado bitácora */
SHOW VARIABLES like '%eneral_log%';