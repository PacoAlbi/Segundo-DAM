window.onload = inicializaEventos;

function inicializaEventos() {
    document.getElementById("btnBorrar").onclick = borrarPersona;
}

function borrarPersona () {
    //Punto 1
    var miLlamada = new XMLHttpRequest();
    var divEstado = document.getElementById("divEstado");
    var idAborrar = document.getElementById("txtId").textContent;
    var divAlert = document.getElementById("divAlert");
    //Punto 2
    miLlamada.open("DELETE", "https://apipersonaspaco.azurewebsites.net/api/personascondepartamento/" + idAborrar, true);
    
    //Punto 4
    miLlamada.onreadystatechange = function ()
    {
        var persona = JSON.parse(miLlamada.responseText);
        if (miLlamada.readyState < 4) {
            divEstado.innerHTML = "Buscando a la persona a borrar...";
        }
        else if (miLlamada.readyState == 4 && miLlamada.status == 200)
        {
            console.table(persona);
            divAlert.innerHTML = "Persona eliminada con éxito.";
        }
        else
        {
            console.error(persona);
            divAlert.innerHTML = "Lo siento, ID no encontrada en la BBDD.";
        }
    };
    //Punto 5
    miLlamada.send();
}