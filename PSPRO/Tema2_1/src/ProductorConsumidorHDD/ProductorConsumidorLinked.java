package ProductorConsumidorHDD;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;

public class ProductorConsumidorLinked {

    private LinkedList<Object> lista = new LinkedList<>();

    public void producir (){
        int cantidadElementos = 0;

        synchronized (lista){
            Object nuevoElemento = new Object();
            lista.addFirst(nuevoElemento);
            cantidadElementos = lista.size();

            lista.notifyAll();
        }

        System.out.printf("Cantidad de elementos despues de la produccion: %d" + System.lineSeparator(), cantidadElementos);
    }

    public void consumir (){
        Object elemento = null;
        int cantidadElementos = 0;
        synchronized (lista){
            //mientras no se produzca, esperamos a consumir
            while (lista.size()==0){
                try {
                    lista.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            //consumo el último elemento que haya
            elemento = lista.removeLast();
            cantidadElementos = lista.size();
        }

        System.out.printf("Elemento extraido de la lista: %s" + System.lineSeparator() + "Cantidad de elementos despues del consumo %d" + System.lineSeparator(), elemento, cantidadElementos);
    }

    public static void main(String[] args) {
        ProductorConsumidorLinked pc = new ProductorConsumidorLinked();
        System.out.println("Presione p para producir, c para consumir:");
        int codigoCaracter;

        while (true){
            try {
                if (((codigoCaracter = System.in.read()) != -1)){
                    char caracter = (char) codigoCaracter;

                    switch (caracter){
                        case 'p':
                            pc.producir();
                            break;
                        case 'c':
                            pc.consumir();
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }



    }
}
