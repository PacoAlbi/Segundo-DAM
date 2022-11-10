package Ejemplo1;

public class RatonConcurrente extends Thread {
	private String nombre;
	private int tiempoAlimentacion;
	
	public RatonConcurrente(String nombre, int tiempoAlimentacion) {
		super();
		this.nombre = nombre;
		this.tiempoAlimentacion = tiempoAlimentacion;
	}

	public void comer() {
		try {
			System.out.printf("El ratón %s ha comenzado a alimentarse%n", nombre);
			Thread.sleep(tiempoAlimentacion * 1000);
			System.out.printf("El ratón %s ha terminado de alimentarse%n", nombre);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		this.comer();
	}
	
	public static void main(String[] args) {
		RatonConcurrente fievel = new RatonConcurrente("Fievel", 4);
		RatonConcurrente jerry = new RatonConcurrente("Jerry", 5);
		RatonConcurrente pinky = new RatonConcurrente("Pinky", 3);
		RatonConcurrente mickey = new RatonConcurrente("Mickey", 6);

		// Las prioridades se usan solo cuando hay un recurso compartido o es un monoprocesador, ya que los hilos buscan los procesadores libres. Aqui no hay cambios, ya que
		//los ratones paran porque lo digo yo, no por usar un recurso.
		pinky.setPriority(4);
		fievel.setPriority(3);
		jerry.setPriority(2);
		mickey.setPriority(1);
		
		// El método start() pertenece a la clase Thread. Por dentro, llama al método run()
		fievel.start(); 
		jerry.start();
		pinky.start();
		mickey.start();
	}

}
