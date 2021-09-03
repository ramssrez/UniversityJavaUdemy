var datos = [];
datos.push( prompt("Ingresa el primer valor"));
datos.push( prompt("Ingresa el segundo valor"));
datos.push( prompt("Ingresa el tercero valor"));

//impresionArreglo(datos);
datos.sort();
impresionArreglo(datos);
document.write("El valor mayor es ", datos[2]);
//console.log(datos[0]);
//datos.shift()





//Esto es opcional
function impresionArreglo(arreglo){
    document.write(" ");
    for(let i = 0; i < arreglo.length; i++){
        console.log(arreglo[i]);
        //document.write("El valor del numero, ", (i+1)," es ", datos[i], " \n");
    }
}