window.onload = inicializaEventos;

function inicializaEventos() {
    document.getElementById("btnLlamada").addEventListener("click", pedirNombre, false);
    //document.getElementById("btnLlamada").onclick = pedirNombre;
    //document.getElementById("btnLlamada").onclick = pedirNombre(); si le pongo los parentesis llama a la función y la ejecuta,
                                                                    //si los quito, solo dice que el onclik es la función, y cuando le de, lo hará
}


function pedirNombre() {

    var miLlamada = new XMLHttpRequest(); //Punto 1
    var divNombre = document.getElementById("divNombre");
    miLlamada.open("GET", "https://swapi.dev/api/people"); //Punto 2

    //Definicion estados

    miLlamada.onreadystatechange = function () {                  //Esta es una función anónima. Paso 4
        //alert(miLlamada.readyState); veo los estados por los que pasa
        if (miLlamada.readyState < 4) {

            //aquí se puede poner una imagen de un reloj o un texto “Cargando”
            divNombre.innerHTML = "Cargando...";

        }

        else

            if (miLlamada.readyState == 4 && miLlamada.status == 200) {

                var pedirResultado = JSON.parse(miLlamada.responseText);
                //alert(arrayPersonas); No trae un array, trae un objeto
                divNombre.innerHTML = pedirResultado.results[0].name;

                rellenarTablaPersonas(arrayPersonas)

            }
    };

    miLlamada.send();   //Paso 5

}

function rellenarTablaPersonas(arrayPersonas) {

}