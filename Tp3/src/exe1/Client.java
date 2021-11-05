package exe1;

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