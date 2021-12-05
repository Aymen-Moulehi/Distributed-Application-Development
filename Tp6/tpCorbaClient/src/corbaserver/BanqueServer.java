package corbaserver;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import service.IBanqueImpl;

public class BanqueServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			/* Initialiser le middleware CORBA*/
			ORB orb = ORB.init(args, null);
			/*dans un serveur corba il faut activer le PAOManager */
			POA poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			poa.the_POAManager().activate();
			/* création de l’objet distant */
			IBanqueImpl  od = new IBanqueImpl  ();
			/* publication de l’objet dans l’annuaire */
			Context ctx = new InitialContext();
			ctx.rebind("BK", poa.servant_to_reference(od));
			/* démarrer le serveur */
			orb.run();
			
		}catch(Exception e) {
			e.printStackTrace();		
			}

	}

}
