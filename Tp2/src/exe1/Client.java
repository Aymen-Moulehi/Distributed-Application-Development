package exe1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;



public class Client {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Double x ;
        Double y ;
        try  {
        	try (Scanner scan = new Scanner(System.in)) {
				Socket s ;
				s= new Socket("localhost",1234) ;
				System.out.println("connexion au serveur effectue !");
				//connecter au server localhost avec le port 1234
				

				PrintWriter pw ;
				pw = new PrintWriter(s.getOutputStream());
				System.out.println("donner x : ");
				
				
				x = scan.nextDouble();
				scan.nextLine();
				pw.println(x);
				pw.flush();
				System.out.println("l envoi de x est termine !");
				
				
				
				System.out.println("donner operation: ");
				String op;
				op = scan.nextLine();
				pw.println(op);
				pw.flush();
				System.out.println("l envoi de operation est termine !");
				
				
				System.out.println("donner y : ");
				y = scan.nextDouble();
				pw.println(y);
				pw.flush();
				System.out.println("l envoi de y est termine !");
				
				
				//resevoir la resultat
				
				InputStream is = s.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is)) ;
				System.out.println(br.readLine());
				

				

				
				
				
				
				s.close();
			}
            System.out.println("connection est termine !");
        }catch(IOException e){
            System.out.println("il ya un probleme au niveau client");
        }
        

        
        
    }
    
}