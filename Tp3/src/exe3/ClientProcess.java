package exe3;


import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClientProcess extends Thread {
   
    
    Socket s ;
    int n ;
    public ClientProcess(Socket s,int n){
        super();
        this.s = s;
        this.n = n;
    }
    
    
    @Override
    public void run(){
        System.out.println("Bonjour ke client numero "+n+": ");
        try{
                System.out.println("j'attend une operation de de client");
                InputStream is = s.getInputStream();
                ObjectInputStream ois = new ObjectInputStream(is);
                System.out.println("l'objet a eté envoyer !");
                
                

               Operateur op = (Operateur) ois.readObject();
        
            Double x = op.getx();
            Double y = op.gety();
            String operation = op.getop();
                
                
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
        }catch(IOException e){
            System.out.println("<!> il ya un probleme <!>");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}