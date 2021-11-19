package serveur;

import java.rmi.RemoteException;

public class CalculatriceImpl  implements ICalculatrice{
	

	double x=0;
	double y=0;
	
	public CalculatriceImpl()throws RemoteException{
		super();
	}

	public double produit() throws RemoteException {
		return x*y ;
	}

	
	public double somme() throws RemoteException {
		return x+y;
	}


	public double division() throws RemoteException {
		return x/y;
	}


	public double soustraction() throws RemoteException {
		return x-y;
	}


	public void setX(double x) {
		this.x=x;
		
	}


	public void setY(double y) {
		this.y=y;	
	}


	public double getX() {
		return x;
	}


	public double getY() {
		return y;
	}

	
}
