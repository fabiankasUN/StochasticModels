import java.net.*;

import java.io.*;

public class Client {
	final String HOST = "localhost";
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

}