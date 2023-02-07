//Inicializo los eventos al cargar la pagina.
window.onload = inicializaEventos;
/**
 * Precondiciones: No tiene.
 * Función que carga todo lo necesario al inicio.
 * Postcondiciones: No tiene.
 * */
function inicializaEventos() {
    //Cargo mi tabla al principio.
    pedirNombre();
    //Preparo el botón de guardar.
    document.getElementById("btnGuardar").addEventListener("click", actualizarTabla, false);
}
/**
 * Precondiciones: No tiene.
 * Función que abra una conexión con la API y pide una lista de personas con departamentos.
 * Postcondiciones: Lanza una llamada a la API.
 * */
function pedirNombre() {
    //Preparo mis variables.
    var listaPersonas;
    var listaDepartamentos = pedirDepartamentos();
    var miLlamada = new XMLHttpRequest();
    var divEstado = document.getElementById("divEstado");
    //Hago la llamada a la api con el verbo correspondiente.
    miLlamada.open("GET", "http://localhost:5119/api/examen", false);
    //Espero Datos.
    miLlamada.onreadystatechange = function () {
        if (miLlamada.readyState < 4) {
            divEstado.innerHTML = "Pidiendo datos a la API...";
        }
        else if (miLlamada.readyState == 4 && miLlamada.status == 200) {
            listaPersonas = JSON.parse(miLlamada.responseText);
            rellenarTablaPersonas(listaPersonas, listaDepartamentos);
            divEstado.innerHTML = "";
        }
    };
    //Punto 5
    miLlamada.send();
}
/**
 * Precondiciones: No tiene.
 * Función que abra una conexión con la API y pide una lista de personas con departamentos.
 * Postcondiciones: Lanza una llamada a la API.
 * */
function pedirDepartamentos() {
    //Preparo mis variables.
    var listaDepartamentos;
    var miLlamada = new XMLHttpRequest();
    var divEstado = document.getElementById("divEstado");
    //Hago la llamada a la api con el verbo correspondiente.
    miLlamada.open("GET", "http://localhost:5119/api/departamentos", false);
    //Espero Datos.
    miLlamada.onreadystatechange = function () {
        if (miLlamada.readyState < 4) {
            divEstado.innerHTML = "Pidiendo datos a la API...";
        }
        else if (miLlamada.readyState == 4 && miLlamada.status == 200) {
            listaDepartamentos = JSON.parse(miLlamada.responseText);
            divEstado.innerHTML = "";
        }
    };
    //Punto 5
    miLlamada.send();
    return listaDepartamentos;
}
/**
 * Precondiciones: Debe recibir una lista de personas.
 * Método que recibe una lista de personas y crea la estructura de la tabla en el html para mostrala.
 * Postcondiciones: No tiene.
 * */
function rellenarTablaPersonas(listaPersonas, listaDepartamentos) {
    //Pillo la tabla del html.
    let tabla = document.getElementById("tablaPersonas");
    //Creo el elemento cuerpo de la tabla.
    let cuerpoTabla = document.createElement("tbody");
    //Recorro la lista.
    for (var i = 0; i < listaPersonas.length; i++) {
        //Creo una fila.
        let fila = document.createElement("tr");
        //Creo el elemento table data
        let contenido = document.createElement("td");
        //Meto el nombre de la persona.
        contenido.innerText = listaPersonas[i].nombre;
        //Añado el contenido a la fila.
        fila.appendChild(contenido);
        //Creo otro elemento table data
        contenido = document.createElement("td");
        //Meto los apellidos.
        contenido.innerText = listaPersonas[i].apellidos;        
        //Añado otro dato.
        fila.appendChild(contenido);
        //Creo otro elemento table data
        contenido = document.createElement("td");
        //var select = document.createElement("select");
        //for (var i = 0; i < listaDepartamentos.length; i++) {
        //    var option = listaDepartamentos[i].nombre;
        //    var election = document.createElement("option");
        //    election.textContent = option;
        //    election.value = listaDepartamentos[i].id;
        //    select.appendChild(election);
        //}
        //contenido.appendChild(crearSelectDepartamentos(listaDepartamentos))
        //Estoy probando pero solo me muestra los objetos.
        contenido.innerHTML = crearSelectDepartamentos(listaDepartamentos);
        //Añado otro dato.
        fila.appendChild(contenido);
        //Añado la fila a la tabla.
        cuerpoTabla.appendChild(fila);
    }
    //Añado el cuerpo completo a la tabla.
    tabla.appendChild(cuerpoTabla);
}
/**
 * Precondiciones: Debe recibir una lista de departamentos.
 * Método que recibe una lista de departamentos y crea la estructura del select para mostralo.
 * Postcondiciones: No tiene.
 * */
function crearSelectDepartamentos(departamentos) {
    var contenido = document.createElement("select");
    for (var i = 0; i < departamentos.length; i++) {
        var option = departamentos[i].nombre;
        var election = document.createElement("option");
        election.textContent = option;
        election.value = departamentos[i].id;
        contenido.appendChild(election);
    }
    return contenido
}
/**
 * Precondiciones: No tiene.
 * Método que pilla del select la opción y la muestra.
 * Postcondiciones: Devuelve la opción del select seleccionada para poder hacer el cambio.
 * */
function obtenerValorSelect() {
    var sino = document.getElementById("selectDpto");
    var selected = sino.value;
    return selected;
}
/**
 * Precondiciones: No tiene.
 * Función que crea la persona para poder setearla y mandarla a la api.
 * Postcondiciones: No tiene.
 * */
function crearPersona() {
    var miPersona;
    miPersona = new Persona(id, nombre, apellidos, telefono, direccion, foto, fecha, idDep);
    return miPersona;
}
/**
 * Clase Persona para poder editarla y mandarla a la BBDD a través del a API.
 * */
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
/**
 * Precondiciones: No tiene.
 * Función que manda los datos a la tabla para ir insertandolos uno a uno en la BBDD.
 * Postcondiciones: No tiene.
 * */
function actualizarTabla() {
    //Creo la persona que quiero actualizar, y debe recibir de la tabla.
    var miPersonita = crearPersona();
    //Creo la llamada y el resto de variables.
    var miLlamada = new XMLHttpRequest();
    //Creo las alertas.
    var divEstado = document.getElementById("divEstado");
    var divAlert = document.getElementById("divAlert");
    //Hago la petición con el verbo PUT para actualizar y le paso la id de la persona.
    miLlamada.open("PUT", "http://localhost:5119/api/departamentos" + miPersonita.id);
    miLlamada.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    //Preparo el JSON para mandar.
    var json = JSON.stringify(miPersonita);
    //Espero a la conexión, y según la devolución devuelvo una cosa u otra.
    miLlamada.onreadystatechange = function () {
        if (miLlamada.readyState < 4) {
            divEstado.innerHTML = "Accediendo a datos...";
        }
        else if (miLlamada.readyState == 4 && miLlamada.status == 200) {
            divEstado.innerHTML = "";
            divAlert.innerHTML = "Persona insertada con éxito.";
        }
        else {
            divAlert.innerHTML = "Error al insertar en la BBDD.";
        }
    };
    //Hago la llamada y mando el JSON con la persona.
    miLlamada.send(json);
}