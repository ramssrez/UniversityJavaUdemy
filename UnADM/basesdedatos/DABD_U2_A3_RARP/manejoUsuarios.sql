/*Creación de un nuevo usuario profesora  */
CREATE USER 'AnaKarenCamacho'@'localhost' IDENTIFIED BY 'passAKC';

/*Asignar privilegios */
GRANT ALL PRIVILEGES ON * . * TO 'AnaKarenCamacho'@'localhost';

/* Aseguramiento para refrecar todo los permisos */
FLUSH PRIVILEGES;


/* Creación de mi usuario */
CREATE USER 'RaulRamirez'@'localhost' IDENTIFIED BY 'passRR';

/* Eliminación del usuario creado */
DROP USER 'RaulRamirez'@'localhost' IDENTIFIED BY 'passRR';

/* Asignación de permisos a la base de datos */
GRANT INSERT, SELECT ON es1921023412.* to 'RaulRamirez'@'localhost';