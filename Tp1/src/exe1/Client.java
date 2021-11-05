package exe1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;


public class Client {


    public static void main(String[] args) throws IOException {
        int x ;
        @SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
        try (
                
                Socket s = new Socket(InetAddress.getLocalHost(),1234)
               
                
                
             ) {
            System.out.println("je suis un client qui connecte au serveur ");
            OutputStream os  = s.getOutputStream();
            
            System.out.print("donner in nombre : ");
            x = scan.nextInt() ;
            os.write(x);
            System.out.println("donner a ete envoyer");
            
            InputStream is = s.getInputStream();
            int resualt;
            resualt = is.read();
            System.out.println("j obtient le resultat:");
            System.out.println("resulat="+resualt);
        }
        

        
        
    }
    
}