package ProductorConsumidorHDD;

public class Productor extends Thread {

    private final String letras = "abcdefghijklmnñopqrstuvwxyz";
    //Ponemos en ambos el buffer, para que sea lo que tenemos en comun
    private Buffer buffer;

    public Productor (){}
    public Productor (Buffer b){
        this.buffer = b;
    }

    public void run (){
        //Lo hacemos para que este siempre ejecutandose y produciendo
        while (true){
            char c = letras.charAt((int)(Math.random()*letras.length()));
            buffer.producir(c);
            System.out.printf("Depositado el caracter %s del buffer" + System.lineSeparator(), c);

            //Lo ponemos a descansar 4 segundos para hacerlo aleatorio
            try {
                sleep((int)(Math.random()*4000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
