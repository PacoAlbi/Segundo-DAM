package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class VistaUsuario {

    public void verUsuario (Usuario usuario){
        System.out.println(usuario);
    }

    public void verUsuarios (List<Usuario> usuarios){
        for (Usuario usuario: usuarios) {
            System.out.println(usuario);
        }
    }
}
