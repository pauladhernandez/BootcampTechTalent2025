console.log ("¡Hola, mundo!");

// Template Strings

const nombre   = 'Marc';
const apellido = 'Esteve';

// const nombreCompleto = nombre + ' ' + apellido;
const nombreCompleto = `${ nombre } ${ apellido }`;

console.log( nombreCompleto );

function getSaludo(nombre) {
    return 'Hola ' + nombre;
}

console.log( `Este es un texto: ${ getSaludo( nombre ) }  ` );

// Funciones en JS

//Función normal
function sumar( a, b ) {
    return a + b;
}
console.log(sumar(8,9));

// Función de flecha
const saludar1 = ( nombre ) => {return `Hola, ${ nombre }`;
}

console.log(saludar1('Marc'));


// Función de flecha simplificada
const saludar2 = ( nombre, apellido ) => `Hola, ${nombre} ${apellido }`;

console.log(saludar2('Marc', 'Esteve'));

// Función de flecha sin parámetros con retorno implícito
const saludar3 = () => `Hola Mundo`;

// Función de flecha simplificada con un solo parámetro
// const saludar = nombre => `Hola, ${ nombre }`;

// console.log( saludar('Marc') )

console.log( saludar2("Pedro","Jiménez") );
console.log( saludar3("Andreu") );

const getUser = () => ({
        uid: 'ABC123',
        username: 'El_Papi1502'
});


const user = getUser();
console.log(user);

const getUsuarioActivo = ( nombre ) =>({
    uid: 'ABC567',
    username: nombre
})

const usuarioActivo = getUsuarioActivo('Fernando');
console.log( usuarioActivo );

const persona = {
    Nombre: 'Peter',
    edad: 18,
    clave: 'Spiderman'};

// Desestructuración del objeto persona
const { Nombre: name, edad, clave } = persona;

console.log(nombre); // 'Peter'
console.log(edad);   // 18
console.log(clave);  // 'Spiderman'


const usarContexto = ({ clave, nombre, edad, rango = 'Vecino amigable' }) => {

    // Aquí podrías hacer cualquier lógica adicional
    return {
        nombreClave: clave,
        anys: edad,
        latlng: {
            lat: 40.7128,   // Coordenadas de Nueva York 🗽
            lng: -74.0060
        }
    }
};

// Desestructuración al llamar la función
const { nombreClave, anys, latlng: { lat, lng } } = usarContexto(persona);

console.log(nombreClave, anys);  // 'Spiderman', 18
console.log(lat, lng);            // 40.7128, -74.0060


const personajes = ['Peter Parker', 'Miles Morales', 'Gwen Stacy'];

const[personaje1] = personajes;
const[ , personaje2] = personajes;
const [ , , personaje3 ] = personajes;

console.log(personaje1); // Peter Parker
console.log(personaje2); // Miles Morales
console.log(personaje3); // Gwen Stacy



const retornaSpideyInfo = () => {
    return ['Spidey', 2002];
}

const [ alias, añoAparicion ] = retornaSpideyInfo();
console.log(alias, añoAparicion); // Spidey 2002
