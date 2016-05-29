import java.net.*;

import java.io.*;

public class Client {
	final String HOST = "192.168.43.238";
	final int PUERTO = 5000;
	Socket sc;
	DataOutputStream mensaje;
	DataInputStream entrada;

	public void initClient() {
		try {
			sc = new Socket(HOST, PUERTO);
			mensaje = new DataOutputStream(sc.getOutputStream());
			mensaje.writeUTF("hola que tal!!");
			sc.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public static void main( String args[] ){
		Client client = new Client();
		client.initClient();
	}
}