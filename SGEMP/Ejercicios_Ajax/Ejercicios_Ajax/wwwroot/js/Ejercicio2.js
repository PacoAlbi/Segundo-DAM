window.onload = inicializaEventos;

function inicializaEventos() {
    document.getElementById("btnLlamada").addEventListener("click", pedirNombre, false);
    //Otra forma de llamar al click del elemento, entre "" el evento que hará, la función que 
    //desencadenará y si el click se propaga o no en la función.
}


function pedirNombre() {
    //Punto 1
    var miLlamada = new XMLHttpRequest(); 
    var divNombre = document.getElementById("divNombre");
    //Punto 2
    miLlamada.open("GET", "https://swapi.dev/api/people"); 
    //Punto 4
    miLlamada.onreadystatechange = function ()
    {                  
        alert(miLlamada.readyState);
        if (miLlamada.readyState < 4) {
            divNombre.innerHTML = "Cargando...";
        }
        else if (miLlamada.readyState == 4 && miLlamada.status == 200)
        {
            alert(miLlamada.readyState);
            var pedirResultado = JSON.parse(miLlamada.responseText);
            divNombre.innerHTML = pedirResultado.results[1].name;
        }
    };
    //Punto 5
    miLlamada.send();   
}