package exe2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;





public class Server extends Thread {
    static int n =0 ;
    static Socket s ;

    public Server(Socket s,int n){
    	super();
    	Server.n = n;
    	Server.s = s;
    }
    public void run(){
        System.out.println("Bonjour ke client numero "+n+": ");
        try{
            s.close();
        }catch(IOException e){
            System.out.println("<!> il ya un probleme <!>");
        }
           }
    
    public static void main(String args[]){
        
    	 try{
    	        try (ServerSocket ss = new ServerSocket(5555)) {
    				while(true){
    					//accept client 
    					Socket s1 = ss.accept();
    				    n+=1;
    				    Server sev = new Server(s1,n);
    				    sev.start();
    				   
    				}
    			
    	        } 
    	            
    	        }catch(IOException e){
    	            System.out.println("probleme !!!");
    	        }
    	        
    	    }
    }
           