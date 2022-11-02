package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class ControllerUsuario {

    private VistaUsuario vista = new VistaUsuario();

    public ControllerUsuario (){}

    //Llama al DAO para guardar el usuario
    public void registrarUsuario (Usuario usuario){
        IUsuarioDao dao = new UsuarioDaoImpl();
        dao.actualizar(usuario);
    }

    //llama al DAO para actualizar un cliente
    public void actualizar(Usuario usuario) {
        IUsuarioDao dao = new UsuarioDaoImpl();
        dao.actualizar(usuario);
    }

    //llama al DAO para eliminar un cliente
    public void eliminar(Usuario usuario) {
        IUsuarioDao dao = new UsuarioDaoImpl();
        dao.eliminar(usuario);
    }

    //llama al DAO para obtener todos los clientes y luego los muestra en la vista
    public void verUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        IUsuarioDao dao = new UsuarioDaoImpl();
        usuarios=dao.obtener();
        vista.verUsuarios(usuarios);
    }
}
