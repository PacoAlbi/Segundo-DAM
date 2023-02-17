//Inicializo los eventos al cargar la pagina.
window.onload = inicializaEventos;
//Creo las variables globales.
var listaPersonas;
var listaDepartamentos;
/**
 * Precondiciones: No tiene.
 * Función que carga todo lo necesario al inicio.
 * Postcondiciones: No tiene.
 * */
function inicializaEventos() {
    //Cargo mi tabla primera.
    pedirPersonas();
    //Preparo el botón de guardar.
    document.getElementById("btnGuardar").addEventListener("click", actualizarTabla, false);
}
/**
 * Precondiciones: No tiene.
 * Función que abra una conexión con la API y pide una lista de personas con departamentos.
 * Postcondiciones: Lanza una llamada a la API.
 * */
function pedirPersonas() {
    //Preparo mis variables.
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
            pedirDepartamentos();
            divEstado.innerHTML = "";
        }
    };
    //Hago la llamada a la API.
    miLlamada.send();
}
/**
 * Precondiciones: No tiene.
 * Función que abra una conexión con la API y pide una lista de personas con departamentos.
 * Postcondiciones: Lanza una llamada a la API.
 * */
function pedirDepartamentos() {
    //Preparo mis variables.
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
            rellenarTablaPersonas();
            divEstado.innerHTML = "";
        }
    };
    //Hago la llamada a la API.
    miLlamada.send();
}
/**
 * Precondiciones: Debe recibir una lista de personas.
 * Método que recibe una lista de personas y crea la estructura de la tabla en el html para mostrala.
 * Postcondiciones: No tiene.
 * */
function rellenarTablaPersonas() {
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
        var select = document.createElement("select");
        for (var j = 0; j < listaDepartamentos.length; j++)
        {
            var option = document.createElement("option");
            option.value = listaDepartamentos[j].id;
            option.innerHTML = listaDepartamentos[j].nombre;
            if (listaPersonas[i].idDepartamento == listaDepartamentos[j].id)
            {
                option.selected = true;
            }
            select.appendChild(option);
        }
        fila.appendChild(contenido);
        contenido.appendChild(select);

        //Añado la fila a la tabla.
        cuerpoTabla.appendChild(fila);
    }
    //Añado el cuerpo completo a la tabla.
    tabla.appendChild(cuerpoTabla);
}
/**
 * Precondiciones: No tiene.
 * Función que manda los datos a la tabla para ir insertandolos uno a uno en la BBDD.
 * Postcondiciones: No tiene.
 * */
function actualizarTabla() {
    //Creo las alertas.
    var divEstado = document.getElementById("divEstado");
    var divAlert = document.getElementById("divAlert");
    var miLlamada = new XMLHttpRequest();
    var select;
    for (var i = 0; i < listaPersonas.length; i++)
    {
        select = document.getElementById(listaPersonas[i].id);
        if (listaPersonas[i].idDepartamento != select.value)
        {
            listaPersonas[i].idDepartamento = select.value;
            var json = JSON.stringify(listaPersonas[i]);
            miLlamada.open("PUT", "http://localhost:5119/api/examen", false);
            miLlamada.setRequestHeader('Content-type', 'application/json; charset=utf-8');
            //miLlamada.onreadystatechange = function () {
            //    if (miLlamada.readyState < 4) {
            //        divEstado.innerHTML = "Accediendo a datos...";
            //    }
            //    else if (miLlamada.readyState == 4 && miLlamada.status == 200) {
            //        divEstado.innerHTML = "";
            //        divAlert.innerHTML = "Persona insertada con éxito.";
            //    }
            //    else {
            //        divAlert.innerHTML = "Error al insertar en la BBDD.";
            //    }
            //};
            //Hago la llamada y mando el JSON con la persona.
            miLlamada.send(json);
        }
    }
}