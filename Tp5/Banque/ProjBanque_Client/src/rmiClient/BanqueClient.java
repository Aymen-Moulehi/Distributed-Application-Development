package rmiClient;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.Vector;

import metier.Compte;
import rmiService.IBanque;

public class BanqueClient {
	
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		try (Scanner scanner = new Scanner(System.in)) {
			IBanque st = (IBanque) Naming.lookup("rmi://localhost:2234/Banque");
			int code ;
			Compte c;
			
			double montant ;
			//st.creerCompte(new Compte(1,266.0));
			boolean valide = true ;
			while(valide) {
				System.out.println("\n\n1)consulter compte");
				System.out.println("2)afficher liste des comptes");
				System.out.println("3)convertir montant");
				System.out.println("4)ajouter un compte");
				System.out.println("5)exit");
				System.out.println("tapez votre choix: ");
				int choix = scanner.nextInt();
				   switch(choix){
				   
			       case 1: 
			           System.out.println("donner le code de client: ");
			           code = scanner.nextInt();
			           c = st.consulterCompte(code);
			           if(c != null) {
			        	   System.out.println("compte est existe : )");
			        	   System.out.println(c.toString());
			           }
			           break;
			   
			       case 2:
			           System.out.println("______liste des comptes_____");
			           Vector<Compte> comptes = st.getComptes() ;
			           for(int i=0;i<comptes.size();i++) {
			        	   System.out.println(i+") "+comptes.get(i).toString());
			           }
			           break;
			   
			       case 3:
			           System.out.println("donner le montant pour le convertir: ");
			           montant = scanner.nextDouble();
			           montant = st.convertirMontant(montant);
			           
			           System.out.println("la resultat est : "+montant);
			           
			           break;
			       case 4:
			           System.out.println("donner le code de client: ");
			           code = scanner.nextInt() ;
			           System.out.println("donner le montant de client: ");
			           montant = scanner.nextDouble();
			           c = new Compte(code,montant);
			           st.creerCompte(c);
			           
			           break;
			       case 5:
			           valide = false ;
			           break;
			       default:
			           System.out.println("Choix incorrect");
			           break;
			   }

			}
		}
			
		}

	}


