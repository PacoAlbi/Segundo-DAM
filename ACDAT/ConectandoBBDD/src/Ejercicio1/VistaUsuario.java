package Ejercicio1;

import Usuario.Usuario;

import java.util.List;

public class VistaUsuario {

    public static void verUsuario (Usuario usuario){
        System.out.println(usuario);
    }

    public static void verUsuarios (List<Usuario> usuarios){
        for (Usuario usuario: usuarios) {
            System.out.println(usuario);
        }
    }
}
