package Controllers;

import Utilidades.Menu;
import dao.ContactosDAO;
import modelo.Contacto;

public class ControladorContacto {

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
    public void bloquearContacto(Contacto contacto){

        ContactosDAO contactosDAO = new ContactosDAO();
        contactosDAO.bloquearContactoDAO(contacto);
    }

}
