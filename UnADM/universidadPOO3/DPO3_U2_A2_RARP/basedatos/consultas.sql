/* Consulta par obtner la información de la habitacione */
SELECT id_habitacion no_habitacion, estatus,tipo, costo FROM habitaciones
INNER JOIN estatus ON habitaciones.id_estatus = estatus.id_estatus
INNER JOIN tipo_habitaciones ON habitaciones.id_tipo_habitacion = tipo_habitaciones.id_tipo_habitacion ORDER BY no_habitacion;

/* Consulta solo para el estatus de la habitacion*/
SELECT no_habitacion, estatus FROM habitaciones
INNER JOIN estatus ON habitaciones.id_estatus = estatus.id_estatus;