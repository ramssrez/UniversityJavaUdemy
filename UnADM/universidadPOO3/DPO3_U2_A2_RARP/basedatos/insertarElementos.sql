/* Uso de la primera parte para ingresar los datos */
INSERT INTO habitaciones (tipo_habitacion, no_habitacion,estatus, costo) VALUES("sencilla","1" ,"disponible","150");


/* Insertar datos a las tabla auxiliares  tipo de habitacion*/
INSERT INTO tipo_habitaciones (tipo, costo) VALUES ("Sencilla", "500");
INSERT INTO tipo_habitaciones (tipo, costo) VALUES ("Doble", "1000");
INSERT INTO tipo_habitaciones (tipo, costo) VALUES ("Triple", "1500");
INSERT INTO tipo_habitaciones (tipo, costo) VALUES ("Cuádruple", "2000");

/* Insertar datos de la tabla auxiliar estatus*/
INSERT INTO estatus (estatus) VALUES ("Disponible");
INSERT INTO estatus (estatus) VALUES ("Ocupado");

/* Insertar datos a las habitaciones */
INSERT INTO habitaciones (no_habitacion, id_estatus, id_tipo_habitacion) VALUES("2","1","1");
INSERT INTO habitaciones (no_habitacion, id_estatus, id_tipo_habitacion) VALUES("4","1","1"); 
INSERT INTO habitaciones (no_habitacion, id_estatus, id_tipo_habitacion) VALUES("6","1","1"); 
INSERT INTO habitaciones (no_habitacion, id_estatus, id_tipo_habitacion) VALUES("8","1","2"); 
INSERT INTO habitaciones (no_habitacion, id_estatus, id_tipo_habitacion) VALUES("10","1","2"); 
INSERT INTO habitaciones (no_habitacion, id_estatus, id_tipo_habitacion) VALUES("12","1","3"); 
INSERT INTO habitaciones (no_habitacion, id_estatus, id_tipo_habitacion) VALUES("14","1","3"); 
INSERT INTO habitaciones (no_habitacion, id_estatus, id_tipo_habitacion) VALUES("16","1","4"); 
INSERT INTO habitaciones (no_habitacion, id_estatus, id_tipo_habitacion) VALUES("18","1","4");
INSERT INTO habitaciones (no_habitacion, id_estatus, id_tipo_habitacion) VALUES("20","1","4");   