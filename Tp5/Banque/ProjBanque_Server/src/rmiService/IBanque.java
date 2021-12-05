package rmiService;

import java.rmi.Remote;
import java.util.Vector;

import metier.Compte;

public interface IBanque  extends Remote{
	
	
	void creerCompte(Compte c)throws java.rmi.RemoteException;
	Compte consulterCompte (int code)throws java.rmi.RemoteException;
	String getInfoCompte(int code)throws java.rmi.RemoteException;
	Vector<Compte> getComptes()throws java.rmi.RemoteException;
	double convertirMontant(double mt)throws java.rmi.RemoteException;

}
