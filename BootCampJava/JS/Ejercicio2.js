/*
2.- Crear un programa que solicite 2 números por prompt. Mandar esos dos valores a una función por 
parámetros para realizar las operaciones aritméticas básicas( suma, resta, multiplicación y división), y mostrar el resultado.
Nota: El resultado puede ser mostrado por consola o por html.

*/
var a =parseFloat( prompt("Ingresa el primer valor: "));
var b =parseFloat( prompt("Ingresa el segundo valor mayor a cero: "));


console.log("La suma es: " + suma(a,b));
console.log("La resta es: " + resta(a,b));
console.log("La multiplicación es: " + multiplicación(a,b));
console.log("La división es: " + division(a,b));
document.writeln("La suma es: " + suma(a,b) + "<br/>");
document.writeln("La resta es: " + resta(a,b) + "<br/>");
document.writeln("La multiplicación es: " + multiplicación(a,b) + "<br/>");
document.writeln("La división es: " + division(a,b) + "<br/>");

function suma(a,b){
    return a+b;
}
function resta(a,b){
    return a-b;
}
function multiplicación(a,b){
    return a*b;
}
function division(a,b){
    return a/b;
}