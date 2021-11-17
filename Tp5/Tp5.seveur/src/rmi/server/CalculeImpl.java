package rmi.server;

import java.rmi.RemoteException;

public class CalculeImpl extends java.rmi.server.UnicastRemoteObject implements ICalcule{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public CalculeImpl() throws RemoteException {
		super();
	}



	@Override
	public double produit(double x, double y) throws RemoteException {
		return x*y;
	}

}
