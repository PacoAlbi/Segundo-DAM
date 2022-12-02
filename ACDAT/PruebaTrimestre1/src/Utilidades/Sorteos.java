package Utilidades;

import DAO.AccesoBBDD;
import Entidades.Apuesta;
import Entidades.Persona;
import Entidades.Sorteo;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class Sorteos {

    private static final int PRECIO_BOLETO = 5;

    public static void main(String[] args) {

    }

    /**
     * Precondiciones: No tiene.
     * Método para realizar el sorteo y simular la cola.
     * Postcondiciones: Sorteo queda realizado y las tablas modificadas.
     */
    public static void realizarSorteo() {
        //Timer para simular la cola.
        Timer timer = new Timer();
        //Genero un sorteo y una apuesta.
        Apuesta apuesta;
        Sorteo sorteo = new Sorteo();
        //Genero los números del sorteo uno a uno del 0 al 100.
        sorteo.setNum1((int) (Math.random() * 101));
        sorteo.setNum2((int) (Math.random() * 101));
        sorteo.setNum3((int) (Math.random() * 101));
        //Saco la lista de personas de la BBDD para jugar.
        List<Persona> listaDePersonas = AccesoBBDD.obtenerPersonas();
        List<Apuesta> listaDeApuestas = new ArrayList<>();
        //Hago que tarden 200ms en apostar.
        for (Persona apostador : listaDePersonas) {
            apuesta = new Apuesta();
            //Compruebo que tenga al menos saldo para una apuesta.
            if (apostador.getSaldo() >= PRECIO_BOLETO) {
                //Random para ver si ese aportador apuesta o no. Si no sale, no apuesta.
                if (Math.random() >= 0.5) {
                    apostador.setSaldo(apostador.getSaldo() - PRECIO_BOLETO);
                    apuesta.setIdPersona(apostador.getIdPersona());
                    apuesta.setNumero((int) (Math.random() * 101));
                    sorteo.setRecaudacion(sorteo.getRecaudacion() + PRECIO_BOLETO);
                }
            }
            listaDeApuestas.add(apuesta);
        }
        //Saco el 70% para premios.
        double premios = sorteo.getRecaudacion() * 0.7;
        //Actualizo las apuestas y reparto los premios.
        for (Apuesta apuestaPorPersona : listaDeApuestas) {
            AccesoBBDD.insertarApuesta(apuestaPorPersona);
            while (premios > 0) {
                if (sorteo.getNum1() == apuestaPorPersona.getNumero()) {
                    System.out.printf("El jugador cuya id es %d ha ganado el primer premio.", apuestaPorPersona.getIdPersona());
                    double repartido = premios * 0.4 + sorteo.getBote();
                    listaDePersonas.get(apuestaPorPersona.getIdPersona()).setSaldo(repartido);
                    premios -= repartido;
                } else if (sorteo.getNum2() == apuestaPorPersona.getNumero() || sorteo.getNum3() == apuestaPorPersona.getNumero()) {
                    System.out.printf("El jugador cuya id es %d ha ganado el segundo o tercer premio.", apuestaPorPersona.getIdPersona());
                    double repartido = premios * 0.15 + sorteo.getBote();
                    listaDePersonas.get(apuestaPorPersona.getIdPersona()).setSaldo(repartido);
                    premios -= repartido;
                }
            }
        }
        sorteo.setBote(sorteo.getBote() + sorteo.getRecaudacion() + premios);
        AccesoBBDD.insertarSorteo(sorteo);
    }
}