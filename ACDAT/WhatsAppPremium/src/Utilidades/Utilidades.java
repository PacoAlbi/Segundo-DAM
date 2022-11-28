package Utilidades;


import Controllers.ControladorContacto;
import Entidades.Contacto;
import Entidades.Mensaje;

import javax.swing.*;
import java.util.*;
import java.util.Timer;

public class Utilidades {

    // Pagina: https://codigofacilito.com/articulos/asignar-permisos-mysql

    public static final String DARPERMISO = "GRANT INSERT ON ad2223_falbinana.Mensajes TO 'ad2223_eramos'@'%';";
    public static final String QUITARPERMISO = "REVOKE ALL PRIVILEGES ON *.* FROM 'usuario'@'localhost'";
    public static Scanner sc=new Scanner(System.in);

    public static String leerDato(){
        return sc.next();
    }

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
    public static String borrarContacto(){
        return JOptionPane.showInputDialog("Indique el IdContacto que desea eliminar");
    }
    /**
     * <b>METODO QUE PIDE EL ID DEL CONTACTO A BLOQUEAR Y LO DEVUELVE</b>
     * @return new Contacto()
     */
    public static String bloquearContacto(){
        return JOptionPane.showInputDialog("Indique el IdContacto que desea bloquear");
    }

    /**
     * <b>METODO QUE PIDE EL ID DEL CONTACTO A DESBLOQUEAR Y LO DEVUELVE</b>
     * @return new Contacto()
     */
    public static String desbloquearContacto(){
        return JOptionPane.showInputDialog("Indique el IdContacto que desea desbloquear");
    }

    /**
     * <b>FUNCION QUE DEVUELVE un nuevo mensaje</b>
     * @return new Mensaje()
     */
    public static Mensaje crearMensaje(){

        String texto;

        texto = JOptionPane.showInputDialog("Mensaje:");

        return new Mensaje(texto,"falbinana");
    }

    public static int elegirBorrarMensaje () {
        System.out.println("Introduzca el Id del mensaje que quiere borrar.");
        return sc.nextInt();
    }

    public static Contacto obtenerContactoPorId (String idContacto) {
        ControladorContacto contacto = new ControladorContacto();
        Contacto encontrado = null;
        List<Contacto> listaContactos = contacto.obtenerContactos();
        for (int i = 0; i < listaContactos.size(); i++) {
            if (Objects.equals(listaContactos.get(i).getIdContacto(), idContacto)){
                encontrado = new Contacto();
                encontrado.setIdContacto(listaContactos.get(i).getIdContacto());
                encontrado.setNombre(listaContactos.get(i).getNombre());
                encontrado.setBloqueado(listaContactos.get(i).isBloqueado());
            }
        }
        return encontrado;
    }
    /**
     * ¿Como ponerlo?
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
