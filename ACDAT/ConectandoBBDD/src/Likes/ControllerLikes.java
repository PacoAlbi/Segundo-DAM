package Likes;

import Usuario.Usuario;
import Usuario.UsuarioDao;

import java.util.List;
import java.util.Scanner;

public class ControllerLikes {

    public static void eliminar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba el ID de usuario a borrar sus likes");
        LikesDao.eliminar(sc.nextInt());
    }

    public static void verLikes (){
        List<Likes> likelist;
        likelist= LikesDao.obtener();
        for (Likes likes: likelist) {
            System.out.println(likes);
        }
    }
}
