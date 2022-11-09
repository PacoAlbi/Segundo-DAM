package ejercicio7;

import java.util.Scanner;

public class Proceso2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=1; i<=10; i++) {
			String ip = sc.nextLine();
			String[] ipArray = ip.split("\\.");			
			int primerOcteto = Integer.parseInt(ipArray[0]);
			if(primerOcteto<=223) {
				System.out.println(ip);
			}
		}
		sc.close();
	}

}
