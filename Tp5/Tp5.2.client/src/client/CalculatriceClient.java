package client;

import java.rmi.Naming;
import java.util.Scanner;

import serveur.ICalculatrice;


public class CalculatriceClient {
	
	public static void main(String[] args) {

		try {
			double x;
			double y;
			double res=0;
			
			ICalculatrice ic = (ICalculatrice) Naming.lookup("rmi://localhost:6969/Calculatrice");
			System.out.println("donne 1");
			try (Scanner sc = new Scanner(System.in)) {
				System.out.println("donner 1ere nombre: ");
				x = sc.nextDouble();
				ic.setX(x);
				System.out.println("donner 2eme nombre: ");
				y = sc.nextDouble();
				ic.setY(y);
				System.out.println("donner l'operateur: ");
				char op = sc.next().charAt(0);
				sc.nextLine();
				if(op == '*') {
					res = ic.produit();
				}else if(op == '/'){
					res = ic.division();
				}else if(op == '+'){
					res = ic.somme() ;
				}else if(op == '-') {
					res = ic.soustraction();
				}else {
					System.out.println("operateur non definie");
				}
				
				System.out.println("votre resultat est : "+res);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
