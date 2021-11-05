package exe1;
import java.util.Scanner;
import java.net.*;


public class Client { 
  final static int taille = 1024; 
  final static byte buffer[] = new byte[taille];

  public static void main(String argv[]) throws Exception 
    { 
	  @SuppressWarnings("resource")
	  Scanner scanner = new Scanner(System.in);
      InetAddress serveur = InetAddress.getByName("localhost"); 
      System.out.println("Donner votre nom: ");
      String ch = scanner.nextLine();
      int length = ch.length(); 
      byte buffer[] = ch.getBytes(); 
      
      DatagramPacket dataSent = new DatagramPacket(buffer,length,serveur,Server.port); 
      
      try (DatagramSocket socket = new DatagramSocket()) {
		socket.send(dataSent); 
		DatagramPacket dataRecieved = new DatagramPacket(new byte[taille],taille); 
		socket.receive(dataRecieved); 
		System.out.println("Data recieved : " + new String(dataRecieved.getData())); 
	} 
    } 
}