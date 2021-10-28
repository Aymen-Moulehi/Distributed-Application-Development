
package server;

import java.io.IOException;
import java.net.Socket;


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
            s.close();
        }catch(IOException e){
            System.out.println("<!> il ya un probleme <!>");
        }
    }
    
    
}
