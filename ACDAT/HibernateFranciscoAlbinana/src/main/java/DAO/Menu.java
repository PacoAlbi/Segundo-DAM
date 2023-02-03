package DAO;

import Entities.Ciudadania;
import Entities.Matrimonios;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    /**
     * Atributos de la clase.
     */
    private static Scanner sc = new Scanner(System.in);
    /**
     * Precondiciones: No tiene.
     * Método que crea la estructura del menú para imprimirla.
     * Postcondiciones: No tiene.
     */
    public static void pintarMenu() {
        System.out.println("""

                ---Bienvenido al censo de ciudadanos, ¿Que desea hacer?---
                [1] Insertar Nacimiento.
                [2] Insertar Matrimonio.
                [3] Insertar una muerte :(.
                [4] Insertar un divorcio :(.
                [5] Listas varias.
                [0] Salir.
                ----------------------------------------------------""");
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
                case "1" -> Nacimiento(idPadre, idMadre, nombre, apellidos);
                case "2" -> Matrimonio(conyuge1, conyuge2, fechaMatrimonio);
                case "3" -> Deceso(id, fechaDeceso);
                case "4" -> Divorcio(id, fechaDivorcio);
                case "5" -> System.out.println("En construcción");
                case "0" -> salir = true;
                default ->  System.out.println("\033[93;1;4mNo es una opción válida.\033[0m");
            }
        } while (!salir);
        sc.close();
    }

    /**
     * Precondiciones: Debe recibir datos válidos.
     * Método para insertar un nacimiento.
     * Postcondiciones: Inserta un nacimiento.
     * @param idPadre Ciudadania idPadre
     * @param idMadre Ciudadania idMadre
     * @param nombre String nombre
     * @param apellidos String apellidos
     */
    private static void Nacimiento(Ciudadania idPadre, Ciudadania idMadre, String nombre, String apellidos){
        Conection con = new Conection();
        Ciudadania nacimiento = new Ciudadania(idPadre, idMadre, nombre, apellidos);
        con.guardar(nacimiento);
        con.cerrar();
    }

    /**
     * Precondiciones: Debe recibir datos válidos.
     * Método para insertar un matrimonio.
     * Postcondiciones: Inserta un matrimonio.
     * @param conyuge1 Ciudadania conyuge1
     * @param conyuge2 Ciudadania conyuge2
     * @param fechaMatrimonio LocalDate fechaMatrimonio
     */
    private static void Matrimonio(Ciudadania conyuge1, Ciudadania conyuge2, LocalDate fechaMatrimonio){
        Conection con = new Conection();
        Matrimonios matrimonio = new Matrimonios(conyuge1, conyuge2, fechaMatrimonio);
        con.guardar(matrimonio);
        con.cerrar();
    }

    /**
     * Precondiciones: Debe recibir datos válidos.
     * Método para actualizar la fecha de la muerte de un ciudadano.
     * Postcondiciones: Actualiza una muerte.
     * @param id int id
     * @param fechaDeceso LocalDate fechaDeceso
     */
    private static void Deceso(int id, LocalDate fechaDeceso){
        Conection con = new Conection();
        Ciudadania muerto = new Ciudadania(id, fechaDeceso);
        con.actualizarMuerte(muerto);
        con.cerrar();
    }

    /**
     * Precondiciones: Debe recibir datos válidos.
     * Método para insertar un divorcio.
     * Postcondiciones: Actualiza un divorcio.
     * @param id int id
     * @param fechaDivorcio LocalDate fechaDivorcio
     */
    private static void Divorcio(int id, LocalDate fechaDivorcio){
        Conection con = new Conection();
        Matrimonios divorcio = new Matrimonios(id, fechaDivorcio);
        con.actualizarDivorcio(divorcio);
        con.cerrar();
    }

}
