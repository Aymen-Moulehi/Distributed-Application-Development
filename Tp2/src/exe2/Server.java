package exe2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.script.ScriptException;


public class Server {

    public static void main(String[] args) throws IOException, ScriptException {
        ServerSocket ss ;
        Socket s ;
       
        
        
        System.out.println("je suis un serveur qui attend la connection d'un client");
        ss = new ServerSocket(1234);
        s=ss.accept();
        System.out.println("un client est conncter");
        System.out.println("attend des donner par le client");
        
        //ce deux ligne permet de lire un chaine carectre donner par le client
        //stocker dans un buffer dans notre cas c'est br
        InputStream is = s.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is)) ;
        


        String[] tab = new String[3];
        String exp = br.readLine();
        tab = exp.split(" ");
        Double x = Double.parseDouble(tab[0]);
        Double y = Double.parseDouble(tab[2]);
        String op = tab[1];



        
        Double res = 0.0 ;
        if(null == op){
            System.out.println("il ya un probleme au niveau de le operateur ");
        }else switch (op) {
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
        
        
        PrintWriter pw ;
        pw = new PrintWriter(s.getOutputStream());
        pw.println("le resultat est :"+res);
        pw.flush();
    
        
        ss.close();
        s.close();
    }
    
}