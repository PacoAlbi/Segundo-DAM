package Utils;

import DAO.ConectarConBBDD;
import Entities.LikesEntity;
import Entities.PostsEntity;
import Entities.UsuariosEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static Scanner sc = new Scanner(System.in);
    /**
     * Precondiciones: No tiene.
     * Método que crea la estructura del menú para imprimirla.
     * Postcondiciones: No tiene.
     */
    public static void pintarMenu() {
        System.out.println("""

                ---Bienvenido a mi menú de hoy, ¿Que desea hacer?---
                [1] Mostrar Lista de Usuarios.
                [2] Mostrar Usuario.
                [3] Actualizar Usuario.
                [4] Insertar Usuario.
                [5] Borrar Usuario.
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
                case "1" -> mostrarLista();
                case "2" -> mostrarUsuario();
                case "3" -> mostrarActualizar();
                case "4" -> mostrarInsertar();
                case "5" -> mostrarBorrar();
                case "0" -> salir = true;
                default ->  System.out.println("\033[93;1;4mNo es una opción válida.\033[0m");
            }
        } while (!salir);
        sc.close();
    }
    /**
     * Método que muestra la lista de usuarios de la BBDD.
     */
    public static void mostrarLista() {
        ConectarConBBDD conexion = new ConectarConBBDD();
        conexion.abrirConexion();
        try {

        } catch (Exception e) {
            System.out.println("Error cargando la lista de la BBDD.");
        }
        conexion.cerrar();
    }
    /**
     * Método que muestra al usuario solicitado por id de la BBDD.
     */
    public static void mostrarUsuario() {
        ConectarConBBDD conexion = new ConectarConBBDD();
        conexion.abrirConexion();
        int id;
        System.out.println("Introduzca el ID del usuario que desea mostrar.");
        id = sc.nextInt();
        try {
            conexion.leer(id);
        } catch (Exception e) {
            System.out.println("Error, usuario no encontrado.");
        }
        conexion.cerrar();
    }
    /**
     * Método que inserta a un usuario en la BBDD.
     */
    public static void mostrarInsertar() {
        ConectarConBBDD conexion = new ConectarConBBDD();
        conexion.abrirConexion();
        try {
            conexion.guardar(setearUser());
        } catch (Exception e) {
            System.out.println("Error insertando al usuario, pruebe mas tarde.");
        }
        conexion.cerrar();
    }
    /**
     * Método que actualiza a un usuario de la BBDD.
     */
    public static void mostrarActualizar() {
        ConectarConBBDD conexion = new ConectarConBBDD();
        conexion.abrirConexion();
        try {
            conexion.actualizar(setearUser());
        } catch (Exception e) {
            System.out.println("Error actualizando al usuario, pruebe mas tarde.");
        }
        conexion.cerrar();
    }
    /**
     * Método que borra a un usuario de la BBDD.
     */
    public static void mostrarBorrar() {
        ConectarConBBDD conexion = new ConectarConBBDD();
        conexion.abrirConexion();
        int id;
        System.out.println("Introduzca el ID del usuario que desea borra.");
        id = sc.nextInt();
        try {
            conexion.borrar(id);
        } catch (Exception e) {
            System.out.println("Error borrando al usuario.");
        }
        conexion.cerrar();
    }
    /**
     * Método que crea un usuario y hace las preguntas para poder setearlo y mandarlo a insertar o actualizar.
     * @return Devuelve un usuario del tipo usuario.
     */
    public static UsuariosEntity setearUser(){
        String dato;
        UsuariosEntity usuario = new UsuariosEntity();
        System.out.println("Introduzca el nombre del usuario.");
        dato = sc.next();
        usuario.setNombre(dato);
        System.out.println("Introduzca los apellidos del usuario.");
        dato = sc.next();
        usuario.setApellidos(dato);
        System.out.println("Introduzca el E-mail del usuario.");
        dato = sc.next();
        usuario.setEmail(dato);
        System.out.println("Introduzca el nick del usuario.");
        dato = sc.next();
        usuario.setUsername(dato);
        System.out.println("Introduzca la password del usuario.");
        dato = sc.next();
        usuario.setPassword(dato);
        return usuario;
    }
}