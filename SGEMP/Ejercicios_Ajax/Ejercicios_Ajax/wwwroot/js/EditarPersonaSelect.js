﻿window.onload = inicializaEventos;
/**
 * */
function inicializaEventos() {
    document.getElementById("btnBuscar").onclick = buscarPersona;
    document.getElementById("btnGuardar").onclick = insertarPersona;
}
/**
 * */
function buscarPersona() {
    //Punto 1
    var miLlamada = new XMLHttpRequest();
    var idAbuscar = document.getElementById("txtId").value;
    //Punto 2
    miLlamada.open("GET", "https://apimanuulc.azurewebsites.net/api/personas/" + idAbuscar);

    var miPersonita = crearPersona();

    //Punto 4
    miLlamada.onreadystatechange = function () {
        if (miLlamada.readyState < 4) {
            //divEstado.innerHTML = "Buscando a la persona a borrar...";
        }
        else if (miLlamada.readyState == 4 && miLlamada.status == 200) {
            //divEstado.innerHTML = "";
            //divAlert.innerHTML = "Persona insertada con éxito.";
            miPersonita = JSON.parse(miLlamada.responseText);
            mostrarPersona(miPersonita);
        }
        else {
            //divAlert.innerHTML = "Lo siento, ID no encontrada en la BBDD.";
        }
    };
    //Punto 5
    miLlamada.send();
}

function obtenerDepartamentosAPI() {

    var miLlamada = new XMLHttpRequest(); //Punto 1
    var div = document.getElementById("div");
    miLlamada.open("GET", "https://apimanuulc.azurewebsites.net/api/departamentos"); //Punto 2

    //Definicion estados

    miLlamada.onreadystatechange = function () {                  //Esta es una función anónima. Paso 4
        //alert(miLlamada.readyState);// veo los estados por los que pasa
        if (miLlamada.readyState < 4) {

            //aquí se puede poner una imagen de un reloj o un texto “Cargando”
            div.innerHTML = "Cargando...";

        }

        else

            if (miLlamada.readyState == 4 && miLlamada.status == 200) {
                //alert(miLlamada.readyState);
                var pedirResultado = JSON.parse(miLlamada.responseText); // ¿?
                crearSelectDepartamentos(pedirResultado);
            }
    };
    miLlamada.send();   //Paso 5
}
/**
 * */
function mostrarPersona(miPersonita) {
    var divPersona = document.getElementById("divEditar");
    document.getElementById("txtIdEditar").value = miPersonita.id;
    document.getElementById("txtNombre").value = miPersonita.nombre;
    document.getElementById("txtApellidos").value = miPersonita.apellidos;
    document.getElementById("txtTelefono").value = miPersonita.telefono;
    document.getElementById("txtDireccion").value = miPersonita.direccion;
    document.getElementById("txtFoto").value = miPersonita.foto;
    document.getElementById("inputFecha").value = miPersonita.fechaNacimiento;
    document.getElementById("txtDepartamento").value = miPersonita.idDepartamento;
    divPersona.style.display = "block";
    obtenerDepartamentosAPI();
}
/**
 * */
function insertarPersona() {
    var miPersonita = crearPersona();
    //Punto 1
    var miLlamada = new XMLHttpRequest();
    //var divEstado = document.getElementById("divEstado");
    //var divAlert = document.getElementById("divAlert");
    //Punto 2
    miLlamada.open("PUT", "https://apipersonaspaco.azurewebsites.net/api/personas/" + miPersonita.id);
    miLlamada.setRequestHeader('Content-type', 'application/json; charset=utf-8');

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
    var id = document.getElementById("txtIdEditar").value;
    var nombre = document.getElementById("txtNombre").value;
    var apellidos = document.getElementById("txtApellidos").value;
    var telefono = document.getElementById("txtTelefono").value;
    var direccion = document.getElementById("txtDireccion").value;
    var foto = document.getElementById("txtFoto").value;
    var fecha = document.getElementById("inputFecha").value;
    var idDep = obtenerValorSelect();
    miPersona = new Persona(id, nombre, apellidos, telefono, direccion, foto, fecha, idDep);
    return miPersona;
}

class Persona {
    constructor(id, nombre, apellidos, telefono, direccion, foto, fechaNacimiento, idDepartamento) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.foto = foto;
        this.fechaNacimiento = fechaNacimiento;
        this.idDepartamento = idDepartamento;
    }
}

function crearSelectDepartamentos(departamentos) {
    for (var i = 0; i < departamentos.length; i++) {
        var opt = departamentos[i].nombreDepartamento;
        var el = document.createElement("option");
        el.textContent = opt;
        el.value = departamentos[i].idDepartamento;
        document.getElementById("selectDpto").appendChild(el);
    }
}

function obtenerValorSelect() {
    var sino = document.getElementById("selectDpto");
    var selected = sino.value;
    return selected;
}