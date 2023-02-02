package Vacas.DAL;

import Entities.VQ_Ganado;
import Entities.VQ_Naves;

import javax.persistence.Query;
import javax.swing.text.html.parser.Entity;
import java.io.Serializable;
import java.util.List;

public class DAL {



    public static void mostrarRegistroConString(String ruta, String parametro, String valor) {

        Connection conexion = new Connection();
        conexion.abrirSesion();
        try{
            List lista = conexion.session.getNamedQuery(ruta).setParameter(parametro, valor).getResultList();

            for (int i = 0; i < lista.size(); i++) {
                System.out.println(lista.get(i).toString());
            }
        }catch(Exception e){
            throw e;
        }
    }



    public static void mostrarRegistroConEntero(String ruta, String parametro, int valor) {

 Connection conexion = new Connection();
        conexion.abrirSesion();
        try{
            List lista = conexion.session.getNamedQuery(ruta).setParameter(parametro, valor).getResultList();

            for (int i = 0; i < lista.size(); i++) {
                System.out.println(lista.get(i).toString());
            }
        }catch(Exception e){
            throw e;
        }


    }
    public static void mostrarRegistroDobles(String ruta, String parametro, int valor, String parametro2, int valor2) {

        Connection conexion = new Connection();
        conexion.abrirSesion();
        try{
            Query query = conexion.session.getNamedQuery(ruta);

            query.setParameter(parametro, String.valueOf(valor)).setParameter(parametro2, String.valueOf(valor2));

            List lista = query.getResultList();

            for (int i = 0; i < lista.size(); i++) {
                System.out.println(lista.get(i).toString());
            }
        }catch(Exception e){
            throw e;
        }
    }
    public static void mostrarRegistro(String ruta) {

        Connection conexion = new Connection();
        conexion.abrirSesion();
        try{
            List lista = conexion.session.getNamedQuery(ruta).getResultList();

            for (int i = 0; i < lista.size(); i++) {
                System.out.println(lista.get(i).toString());
            }
        }catch(Exception e){
            throw e;
        }


    }

    public static Object mostrarPorId(String ruta, String parametro, int valor) {

        Connection conexion = new Connection();
        conexion.abrirSesion();
        return conexion.session.getNamedQuery(ruta).setParameter(parametro, valor).getSingleResult();

    }



    /**
     * Método que abre una sesion de conexion con Hibernate
     * y realiza las llamadas necesarias para guardar
     * un registro en su tabla correspondiente.
     *
     * @param objeto
     * @return
     */

    public static Object guardar(Object objeto){
        Connection cnn = new Connection();
        cnn.abrirSesion();
        Object o = cnn.session.save(objeto);
        cnn.cerrarSesion();
        return o;
    }


    public static void borrar(int id){
        Connection cnn = new Connection();
        cnn.abrirSesion();
        //UsuariosEntity usuario = sesion.get(UsuariosEntity.class,id);
        Object o =  cnn.session.get(VQ_Naves.class, id);
        cnn.session.delete(o);
        cnn.cerrarSesion();
    }

    public static void borrar2(Object objeto){
        Connection cnn = new Connection();
        cnn.abrirSesion();
        cnn.session.remove(objeto);
        cnn.cerrarSesion();
    }

    public static void actualizarGuardar (Object objeto){
        Connection cnn = new Connection();
        cnn.abrirSesion();
        cnn.session.saveOrUpdate(objeto);
        cnn.cerrarSesion();
    }
}