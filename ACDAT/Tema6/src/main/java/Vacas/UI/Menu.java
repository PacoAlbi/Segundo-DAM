//package UI;
//
//import java.util.Scanner;
//
//public class Menu {
//    private static Scanner sc = new Scanner(System.in);
//    /**
//     * Descripcion: Metodo que te muestra las opciones del menu por pantalla y te pide que elijas una de ellas o pulses cualquier tecla para salir.
//     * Precondiciones: ninguna
//     * Postcondiciones: Devuelve la opcion elegida por el usuario
//     *
//     * @return opc
//     */
//    private int menu() {
//        int opc;
//        System.out.println("""
//                Menu:
//                [1]. Insertar datos en tablas
//                [2]. Listar datos de tablas
//                [3]. Borrar datos en las tablas
//                [4]. Modificar datos en las tablas
//                [0]. Salir
//                Elige una opcion:""");
//        opc = comprobarOpcion(sc.nextLine());
//        return opc;
//    }
//
//    /**
//     * Descripcion: Metodo que te pregunta sobre que tabla quieres trabajar
//     * Precondiciones: ninguna
//     * Postcondiciones: Devuelve la opcion elegida por el usuario
//     *
//     * @return opc
//     */
//
//    public int preguntaTabla(){
//        int opc;
//        System.out.println("""
//                Elija una tabla en la que trabajar
//                [1]. Ganado
//                [2]. Naves
//                [3]. Produccion
//                Elige una opcion:""");
//        opc = comprobarOpcion(sc.nextLine());
//        return opc;
//    }
//
//    /**
//     * Descripcion: Metodo que comprueba que la opcion introducido por teclado es realmente un numero.
//     * Precondiciones: ninguna
//     * Postcondiciones: ninguna
//     *
//     * @param opcionString
//     * @return opcion
//     */
//    private static int comprobarOpcion(String opcionString) {
//        int opcion = -1;
//        try {
//            opcion = Integer.parseInt(opcionString);
//        } catch (NumberFormatException r) {
//            System.err.println("Debe introducir un número");
//        }
//
//        return opcion;
//    }
//
//    /**
//     * Descripcion: Metodo que te manda a las funcion elegida en el metodo menu()
//     * Precondiciones: Ninguna
//     * Postcondiciones: Ninguna
//     *
//     * @param
//     */
//    public void start() {
//        var salir = false;
//        while (!salir) {
//            switch (menu()) {
//                case 1 -> insertarDatos();
//                case 2 -> listarDatos();
//                case 3 -> borrarDatos();
//                case 4 -> modificarDatos();
//                case 0 -> salir = true;
//            }
//        }
//        System.out.println("¡Vuelve pronto!");
//    }
//
//
//    /**
//     * Descripcion: Metodo que te lleva a los metodos de insertar segun la tabla que elijas
//     * Precondiciones: Ninguna
//     * Postcondiciones: Ninguna
//     *
//     * @param
//
//    public void insertarDatos(){
//
//        try {
//            switch (preguntaTabla()) {
//                case 1 -> menuHijasGanado();
//                case 2 -> DAL.insertarMatricula();
//                case 3 -> DAL.insertarAsignatura();
//                }
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//*/
//    /**
//     * Descripcion:
//     * Precondiciones:
//     * Postcondiciones:
//     *
//     * @param
//     */
//
//    private void menuHijasGanado() {
//    }
//
//    /**
//     * Descripcion:Metodo que te lleva a los metodos de listar segun la tabla que elijas
//     * Precondiciones: Ninguna
//     * Postcondiciones: Ninguna
//     *
//     * @param
//     */
//    public void listarDatos(){
//        int tabla = preguntaTabla();
//        try {
//            switch (preguntaTabla()){
//                case 1 -> ManejadoraTablas.listarVacas();
//                case 2 -> ManejadoraTablas.listarNaves();
//                case 3 -> ManejadoraTablas.listarProduccion();
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    /**
//     * Descripcion: Metodo que te lleva a los metodos de borrar segun la tabla que elijas
//     * Precondiciones: Ninguna
//     * Postcondiciones: Ninguna
//     *
//     * @param
//     */
//    public void borrarDatos(){
//        try {
//            switch (preguntaTabla()) {
//                case 1 -> DAL.eliminarVaca();
//                case 2 -> DAL.eliminarNave();
//                case 3 -> DAL.eliminarProduccion();
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    /**
//     * Descripcion: Metodo que te lleva a los metodos de modificar segun la tabla que elijas
//     * Precondiciones: Ninguna
//     * Postcondiciones: Ninguna
//     *
//     * @param
//     */
//    public void modificarDatos(){
//
//        try {
//            switch (preguntaTabla()) {
//                case 1 -> DAL.modificarVaca();
//                case 2 -> DAL.modificarNave();
//                case 3 -> DAL.modificarProduccion();
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//
//}