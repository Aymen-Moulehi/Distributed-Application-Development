package rmiClient;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import metier.Compte;
import rmiService.IBanque;

public class BanqueClient {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		IBanque st = (IBanque) Naming.lookup("rmi://localhost:2234/Banque");
		st.creerCompte(new Compte(1,266.0));
		System.out.println(st.getInfoCompte(1));

	}

}
