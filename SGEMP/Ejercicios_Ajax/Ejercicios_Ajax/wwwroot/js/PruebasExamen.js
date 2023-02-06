window.onload = inicializaEventos;
/**
 * */
function inicializaEventos() {
    document.getElementById("btnGuardar").onclick = insertarPersona;
}

/**
 * */
function insertarPersona() {
    //Punto 1
    var miLlamada = new XMLHttpRequest();
    //var divEstado = document.getElementById("divEstado");
    //var divAlert = document.getElementById("divAlert");
    //Punto 2
    miLlamada.open("POST", "https://apipersonaspaco.azurewebsites.net/api/personas/");
    miLlamada.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    var miPersonita = crearPersona();
    var json = JSON.stringify(miPersonita);
    //Punto 4
    miLlamada.onreadystatechange = function () {
        if (miLlamada.readyState < 4) {
            //divEstado.innerHTML = "Buscando a la persona a borrar...";
        }
        else if (miLlamada.readyState == 4 && miLlamada.status == 200) {
            //divEstado.innerHTML = "";
            //divAlert.innerHTML = "Persona insertada con éxito.";
        }
        else {
            //divAlert.innerHTML = "Error al insertar en la BBDD.";
        }
    };
    //Punto 5
    miLlamada.send(json);
}

function crearPersona() {
    var miPersona;
    var nombre = document.getElementById("txtNombre").value;
    var apellidos = document.getElementById("txtApellidos").value;
    var telefono = document.getElementById("txtTelefono").value;
    var direccion = document.getElementById("txtDireccion").value;
    var foto = document.getElementById("txtFoto").value;
    var fecha = document.getElementById("inputFecha").value;
    var idDep = document.getElementById("txtDepartamento").value;
    miPersona = new Persona(nombre, apellidos, telefono, direccion, foto, fecha, idDep);
    return miPersona;
}

class Persona {
    constructor(nombre, apellidos, telefono, direccion, foto, fechaNacimiento, idDepartamento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.foto = foto;
        this.fechaNacimiento = fechaNacimiento;
        this.idDepartamento = idDepartamento;
    }
}