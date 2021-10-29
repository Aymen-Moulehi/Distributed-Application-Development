/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


import client.Operateur;




public class Server2 extends Thread {
    
    static Socket s ;
    static int n ;
    
    public Server2(Socket s){
        super();
        Server2.s =s ;

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
    
    
    
    
    
    
    
    
    
    public static void main(String args[]){
        try{
        try (ServerSocket ss = new ServerSocket(5555)) {
			while(true){
				//accept client 
				Socket s1 = ss.accept();
			    //strat thread
			     
			    Server2 sev = new Server2(s1);
			    sev.start();
			   
			}
		
        } 
            
        }catch(IOException e){
            System.out.println("probleme !!!");
        }
        
    }
           }
