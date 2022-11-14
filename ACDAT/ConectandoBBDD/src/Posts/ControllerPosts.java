package Posts;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ControllerPosts {

    //Llama al DAO para guardar el usuario
    public static void registrarPost (){
        Posts post = new Posts();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el idUsuario");
        post.setIdUsuarios(scanner.nextInt());
        System.out.println("Introduzca la fecha de creación");
        post.setCreated_at(scanner.next());
        System.out.println("Introduzca la fecha de actualización");
        post.setUpdated_at(scanner.next());
        PostsDao.registrar(post);
    }

    //llama al DAO para actualizar un cliente
    public static void actualizarPost() {
        Posts post = new Posts();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el post que desea actualizar");
        post.setIdPosts(scanner.nextInt());
        System.out.println("Introduzca el idUsuario");
        post.setIdUsuarios(scanner.nextInt());
        System.out.println("Introduzca la fecha de creación");
        post.setCreated_at(scanner.next());
        System.out.println("Introduzca la fecha de actualización");
        post.setUpdated_at(scanner.next());
        PostsDao.actualizar(post);
    }

    //llama al DAO para eliminar un cliente
    public static void eliminar() {
        Posts post = new Posts();
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el id del post que desea eliminar.");
        post.setIdPosts(sc.nextInt());
        PostsDao.eliminar(post);
    }

    //llama al DAO para obtener todos los clientes y luego los muestra en la vista
    public static void verPosts(){
        List<Posts> posts;
        posts= PostsDao.obtener();
        for (Posts post: posts) {
            System.out.println(post);
        }
    }
}
