//alert("Condicionales");
var edad = prompt("¿Cuál es tu edad?");
var mensaje;
if((edad >= 18) && (edad <= 29 )){
    //console.log("Eres mayor de edad");
    mensaje = "Felicidades has sido aceptado en el  Bootcamp de Generation"
}else{
    //console.log("Eres menor de edad")
    mensaje = "Lo sentimos no ha sido seleccionado al Bootcamp";
}
document.write(mensaje);
alert(mensaje);