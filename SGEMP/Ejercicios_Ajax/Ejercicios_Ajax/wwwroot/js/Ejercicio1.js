window.onload = inicializaEventos;
/**
 * */
function inicializaEventos() {
    document.getElementById("btnLlamada").onclick = saludar;
    //document.getElementById("btnLlamada").onclick = pedirNombre(); si le pongo los parentesis llama a la función y la ejecuta,
    //si los quito, solo dice que el onclik es la función, y cuando le de, lo hará
}
/**
 * */
function saludar () {
    //Punto 1
    var miLlamada = new XMLHttpRequest(); 
    var divSaludo = document.getElementById("divSaludo");
    //Punto 2
    miLlamada.open("GET", "http://localhost:5175/Hola.html"); 

    //Definicion estados
    //Punto 4
    miLlamada.onreadystatechange = function () //Esta es una función anónima.
    { 
        alert(miLlamada.readyState); // veo los estados por los que pasa
        if (miLlamada.readyState < 4) {

            //aquí se puede poner una imagen de un reloj o un texto “Cargando”

            divSaludo.innerHTML = "Cargando...";
        }
        else if (miLlamada.readyState == 4 && miLlamada.status == 200) {
            alert(miLlamada.readyState);
            divSaludo.innerHTML = miLlamada.responseText;
        }
    };
    //Punto 5
    miLlamada.send();   
}