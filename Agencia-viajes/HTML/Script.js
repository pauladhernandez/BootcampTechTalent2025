function mostrar(id) {
  const secciones = document.querySelectorAll('.continente');
  secciones.forEach(seccion => {
    seccion.style.display = seccion.id === id ? 'block' : 'none';
  });
}
