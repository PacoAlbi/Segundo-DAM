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
    var divEstado = document.getElementById("div");
    //Hago la llamada a la api con el verbo correspondiente.
    miLlamada.open("GET", "http://localhost:5119/api/examen");
    //Espero Datos.
    miLlamada.onreadystatechange = function () {
        if (miLlamada.readyState < 4) {
            //alert(miLlamada.readyState);  Fernando, no se porque no me funciona poner el estado de esta forma, asi que lo pongo en el html.
            //divEstado.innerHTML = "Pidiendo datos a la API...";
        }
        else if (miLlamada.readyState == 4 && miLlamada.status == 200) {
            listaPersonas = JSON.parse(miLlamada.responseText);
            pedirDepartamentos();
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
    var divEstado = document.getElementById("div");
    //Hago la llamada a la api con el verbo correspondiente.
    miLlamada.open("GET", "http://localhost:5119/api/departamentos");
    //Espero Datos.
    miLlamada.onreadystatechange = function () {
        if (miLlamada.readyState < 4) {
            //alert(miLlamada.readyState);  Fernando, no se porque no me funciona poner el estado de esta forma, asi que lo pongo en el html.
            //divEstado.innerHTML = "Pidiendo datos a la API...";
        }
        else if (miLlamada.readyState == 4 && miLlamada.status == 200) {
            listaDepartamentos = JSON.parse(miLlamada.responseText);
            rellenarTablaPersonas();
            divEstado.hidden = true;
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
        //Creo el elemento select.
        var select = document.createElement("select");
        select.id = listaPersonas[i].id;
        //Recorro los departamentos para mostrarlos.
        for (var j = 0; j < listaDepartamentos.length; j++)
        {
            //Creo las opciones.
            var option = document.createElement("option");
            //Añado value al opton con el id.
            option.value = listaDepartamentos[j].id;
            //Añado el nombre del departamento al html.
            option.innerHTML = listaDepartamentos[j].nombre;
            //Compruebo si el departamento de la persona es el mismo que el departamento de la lista.
            if (listaPersonas[i].idDepartamento == listaDepartamentos[j].id)
            {
                //Si es el mismo, lo selecciono.
                option.selected = true;
            }
            //Añado la opción al select.
            select.appendChild(option);
        }
        //Añado el select al contenido.
        contenido.appendChild(select);
        //Añado el contenido a la fila.
        fila.appendChild(contenido);
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
    //Creo la alerta y el contador de cambios.
    var cont = 0;
    var divAlert = document.getElementById("divAlert"); 
    for (var i = 0; i < listaPersonas.length; i++)
    {
        var select = document.getElementById(listaPersonas[i].id);
        if (listaPersonas[i].idDepartamento != select.value)
        {
            var miLlamada = new XMLHttpRequest();
            listaPersonas[i].idDepartamento = select.value;
            var json = JSON.stringify(listaPersonas[i]);
            miLlamada.open("PUT", "http://localhost:5119/api/examen");
            miLlamada.setRequestHeader('Content-type', 'application/json; charset=utf-8');
            miLlamada.send(json);
            cont++;
        }
    }
    divAlert.innerHTML = "Se han actualizado " + cont + " registros.";
}