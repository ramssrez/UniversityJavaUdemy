var cantidad= [];
var c1 = parseInt(prompt("Valor 1"));
cantidad.push(c1);
var c2 = parseInt(prompt("Valor 1"));
cantidad.push(c2);
var c3 = parseInt(prompt("Valor 1"));

var a = prompt("Valor 1");

var b = prompt("Valor 2");
var c = prompt("Valor 3");

console.log(a);
console.log(b);
console.log(c);

cantidad.push(c3);
cantidad.sort(function(a,b){return a-b});
cantidad.reverse();
document.write("valor ", cantidad[0]);