var frutas = ["Manzana", "Banana", "Mango"];
console.log("Este es el inicio del primer arreglo")
impresionArreglo(frutas);
console.log("Agregando un nuevo elementos")
ingresarArreglo(frutas, "Naranja");
impresionArreglo(frutas);
console.log("Eliminación de un elemento")
eliminarElemento(frutas);
impresionArreglo(frutas);


function impresionArreglo(arreglo){
    for(let i = 0; i < arreglo.length; i++){
        console.log(frutas[i]);
    }
}

function ingresarArreglo(arreglo, op){
    arreglo.push(op);
}

function eliminarElemento(arreglo){
    arreglo.pop();
}