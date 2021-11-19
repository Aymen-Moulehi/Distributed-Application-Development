package service;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import serveur.CalculatriceImpl;

public class CalculatriceServer {
	public static void main(String[] args) {
		try {
			CalculatriceImpl cal = new CalculatriceImpl();
			
			Remote sk= UnicastRemoteObject.exportObject(cal, 0); 
			
			
			
			LocateRegistry.createRegistry(6969)	;
			
			
			
			Naming.rebind("rmi://localhost:6969/Calculatrice",sk);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}


}
