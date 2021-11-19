package rmiService;

import java.rmi.RemoteException;
import java.util.Vector;

import metier.Compte;

public class BanqueImpl extends java.rmi.server.UnicastRemoteObject implements IBanque {
	public static Vector<Compte> comptes = new Vector<Compte>();
	public BanqueImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void creerCompte(Compte c) throws RemoteException {
		comptes.add(c);
		
	}

	@Override
	public Compte consulterCompte(int code) throws RemoteException {
		for(int i = 0; i<comptes.size();i++) {
			if(comptes.get(i).getCode() == code)
				return comptes.get(i);
		}
		return null;
	}

	@Override
	public String getInfoCompte(int code) throws RemoteException {
		for(int i = 0; i<comptes.size();i++) {
			if(comptes.get(i).getCode() == code)
				return "code: "+comptes.get(i).getCode()+" solde: "+comptes.get(i).getSolde()+"date de creation: "+comptes.get(i).getDate();
		}
		return null;
	}

	@Override
	public Vector<Compte> getComptes() throws RemoteException {
		return comptes ;
	}

	@Override
	public double convertirMontant(double mt) throws RemoteException {
		return mt * 3 ;
	}

}
