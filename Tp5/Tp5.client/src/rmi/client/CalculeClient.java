package rmi.client;
import java.rmi.Naming;
import java.util.Scanner;

import rmi.server.ICalcule;

public class CalculeClient {

	public static void main(String[] args) {

		try {
			double x;
			double y;
			double res;
			
			ICalcule ic = (ICalcule) Naming.lookup("rmi://localhost:2234/Calcule");
			System.out.println("donne 1");
			try (Scanner sc = new Scanner(System.in)) {
				System.out.println("donner 1ere nombre: ");
				x = sc.nextDouble();
				System.out.println("donner 2eme nombre: ");
				y = sc.nextDouble();
			}
			
			res = ic.produit(x,y);
			System.out.println("resultat = "+res);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
