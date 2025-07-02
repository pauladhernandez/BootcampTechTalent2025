// Ejercicio 1
let parrafos = document.getElementsByTagName('p');
for (let i = 0; i < parrafos.length; i++) {
  parrafos[i].style.color = 'blue';
}
// Ejercicio 2
let imagenes = document.getElementsByTagName('img');
console.log('Cantidad de imágenes en la página:', imagenes.length);


// Ejercicio 3
let button = document.getElementsByTagName('button');
for (let i = 0; i < button.length; i++) {
  button[i].textContent = 'Click aquí';
}

