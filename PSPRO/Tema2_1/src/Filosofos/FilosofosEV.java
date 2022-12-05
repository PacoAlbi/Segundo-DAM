package Filosofos;

public class FilosofosEV extends Thread{

    private Mesa mesa;

    private int comensal;

    private int indiceComensal;

    public FilosofosEV (Mesa m, int comensal){

        this.mesa=m;
        this.comensal=comensal;
        this.indiceComensal=comensal -1;
    }

    public void run(){

        while (true){
            this.pensando();
            this.mesa.cogerTenedores(indiceComensal);
            this.comiendo();
            System.out.println("Filosofo "+ comensal + " deja de comer, tenedores libres "+(this.mesa.tenedorIzquierda(indiceComensal)+1)+", "+(this.mesa.tenerdorDerecha(indiceComensal)+1));
            this.mesa.dejarTenedores(indiceComensal);
        }
    }

    public void pensando(){
        System.out.println("El filosofo "+ comensal + " esta pensando");
        try {
            sleep((long) (Math.random()*4000));
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }


    public void comiendo(){

        System.out.println("El filosofo "+ comensal + " esta comiendo");
        try {
            sleep((long) (Math.random()*4000));
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
