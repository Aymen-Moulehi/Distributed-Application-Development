/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;




/**
 *
 * @author aymen
 */
public class Server2 extends Thread {
    int n =0 ;
    
    @Override
    public void run(){
            try{
           ServerSocket ss = new ServerSocket(5555);
           while(true){
               Socket s = ss.accept();
               n += 1 ;
               new ClinetProccess2(s,n).start();
           } 
               
           }catch(IOException e){
               System.out.println("probleme !!!");
           }
           }
    
    public static void main(String args[]){
        
        new Server2().start();
        
    }
           }
