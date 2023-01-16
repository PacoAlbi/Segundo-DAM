window.onload = inicializaEventos;

class Persona {
    constructor(nombre, apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
}

function inicializaEventos() {

    document.getElementById("btnSaludo").onclick = saludar;

    //document.getElementById("btnSaludo").addEventListener("click", saludar, false); Este hace lo mismo que el de arriba

}

function saludar() {

    var persona = new Persona(document.getElementById("txtNombre").value, document.getElementById("txtApellido").value)
    alert("Hola " + persona.nombre + " " + persona.apellido);

}