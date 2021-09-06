/*
1.- Crear un programa que solicite al usuario su nombre por prompt y devuelva el siguiente saludo: 
"Hola nombre, saludos desde javascript". 
Nota: El saludo puede ser mostrado por consola o por html.

*/
var nombre = prompt("Ingresa tu nombre: ");
document.write("Hola ", nombre, ". Saludos desde JavaScript.");
console.log("Hola ", nombre + ". Saludos desde JavaScript.");
console.log(`Hola ${nombre.toLocaleLowerCase()}. Saludos desde JavaScript.`)