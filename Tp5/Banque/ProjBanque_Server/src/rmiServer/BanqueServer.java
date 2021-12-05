package rmiServer;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import rmiService.BanqueImpl;



public class BanqueServer {
	
	public static void main(String[] args) {
		
		try {
			LocateRegistry.createRegistry(2234);
			BanqueImpl bq = new BanqueImpl();
			
			String url = "rmi://localhost:2234/Banque";
			
			Naming.rebind(url,bq);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
