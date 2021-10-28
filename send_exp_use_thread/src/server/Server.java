package server ;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aymen
 */
public class Server {
    public static void main(String args[]) throws IOException{
    int n = 0;
    @SuppressWarnings("resource")
	ServerSocket ss = new ServerSocket(5555);
    while(true){
        try {
            Socket s = ss.accept();
            n += 1 ;
            ClientProcess cp = new ClientProcess(s,n);
            cp.start();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
}
        
    }

    
    
    
    
}