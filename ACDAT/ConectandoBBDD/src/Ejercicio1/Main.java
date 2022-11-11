package Ejercicio1;

import Usuario.Usuario;

public class Main {

    public static void main(String[] args) {
        Usuario usuario = new Usuario(1,"Felipe", "Albiñana Ruiz", "paquete", "paquete@paquetin.es", "123456");

        // controlador
        ControllerUsuario controller = new ControllerUsuario();
        UsuarioDaoImpl iu = new UsuarioDaoImpl();
        VistaUsuario vu = new VistaUsuario();

        // guarda un cliente a través del controlador
        controller.registrarUsuario(usuario);

        // ver clientes
        controller.verUsuarios();

        // editar un cliente por medio del id
        usuario.setId(1);
        usuario.setNombre("Paco");
        controller.actualizar(usuario);

        // eliminar un cliente por medio de su id
        usuario.setId(1);
        controller.eliminar(usuario);
    }
}
