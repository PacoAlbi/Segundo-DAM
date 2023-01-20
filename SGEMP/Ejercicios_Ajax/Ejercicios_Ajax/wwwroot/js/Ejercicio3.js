window.onload = inicializaEventos;

function inicializaEventos() {
    document.getElementById("btnLlamada").addEventListener("click", pedirNombre, false);
    //document.getElementById("btnLlamada").onclick = pedirNombre;
    //document.getElementById("btnLlamada").onclick = pedirNombre(); si le pongo los parentesis llama a la función y la ejecuta,
    //si los quito, solo dice que el onclik es la función, y cuando le de, lo hará
}

function pedirNombre() {

    var miLlamada = new XMLHttpRequest(); //Punto 1
    var divEstado = document.getElementById("divEstado");
    miLlamada.open("GET", "https://apipersonaspaco.azurewebsites.net/api/personascondepartamento"); //Punto 2

    //Definicion estados

    miLlamada.onreadystatechange = function () {                  //Esta es una función anónima. Paso 4
        alert(miLlamada.readyState);// veo los estados por los que pasa
        if (miLlamada.readyState < 4) {

            //aquí se puede poner una imagen de un reloj o un texto “Cargando”
            divEstado.innerHTML = "Cargando...";

        }

        else if (miLlamada.readyState == 4 && miLlamada.status == 200) {
            alert(miLlamada.readyState);
            var pedirResultado = JSON.parse(miLlamada.responseText);
            //alert(arrayPersonas); No trae un array, trae un objeto
            //divNombre.innerHTML = pedirResultado.results[0].name;
           rellenarTablaPersonas(pedirResultado);
        }
    };

    miLlamada.send();   //Paso 5

}

function rellenarTablaPersonas(arrayPersonas) {
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
    }
    tbody.appendChild = html;
    tablaPersonas.appendChild(tbody);
    console.log(tablaPersonas)
    console.log(arrayPersonas)
}