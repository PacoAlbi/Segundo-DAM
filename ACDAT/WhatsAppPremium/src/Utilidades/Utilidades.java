package Utilidades;

import modelo.Contacto;
import modelo.Mensaje;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class Utilidades {

    // Pagina: https://codigofacilito.com/articulos/asignar-permisos-mysql

    public static final String DARPERMISO = "GRANT INSERT ON ad2223_falbinana.Mensajes TO 'ad2223_eramos'@'%';";
    public static final String QUITARPERMISO = "REVOKE ALL PRIVILEGES ON *.* FROM 'usuario'@'localhost'";






    /**
     * <b>METODO QUE PIDE LOS DATOS DEL CONTACTO POR UN JOPTIONPANE AL USUARIO Y DEVUELVE UN CONTACTO</b>
     * @return new Contacto()
     */
    public static Contacto crearContacto(){

        String idUsuario, nombre;

        idUsuario = JOptionPane.showInputDialog("Introduzca el ID del usuario");
        nombre = JOptionPane.showInputDialog("Introduzca el nombre del usuario");

        return new Contacto(idUsuario,nombre);
    }

     /**
     * <b>METODO QUE PIDE EL ID DEL CONTACTO A ELIMINAR Y LO DEVUELVE</b>
     * @return new Contacto()
     */
    public static Contacto borrarContacto(){

        String contacto=JOptionPane.showInputDialog("Indique el IdContacto que desea eliminar");

        return new Contacto(contacto);
    }
    /**
     * <b>METODO QUE PIDE EL ID DEL CONTACTO A BLOQUEAR Y LO DEVUELVE</b>
     * @return new Contacto()
     */
    public static Contacto bloquearContacto(){

        String contacto=JOptionPane.showInputDialog("Indique el IdContacto que desea Bloquear");
        return new Contacto(contacto);
    }

    /**
     * <b>FUNCION QUE DEVUELVE un nuevo mensaje</b>
     * @return new Mensaje()
     */
    public static Mensaje crearMensaje(String idContacto){

        String texto;

        texto = JOptionPane.showInputDialog("Mensaje:");

        return new Mensaje(texto,idContacto);
    }

    /**
     *
     */
    public void temporizador (){
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override public void run() {
                System.out.println("¡Ejecutando la primera vez en " +   "1 segundo y las demás cada 5 segundos!"); }
        }, 1000, 5000);
        //timer.cancel(); //detiene el temporizador.
        //timer.purge(); //elimina el temporizador.
    }
}
