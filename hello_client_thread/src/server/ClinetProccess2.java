/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aymen
 */
public class ClinetProccess2 extends Thread {
    Socket s;
    int n ;
    public ClinetProccess2 (Socket s,int n){
        this.s=s;
        this.n = n ;
        
    }
    @Override
    public void run(){
        System.out.println("le client numero "+n +"est connecte");
        try {
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(ClinetProccess2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
