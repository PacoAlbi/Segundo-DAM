window.onload = iniciarEventos;
/**
 * */
function iniciarEventos() {
    mostrarHora();
}

/**
 * 
 * */
function mostrarHora() {
    var horaActual = new Date();
    var miHora;
    var hora = horaActual.getHours();
    var minutos = horaActual.getMinutes();
    var segundos = horaActual.getSeconds();
    //Compruebo si es menor de 10.
    minutos = comprobarDecimal(minutos);
    segundos = comprobarDecimal(segundos);
    miHora = hora + " : " + minutos + " : " + segundos;
    document.getElementById("reloj").innerHTML = miHora;
    //Refresco cada poco tiempo 
    setTimeout(function () { mostrarHora() }, 1000);
}
/**
 * */
function comprobarDecimal(i) {
    if (i < 10) {
        i = "0" + i;
    }
    return i;
}

function cargarImagenes() {
    var cero = document.createElement("img");
    cero.src = "C:\Users\Paco\Documents\GitHub\Segundo-DAM\SGEMP\EjerciciosJavaScript\EjerciciosJavaScript\wwwroot\reloj\0.gif";
    var uno = document.createElement("img");
    uno.src = "C:\Users\Paco\Documents\GitHub\Segundo-DAM\SGEMP\EjerciciosJavaScript\EjerciciosJavaScript\wwwroot\reloj\1.gif";
    var dos = document.createElement("img");
    dos.src = "C:\Users\Paco\Documents\GitHub\Segundo-DAM\SGEMP\EjerciciosJavaScript\EjerciciosJavaScript\wwwroot\reloj\2.gif";
    var tres = document.createElement("img");
    tres.src = "C:\Users\Paco\Documents\GitHub\Segundo-DAM\SGEMP\EjerciciosJavaScript\EjerciciosJavaScript\wwwroot\reloj\3.gif";
    var cuatro = document.createElement("img");
    cuatro.src = "C:\Users\Paco\Documents\GitHub\Segundo-DAM\SGEMP\EjerciciosJavaScript\EjerciciosJavaScript\wwwroot\reloj\4.gif";
    var cinco = document.createElement("img");
    cinco.src = "C:\Users\Paco\Documents\GitHub\Segundo-DAM\SGEMP\EjerciciosJavaScript\EjerciciosJavaScript\wwwroot\reloj\5.gif";
    var seis = document.createElement("img");
    seis.src = "C:\Users\Paco\Documents\GitHub\Segundo-DAM\SGEMP\EjerciciosJavaScript\EjerciciosJavaScript\wwwroot\reloj\6.gif";
    var siete = document.createElement("img");
    siete.src = "C:\Users\Paco\Documents\GitHub\Segundo-DAM\SGEMP\EjerciciosJavaScript\EjerciciosJavaScript\wwwroot\reloj\7.gif";
    var ocho = document.createElement("img");
    ocho.src = "C:\Users\Paco\Documents\GitHub\Segundo-DAM\SGEMP\EjerciciosJavaScript\EjerciciosJavaScript\wwwroot\reloj\8.gif";
    var nueve = document.createElement("img");
    nueve.src = "C:\Users\Paco\Documents\GitHub\Segundo-DAM\SGEMP\EjerciciosJavaScript\EjerciciosJavaScript\wwwroot\reloj\9.gif";
    var puntos = document.createElement("img");
    puntos.src = "C:\Users\Paco\Documents\GitHub\Segundo-DAM\SGEMP\EjerciciosJavaScript\EjerciciosJavaScript\wwwroot\reloj\dosPuntos.gif";
}