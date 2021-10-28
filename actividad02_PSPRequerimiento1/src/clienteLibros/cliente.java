package clienteLibros;

import java.io.DataInputStream;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import servidorLibro.servidor;

public class cliente {

	public static void main(String[] args) {
		
		final String HOST= "127.0.0.1";
		
		//este puerton tiene que ser el mismo que en el servidor
		final int PUERTO = 5001;
		
		
		DataInputStream in;
		DataOutputStream out;
		
		try {
			
			Socket sc = new Socket(HOST,PUERTO);
		//creas la comunicaci�n
			
			in = new DataInputStream(sc.getInputStream());
			out = new DataOutputStream(sc.getOutputStream());
			
		//como el servidor est� esperando un mensaje m�o lo mando
			
			out.writeUTF("A la espera de realizar una petici�n........");
			
	
			//esto es para recibir un mensaje del servidor
			String mensaje = in.readUTF();
			
			System.out.println(mensaje);
			
			do {
				
				System.out.println("A continuaci�n busque el libro deseado escribiendo su : ");
				System.out.println("--ISBN");
				System.out.println("--T�tulo");
				System.out.println("Para salir escriba fin.");
				
				Scanner scn = new Scanner(System.in);
				mensaje = scn.nextLine();
				
				//lo que escribimos lo mandamos al servidor
				out.writeUTF(mensaje);	
				
				String mensaje3 = in.readUTF();
				System.out.println(mensaje3);
			
			
			//hacemos este bucle hasta que nos escriban la palabra fin
			}while (!mensaje.equalsIgnoreCase("fin"));
			
			
			
			sc.close();
			
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
