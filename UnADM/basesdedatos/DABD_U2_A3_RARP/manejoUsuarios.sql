/*Creación de un nuevo usuario profesora  */
CREATE USER 'AnaKarenCamacho'@'localhost' IDENTIFIED BY 'passAKC';

/*Asignar privilegios */
GRANT ALL PRIVILEGES ON * . * TO 'AnaKarenCamacho'@'localhost';

/* Aseguramiento para refrecar todo los permisos */
FLUSH PRIVILEGES;


/* Creación de mi usuario */
CREATE USER 'RaulRamirez'@'localhost' IDENTIFIED BY 'passRR';

GRANT INSERT SELECT ON *.* to 'RaulRamirez'@'localhost':