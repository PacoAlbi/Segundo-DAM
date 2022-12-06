package Filosofos;

public class Cena {

    public Palillos palillo[];

    //Constructor.
    public Cena(){
        palillo = new Palillos[5];
        for(int i = 0; i < 5; i++){
            palillo[i] = new Palillos(i);
        }
    }

    /**
     * Método para "hacer" un paquete de palillos.
     * @param x Debe ser entero positivo.
     * @return Un array de palillos.
     */
    public Palillos cogerPalillos (int x){
        return palillo[x];
    }

    /**
     * Método para coger el palillo de la derecha.
     * @param x Debe ser entero positivo.
     * @return El número del palillo cogido.
     */
    public int palilloDerecho(int x){
        return (x+1)%5;
    }

    /**
     * Método para coger el palillo de la izquierda.
     * @param x Debe ser entero positivo.
     * @return El número del palillo cogido.
     */
    public int palilloIzquierdo(int x){
        return x;
    }
}