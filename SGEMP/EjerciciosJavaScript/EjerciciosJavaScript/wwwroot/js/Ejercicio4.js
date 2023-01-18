window.onload = iniciarEventos;

function iniciarEventos() {
    const btnAnadir = document.getElementById("btnAnadir");
    const btnBorrar = document.getElementById("btnBorrar");
    const btnRecorrer = document.getElementById("btnRecorrer");

    btnAnadir.addEventListener("click", anadir, false);
    btnBorrar.addEventListener("click", borrar, false);
    btnRecorrer.addEventListener("click", recorrer, false);
}

function recorrer() {
    var lista = document.getElementsByTagName("td");
    var cadena = "";
    for (let i = 0; i < lista.length; i++) {
        cadena += lista[i].textContent.trim();
        if (lista.length - 1 != i)
            cadena += ", "
    }
    alert(cadena);
}

function anadir() {
    const tabla = document.getElementById("tabla");
    numRows = tabla.rows.length;
    var filaNueva = tabla.insertRow(numRows);
    var x = tabla.rows[numRows].cells;
    for (let i = 0; i < 2; i++) {
        filaNueva.appendChild(filaNueva.insertCell(i));
        if (i == 0)
            x[i].innerHTML = "celda " + (numRows + 1) + "-1";
        else
            x[i].innerHTML = "celda " + (numRows + 1) + "-2";
    }
}

function borrar() {
    const tableRef = document.getElementById("tabla");
    numRows = tabla.rows.length;
    tableRef.deleteRow(numRows - 1)
}