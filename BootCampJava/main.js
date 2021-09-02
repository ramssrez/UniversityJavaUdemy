//alert("Hola mundo");
//alert('Hola mundo con comillas');
//Esta es la función para JavaScript de console.log
console.log("Hola mundo");
//Esto es un comentario de una sola linea.
/*
Esto es un comnetario de dos lineas o mas
sdfasdf
sadf
asdf
sdf
*/

//Declaración de variables con los diferentes tipos de estado
var nombre = "Raúl";
var apellido = "Ramírez Pérez";
//var edad = 29;

var boleano = false;
var nulo = null;
let indefinido;

//Declaracion de constantes
const gravedad = 9.81;
const PI = 3.146;
//gravedad = 85;



//typeof() es para detrminar el tipo de dato que se tiene de una variable para observarlo de maner correcta.
console.log(typeof(indefinido));
//Impresión del nombre en un alert con el uso de la concatenación
//alert("Hola " + nombre + " "+ apellido);
//alert("Edad: " + edad);
var edad = 18;

//Esta es la opción de si son mayor de edad
if(edad >= 18){
    console.log("Es mmayor de edad");
}else{
    console.log("Es menor de edad")
}

if(edad >= 18 && edad <= 25){
    console.log("Es un adulto joven");
}else if(edad > 25 && edad <= 50){
    console.log("Es un adulto");
}else if(edad > 50 && edad <= 100){
    console.log("Es un adulto mayor");
}else if(edad < 18){
    console.log("Es menor de edad");
}else {
    console.log("Eres centenario");
}

var suma = add(5,6);
console.log(suma);

function add(a,b){
    return a + b;
}

var numero = 40;

if(true){
    var numero = 50;
    console.log(numero);
}

console.log(numero)

var numero2 = "100";
console.log(numero2);

if(true){
    let numero2 = "5";
    //Variables de Scope (alcance o ambito), solo viven por bloques de código
    console.log(numero2);
    let numero3 = 27;
    console.log(numero3);
}
console.log(numero2);
console.log(numero3);