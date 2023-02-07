window.onload = Inicio;

function Inicio(){
    setInterval(function () {
        var hora = new Date()
        comberitrNumeroEnImagen(hora.getHours(), "hora1", "hora2")
        comberitrNumeroEnImagen(hora.getMinutes(), "minuto1", "minuto2")
        comberitrNumeroEnImagen(hora.getSeconds(), "segundo1", "segundo2")



    }, 1000);
}

/**
 * Actualizara las imagenes en la vista, combirtiendo el numero en imagen, los cmapos seran donde se guardara el numero
 * @param {any} a
 * @param {any} campo1
 * @param {any} campo2
 */
function comberitrNumeroEnImagen(a, campo1, campo2) {
    var digito1 = "../reloj/" + Math.floor(a / 10)+ ".gif";
    var digito2 = "../reloj/" + a% 10 + ".gif";
    document.getElementById(campo1).src=digito1
    document.getElementById(campo2).src = digito2
}