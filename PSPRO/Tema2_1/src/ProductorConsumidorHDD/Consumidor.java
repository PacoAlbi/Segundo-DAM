package ProductorConsumidorHDD;

public class Consumidor extends Thread {

    //Ponemos en ambos el buffer, para que sea lo que tenemos en comun
    private Buffer buffer;

    public Consumidor (){}
    public Consumidor (Buffer b){
        this.buffer = b;
    }

    public void run (){
        //Lo hacemos para que este siempre ejecutándose y consumiendo
        while (true){
            char c = this.buffer.consumir();
            System.out.printf("Recogido el carácter %s del buffer" + System.lineSeparator(), c);
            //Lo ponemos a descansar 4 segundos para hacerlo aleatorio
            try {
                sleep((int)(Math.random()*4000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
