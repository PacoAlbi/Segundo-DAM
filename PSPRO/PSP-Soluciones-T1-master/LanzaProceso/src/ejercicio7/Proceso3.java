package ejercicio7;

import java.util.Scanner;

public class Proceso3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextLine()) {
			String clase="";
			String ip = sc.nextLine();
			int primerOcteto = Integer.parseInt(ip.split("\\.")[0]);
			if(primerOcteto<=127) {
				clase="A";
			} else if(primerOcteto<=191) {
				clase="B";
			} else {
				clase="C";
			}
			System.out.println(ip + " " + clase);
		}
		
		sc.close();
	}

}
