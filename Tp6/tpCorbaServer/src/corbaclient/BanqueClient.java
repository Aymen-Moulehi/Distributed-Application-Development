package corbaclient;

import javax.naming.Context;
import javax.naming.InitialContext;

import corbaBanque.IBanqueRemote;
import corbaBanque.IBanqueRemoteHelper;

public class BanqueClient {

	public static void main(String[] args) {
		try {
			/* Récupérer les propriétés de l’annuaire JNDI*/
			Context ctx = new InitialContext();
			/* Chercher la référence de l’od qui est un objet java, par la suite il faut la convertir en
			objet CORBA avec org.omg.CORBA.Object*/
			Object ref = ctx.lookup("BK");
			/* le casting de la référence en IBanqueRemote, ce qui permet de créer le stub*/
			IBanqueRemote stub= IBanqueRemoteHelper.narrow((org.omg.CORBA.Object)ref);
			
			
			
			
			
			System.out.println(stub.connversion(600));
			
		}catch(Exception e) {
			

			e.printStackTrace();
		}

	}

}
