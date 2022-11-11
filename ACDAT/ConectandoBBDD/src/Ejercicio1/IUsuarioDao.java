package Ejercicio1;

import Usuario.Usuario;

import java.util.List;

public interface IUsuarioDao {
    //Métodos de la interfaz para el CRUD
    boolean registrar (Usuario usuario);
    List<Usuario> obtener();
    boolean actualizar (Usuario usuario);
    boolean eliminar (Usuario usuario);
}
