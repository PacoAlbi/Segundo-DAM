window.onload = inicializaEventos;
/**
 * */
function inicializaEventos() {
    document.getElementById("btnLlamada").addEventListener("click", pedirNombre, false);
}
/**
 * */
//function pedirDepartamentos() {
//    //Punto 1
//    var miLlamada = new XMLHttpRequest();
//    var divEstado = document.getElementById("divEstado");
//    var pedirResultado
//    //Punto 2
//    miLlamada.open("GET", "https://apipersonaspaco.azurewebsites.net/api/departamentos", false);
//    //Punto 4
//    miLlamada.onreadystatechange = function () {
//        if (miLlamada.readyState < 4) {
//            divEstado.innerHTML = "Pidiendo datos a la API...";
//        }

//        else if (miLlamada.readyState == 4 && miLlamada.status == 200) {

//            pedirResultado = JSON.parse(miLlamada.responseText);
//        }
//    };
//    //Punto 5
//    miLlamada.send();
//    return pedirResultado;
//}
/**
 * */
//function pedirNombre() {
//    var departamentos = pedirDepartamentos();
//    var pedirPersonas;
//    //Punto 1
//    var miLlamada = new XMLHttpRequest(); 
//    var divEstado = document.getElementById("divEstado");
//    //Punto 2
//    miLlamada.open("GET", "https://apipersonaspaco.azurewebsites.net/api/personascondepartamento", false); 
//    //Punto 4
//    miLlamada.onreadystatechange = function ()
//    { 
//        if (miLlamada.readyState < 4) {
//            divEstado.innerHTML = "Pidiendo datos a la API...";
//        }

//        else if (miLlamada.readyState == 4 && miLlamada.status == 200) {

//            pedirPersonas = JSON.parse(miLlamada.responseText);
//            //Método para unir personas con departamento. Iría aquí, despues de recibir ya los departamentos.
//            //rellenarPersonasDep(pedirPersonas, departamentos);
//            //llenarTabla(pedirPersonas, departamentos);
//            rellenarTablaPersonas(pedirPersonas);
//            divEstado.innerHTML = "";
//        }
//    };
//    //Punto 5
//    miLlamada.send();   
//}

//function llenarTabla(arrayDeGentuza, arrayDepart) {

//    let tabla = document.getElementById("tablaPersonas") // Obtenemos la tabla del html
//    let bodyTabla = document.createElement("tbody") // y creo el cuerpo para la tabla

//    for (var i = 0; i < arrayDeGentuza.length; i++) {

//        //console.log(arrayDeGentuza[i].nombre)
//        let fila = document.createElement("tr") // creo una fila

//        let contenido = document.createElement("td") // creo el elemento para el contenido
//        contenido.innerText = arrayDeGentuza[i].nombre // en el contenido meto el nombre
//        fila.appendChild(contenido) // y en la fila meto el contenido

//        contenido = document.createElement("td") // creo otra otro elemento para el contenido
//        contenido.innerText = arrayDeGentuza[i].apellidos // y repito lo de arriba
//        fila.appendChild(contenido)
//        var departamento = arrayDeGentuza[i].idDepartamento
//        contenido = document.createElement("td")
//        contenido.innerText = arrayDepart[departamento].nombre
//        fila.appendChild(contenido)

//        bodyTabla.appendChild(fila) // al cuerpo de la tabla le meto la fila
//    }

//    tabla.appendChild(bodyTabla) // a la tabla le meto el cuerpo de la tabla (tbody)
//}

///**
// * */
//function rellenarPersonasDep(pedirPersonas, departamentos) {
//    var tablaPersonas = document.getElementById("tablaPersonas");
//    var tbody = document.createElement("tbody");
//    for (i = 0; i < pedirPersonas.length; i++) {
//        var fila = document.createElement("tr");
//        var columna = document.createElement("td");
//        columna.innerHTML = arrayPersonas[i].id;
//        fila.appendChild(columna);
//        columna = document.createElement("td");
//        columna.innerHTML = arrayPersonas[i].nombre;
//        fila.appendChild(columna);
//        columna = document.createElement("td");
//        columna.innerHTML = arrayPersonas[i].apellidos;
//        fila.appendChild(columna);
//        columna = document.createElement("td");
//        columna.innerHTML = arrayPersonas[i].telefono;
//        fila.appendChild(columna);
//        columna = document.createElement("td");
//        columna.innerHTML = arrayPersonas[i].direccion;
//        fila.appendChild(columna);
//        columna = document.createElement("td");
//        var foto = document.createElement("img");
//        foto.width = 50;
//        foto.height = 50;
//        foto.src = arrayPersonas[i].foto;
//        fila.appendChild(foto);
//        columna = document.createElement("td");
//        columna.innerHTML = arrayPersonas[i].fechaNacimiento;
//        fila.appendChild(columna);
//        columna = document.createElement("td");
//        columna.innerText = departamentos[pedirPersonas[i]].nombre;


//        fila.appendChild(columna);
//        tbody.appendChild(fila);
//    }
//    tablaPersonas.appendChild(tbody);
//    console.log(tbody);
//}
/**
 * */
function rellenarTablaPersonas(arrayPersonas)
{
    var tablaPersonas = document.getElementById("tablaPersonas");
    var tbody = document.createElement("tbody");
    for (i = 0; i < arrayPersonas.length; i++) {
        var fila = document.createElement("tr");
        var columna = document.createElement("td");
        columna.innerHTML = arrayPersonas[i].id;
        fila.appendChild(columna);
        columna = document.createElement("td");
        columna.innerHTML = arrayPersonas[i].nombre;
        fila.appendChild(columna);
        columna = document.createElement("td");
        columna.innerHTML = arrayPersonas[i].apellidos;
        fila.appendChild(columna);
        columna = document.createElement("td");
        columna.innerHTML = arrayPersonas[i].telefono;
        fila.appendChild(columna);
        columna = document.createElement("td");
        columna.innerHTML = arrayPersonas[i].direccion;
        fila.appendChild(columna);
        columna = document.createElement("td");
        var foto = document.createElement("img");
        foto.width = 50;
        foto.height = 50;
        foto.src = arrayPersonas[i].foto;
        fila.appendChild(foto);
        columna = document.createElement("td");
        columna.innerHTML = arrayPersonas[i].fechaNacimiento;
        fila.appendChild(columna);
        columna = document.createElement("td");
        columna.innerHTML = arrayPersonas[i].idDepartamento;
        fila.appendChild(columna);
        columna = document.createElement("td");
        columna.innerHTML = arrayPersonas[i].nombreDpto;
        fila.appendChild(columna);
        tbody.appendChild(fila);
        //No se porque este método no me funciona
        //var html += '<tr>' +
        //    '<td>' + arrayPersonas[i].nombre + '</td>' +
        //    '<td>' + arrayPersonas[i].apellidos + '</td>' +
        //    '<td>' + arrayPersonas[i].telefono + '</td>' +
        //    '<td>' + arrayPersonas[i].direccion + '</td>' +
        //    '<td>' + arrayPersonas[i].foto + '</td>' +
        //    '<td>' + arrayPersonas[i].fechaNacimiento + '</td>' +
        //    '<td>' + arrayPersonas[i].idDepartamento + '</td>' +
        //    '<td>' + arrayPersonas[i].nombreDpto + '</td>' +
        //    '</tr>';
        //tbody.appendChild = html;
    }
    tablaPersonas.appendChild(tbody);
    console.log(tbody);
}

/**
 * */
function pedirNombre() {
    //Punto 1
    var miLlamada = new XMLHttpRequest();
    var divEstado = document.getElementById("divEstado");
    //Punto 2
    miLlamada.open("GET", "https://apipersonaspaco.azurewebsites.net/api/personascondepartamento", false);
    //Punto 4
    miLlamada.onreadystatechange = function () {
        if (miLlamada.readyState < 4) {
            divEstado.innerHTML = "Pidiendo datos a la API...";
        }

        else if (miLlamada.readyState == 4 && miLlamada.status == 200) {

            var pedirResultado = JSON.parse(miLlamada.responseText);
            //Método para unir personas con departamento. Iría aquí, despues de recibir ya los departamentos.
            rellenarTablaPersonas(pedirResultado);
            divEstado.innerHTML = "";
        }
    };
    //Punto 5
    miLlamada.send();
}