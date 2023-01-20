import DAO.ConectarConBBDD;
import Entities.LikesEntity;
import Entities.PostsEntity;
import Entities.UsuariosEntity;

import static Utils.Menu.*;

public class Main {
    public static void main(String[] args) throws Exception {
        //menuPrincipal();
        ConectarConBBDD conexion = new ConectarConBBDD();
        conexion.abrirConexion();
        UsuariosEntity usuarioPrueba = new UsuariosEntity();
        PostsEntity potsPrueba = new PostsEntity();
        LikesEntity likePrueba = new LikesEntity();




    }
}
