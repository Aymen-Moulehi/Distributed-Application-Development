package exe4;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;







public class Server extends Thread {
    
    static Socket s ;
    static int n ;
    
    public Server(Socket s){
        super();
        Server.s =s ;

    }
    
    public void run(){
      
        
        try {
        	
        	
        System.out.println("j'attend une operation de de client");
        InputStream is = s.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        System.out.println("l'objet a eté envoyer !");
            
        
        
        //deser le objet o 
        Operateur op = (Operateur) ois.readObject();
    
        Double x = op.getx();
        Double y = op.gety();
        String operation = op.getop();
            
        //verfication d'operation coté client     
        double res = 0.0;
          if(null == operation){
              System.out.println("il ya un probleme au niveau de le operateur ");
          }else switch (operation) {
              case "+":
                  res = x+y ;
                  break;
              case "-":
                  res = x-y ;
                  break;
              case "*":
                  res = x*y ;
                  break;
              case "/":
                  res = x/y ;
                  break;
              default:
                  System.out.println("il ya un probleme au niveau de le operateur ");

                  break;
          }
          
          
         System.out.println("operation effectué avec succes !");
         PrintWriter pw = new PrintWriter(s.getOutputStream());
         pw.println("le resultat est :"+res);
         pw.flush(); 
         System.out.println("resultat eté envoyeé ! ");

         s.close();
         
        
         
         
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           
  }
}
    