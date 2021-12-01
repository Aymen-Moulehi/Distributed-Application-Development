package serveur;

import java.rmi.Remote;

public interface ICalculatrice extends Remote {
	double produit()throws java.rmi.RemoteException ;
	double somme()throws java.rmi.RemoteException ;
	double division()throws java.rmi.RemoteException ;
	double soustraction()throws java.rmi.RemoteException ;
	void setX(double x)throws java.rmi.RemoteException ;
	void setY(double y)throws java.rmi.RemoteException ;
	double getX()throws java.rmi.RemoteException ;
	double getY()throws java.rmi.RemoteException ;
}
