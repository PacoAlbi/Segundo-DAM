package Controllers;

import Dao.ContactosDAO;
import Entidades.Contacto;

import java.util.List;

public class ControladorContacto {

    /**
     * <b>METODO QUE LLAMA AL obtenerContactoDAO() PARA OBTENER DEL DAO UNA LISTA DE CONTACTOS DE LA BBDD</b>
     * @return List de contactos
     */
    public List<Contacto> obtenerContactos () {
        ContactosDAO contactosDAO = new ContactosDAO();
        return contactosDAO.obtenerContactosDAO();
    }

    /**
     * <b>METODO QUE LLAMA AL registrarContactoDAO() DEL DAO PARA INSERTAR UN CONTACTO EN LA BBDD</b>
     * @param contacto Recibe un contacto a insertar.
     */
    public void insertarContacto(Contacto contacto){
        ContactosDAO contactosDAO = new ContactosDAO();
        contactosDAO.registrarContactoDAO(contacto);
    }


    /**
     * <b>METODO QUE LLAMA AL eliminarContactosDAO() DEL DAO PARA MANDARLE UN CONTACTO A ELIMINAR COMO PARAMETRO</b>
     * @param idContacto Recibe el id del contacto a eliminar.
     */
    public void eliminarContacto(String idContacto){
        ContactosDAO contactosDAO = new ContactosDAO();
        contactosDAO.eliminarContactoDAO(idContacto);
    }


    /**
     * <b>METODO QUE LLAMA AL bloquearContactoDAO() DEL DAO PARA MANDARLE UN CONTACTO A BLOQUEAR COMO PARAMETRO</b>
     * @param contacto Recibe un contacto a bloquear.
     */
    public void bloquearContacto(String contacto){
        ContactosDAO contactosDAO = new ContactosDAO();
        contactosDAO.bloquearContactoDAO(contacto);
    }

    /**
     * <b>METODO QUE LLAMA AL desbloquearContactoDAO() DEL DAO PARA MANDARLE UN CONTACTO A DESBLOQUEAR COMO PARAMETRO</b>
     * @param contacto Recibe un contacto a desbloquear.
     */
    public void desbloquearContacto(String contacto){
        ContactosDAO contactosDAO = new ContactosDAO();
        contactosDAO.desbloquearContactoDAO(contacto);
    }

}
