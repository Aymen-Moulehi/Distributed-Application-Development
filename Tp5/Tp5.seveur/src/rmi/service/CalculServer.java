package rmi.service;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import rmi.server.CalculeImpl;


public class CalculServer {

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(2234);
			CalculeImpl cal = new CalculeImpl();
			
			String url = "rmi://localhost:2234/Calcule";
			
			Naming.rebind(url,cal);
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
