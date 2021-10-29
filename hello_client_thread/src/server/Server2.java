/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;





public class Server2 extends Thread {
    static int n =0 ;
    static Socket s ;

    public Server2(Socket s,int n){
    	super();
    	Server2.n = n;
    	Server2.s = s;
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
    				    Server2 sev = new Server2(s1,n);
    				    sev.start();
    				   
    				}
    			
    	        } 
    	            
    	        }catch(IOException e){
    	            System.out.println("probleme !!!");
    	        }
    	        
    	    }
    }
           

