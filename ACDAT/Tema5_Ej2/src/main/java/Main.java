import DAO.ConectarConBBDD;
import Entities.LikesEntity;
import Entities.PostsEntity;
import Entities.UsuariosEntity;

import java.util.ArrayList;
import java.util.List;

import static Utils.Menu.*;

public class Main {
    public static void main(String[] args) throws Exception {
        //menuPrincipal();
        ConectarConBBDD conexion = new ConectarConBBDD();
//        List<PostsEntity> listaPost = new ArrayList<>();
//        List<LikesEntity> listaLikes = new ArrayList<>();
        conexion.abrirConexion();
        UsuariosEntity usuarioPrueba = new UsuariosEntity(2,"Pedro","Sanchez Julai","aadderson0","tOLWSQh33Kz9","aiston0@sciencedirect.com");
//        PostsEntity potsPrueba = new PostsEntity(usuarioPrueba,"2021-10-19","2022-03-25");
//        listaPost.add(potsPrueba);
//        LikesEntity likePrueba = new LikesEntity(usuarioPrueba,listaPost);
//        listaLikes.add(likePrueba);
//        usuarioPrueba.setListaLikes(listaLikes);
//        usuarioPrueba.setListaPosts(listaPost);
//        conexion.guardar(usuarioPrueba);
        //conexion.leer(4);
        conexion.actualizar(usuarioPrueba);
        //conexion.borrar(4);
        conexion.cerrar();

    }
}
