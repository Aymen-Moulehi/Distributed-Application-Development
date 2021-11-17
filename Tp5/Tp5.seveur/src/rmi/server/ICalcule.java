package rmi.server;

import java.rmi.Remote;

public interface ICalcule extends Remote{
	double produit(double x,double y)throws java.rmi.RemoteException ;
}
