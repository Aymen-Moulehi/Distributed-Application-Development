package exe2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


/**
 *
 * @author aymen
 */
public class Client {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {


        String exp ;
        try  {

            Socket s ;
            s= new Socket("localhost",1234) ;
            System.out.println("connexion au serveur effectue !");
            //connecter au server localhost avec le port 1234
           
            
            try (Scanner scan = new Scanner(System.in)) {
				System.out.println("dooner une expression se forme x op y avec op = +,-,*,/: ");
				exp = scan.nextLine();
			}
            PrintWriter pw ;
            pw = new PrintWriter(s.getOutputStream());
            pw.println(exp);
            pw.flush();
            InputStream is = s.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is)) ;
            System.out.println(br.readLine());



            s.close();
            System.out.println("connection est termine !");
        }catch(IOException e){
            System.out.println("il ya un probleme au niveau client");
        }
        

        
        
    }
    
}