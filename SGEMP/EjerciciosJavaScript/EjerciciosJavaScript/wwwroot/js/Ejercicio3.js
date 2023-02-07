window.onload = inicializaEventos;


/**
 * Todod lo de bajo hecho por la IA*/
function updateModels(brand) {
    var models;
    if (brand === "Toyota") {
        models = ["Camry", "Corolla", "Prius"];
    } else if (brand === "Honda") {
        models = ["Civic", "Accord", "Fit"];
    } else if (brand === "Ford") {
        models = ["Fiesta", "Focus", "Mustang"];
    }
    var modelSelect = document.getElementById("models");
    modelSelect.innerHTML = "";
    for (var i = 0; i < models.length; i++) {
        var option = document.createElement("option");
        option.value = models[i];
        option.text = models[i];
        modelSelect.add(option);
    }
}

///**
// * */
//function inicializaEventos() {
//    var platosSelect = document.getElementById("platosSelect");
//    cargarComidas();
//    platosSelect.addEventListener("change", cargarPlatos, false)
//}
///**
// * */
//function cargarComidas() {

//    var arrayComidas = ["Pizzas", "Hamburguesas", "Pastas"];
//    //arrayComidas.sort(); Puedo ordenar si quiero.
//    anadirOpciones("comidas", arrayComidas);
//}
///**
// * */
//function anadirOpciones(domelement, array) {
//    var select = document.getElementsByName(domelement)[0];
//    for (value in array) {
//        var option = document.createElement("option");
//        option.text = array[value];
//        select.add(option);
//    }
//}
///**
// * */
//function cargarPlatos() {

//    //let selectComidas = document.getElementById("btnComidas");
//    //let platos = selectComidas.options[selectComidas.selectedIndex].text;
//    var platoElegido = document.getElementById("platosSelect").value;
//    console.log(platoElegido);

//    if (document.getElementById("listaPlatos") != null) {
//        document.getElementById("listaPlatos").remove();
//    }

//    var listaPlatos;
//    switch (platos) {
//        case "Pizzas":
//            listaPlatos = ["Proscciuto", "Cuatro estaciones", "BBQ", "Caprichosa", "Cuatro quesos"];
//            break;
//        case "Hamburguesas":
//            listaPlatos = ["BLT", "Whopper", "BaconQueso", "MacDonald"];
//            break;
//        case "Pastas":
//            listaPlatos = ["Macarrones", "Spaguetti", "Tallarines"];
//            break;
//    }
//    //Recorremos la lista
//    listaPlatos.forEach(function (plato) {
//        var option = document.createElement('option')
//        option.innerHTML = plato;
//        option.value = plato;
//        //ponemos un hijo a la lista
//        platosSelect.appendChild(option);
//    });
//}
//HECHO POR CHAT GPT
//<select id="first-select">
//    <option value="option1">Option 1</option>
//    <option value="option2">Option 2</option>
//    <option value="option3">Option 3</option>
//</select>

//<select id="second-select">
//    <option value="suboption1">Suboption 1</option>
//    <option value="suboption2">Suboption 2</option>
//    <option value="suboption3">Suboption 3</option>
//</select>

//<script>
//  const firstSelect = document.getElementById("first-select");
//  const secondSelect = document.getElementById("second-select");

//  firstSelect.addEventListener("change", function() {
//    const selectedValue = firstSelect.value;
//    let options = "";

//    if (selectedValue === "option1") {
//      options = `
//        <option value="suboption1">Suboption 1</option>
//        <option value="suboption2">Suboption 2</option>
//      `;
//    } else if (selectedValue === "option2") {
//      options = `
//        <option value="suboption2">Suboption 2</option>
//        <option value="suboption3">Suboption 3</option>
//      `;
//    } else if (selectedValue === "option3") {
//      options = `
//        <option value="suboption3">Suboption 3</option>
//        <option value="suboption1">Suboption 1</option>
//      `;
//    }

//    secondSelect.innerHTML = options;
//  });
//</script>