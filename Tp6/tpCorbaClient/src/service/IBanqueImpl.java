package service;

import corbaBanque.IBanqueRemoteOperations;
import corbaBanque.IBanqueRemotePOA;

public class IBanqueImpl  extends IBanqueRemotePOA implements IBanqueRemoteOperations{

	@Override
	public double connversion(double montant) {
		
		return montant*3.8;
	}

}
