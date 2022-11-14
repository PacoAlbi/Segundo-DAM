package Usuario;

import java.util.List;
import java.util.Scanner;

public class ControllerUsuario {

    //Llama al DAO para guardar el usuario
    public static void registrarUsuario (){
        Usuario usuario = new Usuario();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el nombre");
        usuario.setNombre(scanner.nextLine());
        System.out.println("Introduzca los apellidos");
        usuario.setApellidos(scanner.nextLine());
        System.out.println("Introduzca un nombre de usuario");
        usuario.setUsername(scanner.nextLine());
        System.out.println("Introduzca un email");
        usuario.setEmail(scanner.nextLine());
        System.out.println("Introduzca una contraseña");
        usuario.setPassword(scanner.nextLine());
        UsuarioDao.registrar(usuario);
    }

    //llama al DAO para actualizar un cliente
    public static void actualizar() {
        Usuario usuario = new Usuario();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el id de Usuario");
        usuario.setId(scanner.nextInt());
        System.out.println("Introduzca el nombre");
        usuario.setNombre(scanner.next());
        System.out.println("Introduzca los apellidos");
        usuario.setApellidos(scanner.next());
        System.out.println("Introduzca un nombre de usuario");
        usuario.setUsername(scanner.next());
        System.out.println("Introduzca un email");
        usuario.setEmail(scanner.next());
        System.out.println("Introduzca una contraseña");
        usuario.setPassword(scanner.next());
        UsuarioDao.actualizar(usuario);
    }

    //llama al DAO para eliminar un cliente
    public static void eliminar() {
        Usuario usuario = new Usuario();
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el id del usuario que desea eliminar.");
        usuario.setId(sc.nextInt());
        UsuarioDao.eliminar(usuario);
    }

    //llama al DAO para obtener todos los clientes y luego los muestra en la vista
    public static void verUsuarios(){
        List<Usuario> usuarios;
        usuarios=UsuarioDao.obtener();
        for (Usuario usuario: usuarios) {
            System.out.println(usuario);
        }
    }
}
