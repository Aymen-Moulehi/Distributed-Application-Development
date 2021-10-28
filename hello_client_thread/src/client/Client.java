/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author aymen
 */
public class Client {
    public static void main(String args[]) throws IOException{
        Socket s = new Socket("localhost",5555);
        System.out.println("j ai deja connecté");
        s.close();
    }
}
