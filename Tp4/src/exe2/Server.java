package exe2;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

class Server{ 
	
  final static int port = 8532; 
  //port de serveur
  final static int taille = 1024; 
  //taille de buffer en octet
  final static byte buffer[] = new byte[taille];
  //buffer 
  
  
  
  public static void main(String argv[]) throws Exception 
    { 
      try (DatagramSocket socket = new DatagramSocket(port)) {
		while(true) 
		  { 
			//recoit des donnees du client
		    DatagramPacket receivePacket = new DatagramPacket(buffer,buffer.length); 
		    socket.receive(receivePacket); 
		    System.out.println("____________Client Information____________");
		    System.out.println("IP: "+receivePacket.getAddress()); 
		    System.out.println("Port: "+receivePacket.getPort()); 
		    System.out.println("Packet Msg: "+ new String(receivePacket.getData())); 
		    
		    
		    
		    String response = "votre resultat: "+new String(receivePacket.getData()).toUpperCase() ;
		    //envoi du données
		    byte[] res = response.getBytes();
		    DatagramPacket responsePacket = new DatagramPacket(res,res.length,receivePacket.getAddress(),receivePacket.getPort());
		    socket.send(responsePacket);
		  }
		
	} 
    } 
}