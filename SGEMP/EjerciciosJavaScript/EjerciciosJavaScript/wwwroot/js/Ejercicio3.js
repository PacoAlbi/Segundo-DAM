window.onload = inicializaEventos;
/**
 * */
function inicializaEventos() {
    var platosSelect = document.getElementById("platosSelect");
    cargarComidas();
    platosSelect.addEventListener("change", cargarPlatos, false)

}
/**
 * */
function cargarComidas() {

    var arrayComidas = ["Pizzas", "Hamburguesas", "Pastas"];
    //arrayComidas.sort(); Puedo ordenar si quiero.
    anadirOpciones("comidas", arrayComidas);
}
/**
 * */
function anadirOpciones(domelement, array) {
    var select = document.getElementsByName(domelement)[0];
    for (value in array) {
        var option = document.createElement("option");
        option.text = array[value];
        select.add(option);
    }
}
/**
 * */
function cargarPlatos() {

    //let selectComidas = document.getElementById("btnComidas");
    //let platos = selectComidas.options[selectComidas.selectedIndex].text;
    var platoElegido = document.getElementById("platosSelect").value;
    console.log(platoElegido);

    if (document.getElementById("listaPlatos") != null) {
        document.getElementById("listaPlatos").remove();
    }

    var listaPlatos;
    switch (platos) {
        case "Pizzas":
            listaPlatos = ["Proscciuto", "Cuatro estaciones", "BBQ", "Caprichosa", "Cuatro quesos"];
            break;
        case "Hamburguesas":
            listaPlatos = ["BLT", "Whopper", "BaconQueso", "MacDonald"];
            break;
        case "Pastas":
            listaPlatos = ["Macarrones", "Spaguetti", "Tallarines"];
            break;
    } 
    //Recorremos la lista
    listaPlatos.forEach(function (plato) {
        var option = document.createElement('option')
        option.innerHTML = plato;
        option.value = plato;
        //ponemos un hijo a la lista
        platosSelect.appendChild(option);
    });
}