package Filosofos;

public class Mesa {

// Se crea un array de booleanos
    private boolean[] tenedores;

    public Mesa(int numTenedores) {
        this.tenedores = new boolean[numTenedores];
    }

    public int tenedorIzquierda(int i) {
        return i;
    }

    public int tenerdorDerecha(int i) {

        if (i == 0) {
            return this.tenedores.length - 1;

        } else {
            return i - 1;
        }

    }


    public synchronized void cogerTenedores(int comensal) {
        while (tenedores[tenedorIzquierda(comensal)] || tenedores[tenerdorDerecha(comensal)]) {

            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        tenedores[tenedorIzquierda(comensal)] = true;
        tenedores[tenerdorDerecha(comensal)] = true;
    }


    public synchronized void dejarTenedores(int comensal){

        tenedores[tenedorIzquierda(comensal)] = false;
        tenedores[tenerdorDerecha(comensal)] = false;

        notifyAll();
    }

}
