package exe3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
               
                try{
                    //Double.parseDouble
                    
                    Socket s;
                    s = new Socket("localhost",5555)  ;
                    try (Scanner scan = new Scanner(System.in)) {
						Double x ;
						Double y ;
						String op;
						System.out.println("donner le 1ere nombre :");
						x = scan.nextDouble();
						scan.nextLine();
						System.out.println("donner le 2eme nombre :");
						y = scan.nextDouble();
						scan.nextLine();
						System.out.println("donner un operateur: ");
						op = scan.nextLine();
						scan.nextLine();

						//creation d'objet
						Operateur o = new Operateur(x,y,op);
						    
						    
						    
						//envoi d'objet   
						OutputStream outputStream = s.getOutputStream();
      
						ObjectOutputStream os = new ObjectOutputStream(outputStream) ;
						    
						os.writeObject(o);
						
						
					}
                    
                    // recoit du resultat
                    InputStream is = s.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is)) ;
                    System.out.println(br.readLine());
                    s.close();
               
                    
                    
                }catch(IOException e){
                    System.out.println("il ya un probleme");
                    
                }
    }
    
}