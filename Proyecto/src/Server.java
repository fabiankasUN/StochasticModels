
import java.net.*;

import java.io.*;

public class Server {
	final int PUERTO = 5000;
	ServerSocket sc;
	Socket so;
	DataOutputStream salida;
	String mensajeRecibido;

	public void initServer() {
		BufferedReader entrada;
		try {

			boolean flag = false;
			while (true) {
				sc = new ServerSocket(PUERTO);
				so = new Socket();
				System.out.println("Esperando una conexi�n:");
				so = sc.accept();
				System.out.println("Escuchado desde : " + so.getRemoteSocketAddress());
				System.out.println("Un cliente se ha conectado.");
				entrada = new BufferedReader(new InputStreamReader(so.getInputStream()));
				salida = new DataOutputStream(so.getOutputStream());
				System.out.println("Confirmando conexion al cliente....");
				salida.writeUTF("Conexi�n exitosa...n envia un mensaje :D");
				mensajeRecibido = entrada.readLine();
				System.out.println(mensajeRecibido);
				salida.writeUTF("Se recibio tu mensaje.n Terminando conexion...");
				salida.writeUTF("Gracias por conectarte, adios!");
				System.out.println("Cerrando conexi�n...");
				//if (flag)
				
				entrada.close();
				salida.close();
				sc.close();// Aqui se cierra la conexi�n con el cliente
				break;
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public static void main(String args[]) {
		Server c = new Server();
		c.initServer();
	}

}
