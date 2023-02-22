package Utilidades;

import Conecction.Conexion;
import Conecction.DAOGanado;
import Conecction.DAONaves;
import Conecction.DAOProduccion;

import java.util.Scanner;

public class Menu {
    private static final Scanner sc = new Scanner(System.in);

    /**
     * Precondiciones: No tiene.
     * Método que crea la estructura del menú para imprimirla.
     * Postcondiciones: No tiene.
     */
    public static void pintarMenu() {
        System.out.println("""
                ---Granja la vaca que mira con desdén---
                [1] Gestionar Ganado.
                [2] Gestionar Naves.
                [3] Gestionar Producción.
                [0] Salir.
                ----------------------------------------""");
    }

    /**
     * Precondiciones: No tiene.
     * Método que imprime por pantalla el menú y comprueba si la entrada es válida.
     * Postcondiciones: Lanza un proceso u otro según la opción elegida.
     */
    public static void menuPrincipal() {
        String menu;
        boolean salir = false;
        do {
            pintarMenu();
            menu = sc.next();
            switch (menu) {
                case "1" -> mostrarOpcionesGanado();
                case "2" -> mostrarOpcionesNaves();
                case "3" -> mostrarOpcionesProduccion();
                case "0" -> salir = true;
                default -> System.out.println("\033[93;1;4mNo es una opción válida.\033[0m");
            }
        } while (!salir);
        sc.close();
    }

    //--------------------------------------------------GANADO----------------------------------------------------------
    /**
     * Precondiciones: No tiene.
     * Método que crea la estructura del menú para imprimirla.
     * Postcondiciones: No tiene.
     */
    public static void pintarOpcionesGanado() {
        System.out.println("""
                ------Elija una tabla------
                [1] Ver lista del ganado.
                [2] Buscar Vaca.
                [3] Insertar vaquita.
                [4] Editar Vaca.
                [5] Eliminar Vaca.
                [0] Volver menu anterior.
                ---------------------------""");
    }
    /**
     * Precondiciones: No tiene.
     * Muestra el menú de opciones del ganado.
     * Postcondiciones: No tiene.
     */
    public static void mostrarOpcionesGanado() {
        String menu;
        boolean salir = false;
        do {
            pintarOpcionesGanado();
            menu = sc.next();
            switch (menu) {
                case "1" -> System.out.println("\033[93m" + Conexion.getListGanado() + "\033[0m");
                case "2" -> DAOGanado.getVaca();
                case "3" -> DAOGanado.insertarGanado();
                case "4" -> mostrarModificarGanado();
                case "5" -> DAOGanado.eliminiarVaca();
                case "0" -> salir = true;
                default -> System.out.println("\033[93;1;4mNo es una opción válida.\033[0m");
            }
        } while (!salir);
    }
    /**
     * Precondiciones: No tiene.
     * Método que crea la estructura del menú para imprimirla.
     * Postcondiciones: No tiene.
     */
    public static void pintarModificarGanado() {
        System.out.println("""
                ------Elija una tabla------
                [1] Editar Nombre.
                [2] Editar Nave.
                [3] Insertar fecha sacrificio.
                [0] Volver menu anterior.
                ---------------------------""");
    }
    /**
     * Precondiciones: No tiene.
     * Muestra el menú de actualizar el ganado.
     * Postcondiciones: No tiene.
     */
    public static void mostrarModificarGanado() {
        String menu;
        boolean salir = false;
        do {
            pintarModificarGanado();
            menu = sc.next();
            switch (menu) {
                case "1" -> DAOGanado.actualizarNombre();
                case "2" -> DAOGanado.actualizarNave();
                case "3" -> DAOGanado.actualizarFechaSacrificio();
                case "0" -> salir = true;
                default -> System.out.println("\033[93;1;4mNo es una opción válida.\033[0m");
            }
        } while (!salir);
    }

    //-------------------------------------------------NAVES------------------------------------------------------------
    /**
     * Precondiciones: No tiene.
     * Método que crea la estructura del menú para imprimirla.
     * Postcondiciones: No tiene.
     */
    public static void pintarOpcionesNaves() {
        System.out.println("""
                -----Elija una colección-----
                [1] Ver lista naves.
                [2] Buscar Nave.
                [3] Insertar Nave.
                [4] Actualizar propietario.
                [5] Eliminar Nave.
                [0] Volver menu anterior.
                -----------------------------""");
    }
    /**
     * Precondiciones: No tiene.
     * Muestra el menú de opciones de naves.
     * Postcondiciones: No tiene.
     */
    public static void mostrarOpcionesNaves() {
        String menu;
        boolean salir = false;
        do {
            pintarOpcionesNaves();
            menu = sc.next();
            switch (menu) {
                case "1" -> System.out.println("\033[94m" + Conexion.getListNaves() + "\033[0m");
                case "2" -> DAONaves.getNave();
                case "3" -> DAONaves.insertarNave();
                case "4" -> DAONaves.actualizarGanadero();
                case "5" -> DAONaves.eliminiarNave();
                case "0" -> salir = true;
                default -> System.out.println("\033[93;1;4mNo es una opción válida.\033[0m");
            }
        } while (!salir);
    }

    //---------------------------------------------PRODUCCIONES---------------------------------------------------------
    /**
     * Precondiciones: No tiene.
     * Método que crea la estructura del menú para imprimirla.
     * Postcondiciones: No tiene.
     */
    public static void pintarOpcionesProduccion() {
        System.out.println("""
                ------Elija una tabla------
                [1] Lista producción.
                [2] Insertar producción.
                [3] Producción por vaca/l.
                [4] Producción por mes/l.
                [5] Producción por año/l.
                [0] Volver menu anterior.
                ---------------------------""");
    }
    /**
     * Precondiciones: No tiene.
     * Muestra el menú de producciones.
     * Postcondiciones: No tiene.
     */
    public static void mostrarOpcionesProduccion() {
        String menu;
        boolean salir = false;
        do {
            pintarOpcionesProduccion();
            menu = sc.next();
            switch (menu) {
                case "1" -> System.out.println("\033[92m" + Conexion.getListProduccion() + "\033[0m");
                case "2" -> DAOProduccion.insertarProduccion();
                case "3" -> DAOProduccion.produccionPorVaca();
                case "4" -> DAOProduccion.produccionPorMes();
                case "5" -> DAOProduccion.produccionPorAnio();
                case "0" -> salir = true;
                default -> System.out.println("\033[93;1;4mNo es una opción válida.\033[0m");
            }
        } while (!salir);
    }
}