window.onload = inicializaEventos;
/**
 * */
function inicializaEventos() {

    cargarComidas();
    cargarPlatos();
    //document.getElementById("btnComidas").onselect = cargarPlatos(document.getElementById("btnComidas").option);

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

    let selectComidas = document.getElementById("btnComidas");
    let platos = selectComidas.options[selectComidas.selectedIndex].text;

    var arrayPizzas = ["Proscciuto", "Cuatro estaciones", "BBQ"];
    var arrayHamburguesas = ["BLT", "Whopper", "BaconQueso"];
    var arrayPastas = ["Macarrones", "Spaguetti", "Tallarines"];

    switch (platos) {
        case "Pizzas":
            anadirOpciones("platos", arrayPizzas);
            break;
        case "Hamburguesas":
            anadirOpciones("platos", arrayHamburguesas);
            break;
        case "Pastas":
            anadirOpciones("platos", arrayPastas);
            break;
    } 
}