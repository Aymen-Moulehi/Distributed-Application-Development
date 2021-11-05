package exe1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {


    public static void main(String[] args) throws IOException {
        ServerSocket ss ;
        Socket s ;
        System.out.println("je suis un serveur qui attend la connection d'un client");
        ss = new ServerSocket(1234);
        s=ss.accept();
        System.out.println("un client est conncter");
        System.out.println("attend des donner par le client");
        InputStream is = s.getInputStream();
        int x  = is.read() ;
        
        
        
        System.out.println("la valeur donner par le client est :"+ x);
        OutputStream os = s.getOutputStream();
        int res = x * 8 ;
        System.out.println("envoi de donner vers le client : "+res);
        os.write(res);
        
        ss.close();
        s.close();
    }
    
}