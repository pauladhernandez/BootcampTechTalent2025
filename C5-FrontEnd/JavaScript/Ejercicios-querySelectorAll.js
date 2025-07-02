

// Ejercicio 1
let ps = document.querySelectorAll('p');
ps.forEach(p => {
  p.style.color = 'red';
});

// Ejercicio 2
let imagenes = document.querySelectorAll('img');
console.log('Cantidad de imágenes en la página:', imagenes.length);

// Ejercicio 3
let button = document.querySelectorAll('button');
button.forEach(btn => {
    btn.textContent = 'Click aquí';
    });
    