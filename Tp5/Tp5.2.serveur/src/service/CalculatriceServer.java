package service;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import serveur.CalculatriceImpl;

public class CalculatriceServer {
	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(6969);
			CalculatriceImpl cal = new CalculatriceImpl();
			
			String url = "rmi://localhost:6969/Calculatrice";
			
			Naming.rebind(url,cal);
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}


}
