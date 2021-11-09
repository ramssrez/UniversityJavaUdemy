CREATE DATABASE BD_EA;
USE bd_ea;
CREATE TABLE IF NOT EXISTS empleados (
id_comision int(11) NOT NULL AUTO_INCREMENT,
fecha date,
nombre_trabajador varchar(50),
nombre_cliente varchar(50),
tiempo_trabajado int,
comision_obtenida int,
descuentos_realizados int,
sueldototal int,
PRIMARY KEY (id_comision)
);
