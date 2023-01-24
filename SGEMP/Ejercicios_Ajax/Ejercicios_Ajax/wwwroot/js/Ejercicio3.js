window.onload = inicializaEventos;
/**
 * */
function inicializaEventos() {
    document.getElementById("btnLlamada").addEventListener("click", pedirNombre, false);
}
/**
 * */
function pedirNombre() {
    //Punto 1
    var miLlamada = new XMLHttpRequest(); 
    var divEstado = document.getElementById("divEstado");
    //Punto 2
    miLlamada.open("GET", "https://apipersonaspaco.azurewebsites.net/api/personascondepartamento", true); 
    //Punto 4
    miLlamada.onreadystatechange = function ()
    { 
        if (miLlamada.readyState < 4) {
            divEstado.innerHTML = "Pidiendo datos a la API...";
        }

        else if (miLlamada.readyState == 4 && miLlamada.status == 200) {

            var pedirResultado = JSON.parse(miLlamada.responseText);
            rellenarTablaPersonas(pedirResultado);
            divEstado.innerHTML = "";
        }
    };
    //Punto 5
    miLlamada.send();   
}
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
        var foto = document.createElement("img")
        foto.src = arrayPersonas[i].foto;
        fila.appendChild(columna);
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