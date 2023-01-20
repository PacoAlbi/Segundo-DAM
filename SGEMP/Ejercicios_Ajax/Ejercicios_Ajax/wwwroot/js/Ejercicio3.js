window.onload = inicializaEventos;

function inicializaEventos() {
    document.getElementById("btnLlamada").addEventListener("click", pedirNombre, false);
}

function pedirNombre() {
    //Punto 1
    var miLlamada = new XMLHttpRequest(); 
    var divEstado = document.getElementById("divEstado");
    //Punto 2
    miLlamada.open("GET", "https://apipersonaspaco.azurewebsites.net/api/personascondepartamento"); 
    //Punto 4
    miLlamada.onreadystatechange = function ()
    { 

        if (miLlamada.readyState < 4) {
            divEstado.innerHTML = "Pidiendo datos a la API...";
        }

        else if (miLlamada.readyState == 4 && miLlamada.status == 200) {

            var pedirResultado = JSON.parse(miLlamada.responseText);
            rellenarTablaPersonas(pedirResultado);
        }
    };
    //Punto 5
    miLlamada.send();   
}

function rellenarTablaPersonas(arrayPersonas)
{
    var tablaPersonas = document.getElementById("tablaPersonas");
    var tbody = document.createElement("tbody");
    var html;
    for (i = 0; i < arrayPersonas.length; i++) {
        html += '<tr>' +
            '<td>' + arrayPersonas[i].nombre + '</td>' +
            '<td>' + arrayPersonas[i].apellidos + '</td>' +
            '<td>' + arrayPersonas[i].telefono + '</td>' +
            '<td>' + arrayPersonas[i].direccion + '</td>' +
            '<td>' + arrayPersonas[i].foto + '</td>' +
            '<td>' + arrayPersonas[i].fechaNacimiento + '</td>' +
            '<td>' + arrayPersonas[i].idDepartamento + '</td>' +
            '<td>' + arrayPersonas[i].nombreDpto + '</td>' +
            '</tr>';
        tbody.appendChild = html;
    }
    alert(arrayPersonas);
    tablaPersonas.appendChild(tbody);
    console.log(tbody)
    console.log(tablaPersonas)
    console.log(arrayPersonas)
}