package ejercicio7;

public class Proceso1 {

	public static void main(String[] args) {

		for (int i = 1; i <= 10; i++) {
			int octeto1 = (int) (Math.random() * 255);
			int octeto2 = (int) (Math.random() * 255);
			int octeto3 = (int) (Math.random() * 255);
			int octeto4 = (int) (Math.random() * 255);

			System.out.println(octeto1 + "." + octeto2 + "." + octeto3 + "." + octeto4);
		}
	}

}
