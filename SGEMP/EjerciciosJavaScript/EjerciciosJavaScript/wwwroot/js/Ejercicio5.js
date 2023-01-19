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
    var hora = horaActual.getHours().toString();
    var minutos = horaActual.getMinutes();
    var segundos = horaActual.getSeconds();
    //Compruebo si es menor de 10.
    minutos = comprobarDecimal(minutos);
    segundos = comprobarDecimal(segundos);
    miHora = hora + " : " + minutos + " : " + segundos;
    document.getElementById("reloj").innerHTML = miHora; //*
    setTimeout(function () { mostrarHora() }, 1000);
    //Posible solución
    for (i = 0; i < hora.length; i++)
    {
        var src = obtenerNumeros(miHora.charAt(i));
        var imagen = document.getElementById("img");
        imagen.src = src;
        //divPadre.appendChild(imagen);  arreglar por el *
    }
}
/**
 * */
function comprobarDecimal(i) {
    if (i < 10) {
        i = "0" + i;
    }
    return i;
}
/**
 * */
function obtenerNumeros(numeros)
{
    var numero = parseInt(numeros);
    var src = "../reloj/dosPuntos.gif";
    if (numero >= 0 && numero <= 9)
    {
        src = "../reloj/" + numero + ".gif";
    }
    return src;
}
/**
 * */
function relojAlvaro()
{
    //Hay que cargar todas las imagenes en el div del HTML
    var hora1 = document.getElementById("digitoHora1");
    var hora2 = document.getElementById("digitoHora2");
    var min1 = document.getElementById("digitoMin1");
    var min2 = document.getElementById("digitoMin2");
    var seg1 = document.getElementById("digitoSeg1");
    var seg2 = document.getElementById("digitoSeg2");
    var today = new Date();
    var now = today.toLocaleTimeString("es-ES", { hour: "2-digit", minute: "2-digit", second: "2-digit" });
    var valores = now.split(":");
    var h1 = valores[0].charAt(0);
    var h2 = valores[0].charAt(1);
    var m1 = valores[1].charAt(0);
    var m2 = valores[1].charAt(1);
    var s1 = valores[2].charAt(0);
    var s2 = valores[2].charAt(1);
    hora1.src = "../(reloj o img?)/" + h1 + ".gif";
    hora2.src = "../(reloj o img?)/" + h2 + ".gif";
    min1.src = "../(reloj o img?)/" + m1 + ".gif";
    min2.src = "../(reloj o img?)/" + m2 + ".gif";
    seg1.src = "../(reloj o img?)/" + s1 + ".gif";
    seg2.src = "../(reloj o img?)/" + s2 + ".gif";
}