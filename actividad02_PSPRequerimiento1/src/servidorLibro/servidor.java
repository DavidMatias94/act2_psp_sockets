package servidorLibro;

import java.io.DataInputStream;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class servidor {

	

	public static void main(String[] args) {
		
		Libro l1 = new Libro("3454", "ELOY MORENO", "TIERRA", 30);
		Libro l2 = new Libro("3455", "YUVAL NOAH", "SAPIENS", 40);
		Libro l3 = new Libro("3456", "JKR", "HARRY POTTER Y LA PIEDRA FILOSOFAL", 20);
		Libro l4 = new Libro("3457", "JULIO VERNE", "ESCUELA DE ROBINSONES", 20);
		Libro l5 = new Libro("3458", "ROSA MONTERO", "AMANTES Y ENEMIGOS", 15);
		
		
		
		
		List<Libro> listaNombres = new ArrayList<Libro>();
		listaNombres.add(l1);
		listaNombres.add(l2);
		listaNombres.add(l3);
		listaNombres.add(l4);
		listaNombres.add(l5);
		
		
		
		
		ServerSocket servidor = null;
		Socket sc = null;
		
		DataInputStream in;
		DataOutputStream out;
		final int PUERTO = 5001;
		
		try {
			servidor = new ServerSocket(PUERTO);
			System.out.println("ESTAMOS EN EL SERVIDOR");
			
			//el servidor estará atento a las peticiones y lo hacemos con el while true
			System.out.println("Esperando a que se conecte el cliente.............");
			
			
				
				//System.out.println("Esperando a que se conecte el cliente.............");
				
			//se queda a la espera
				sc= servidor.accept();
				
				System.out.println("Cliente conectado");
			
			//creas la comunicación
				in = new DataInputStream(sc.getInputStream());
				out = new DataOutputStream(sc.getOutputStream());
			
			//estoy esperando a que el cliente me mande algo
				String mensaje = in.readUTF();
				
				System.out.println(mensaje);
				
				out.writeUTF("Mensaje desde el servidor, hemos recibido su petición.");
				
				String mensaje3 = null;
				
				while (true) {
					
				String mensaje21 = in.readUTF();
				
				System.out.println(mensaje21);
				
				if(mensaje21.equalsIgnoreCase("3454")) {
					System.out.println(l1.toString());
					mensaje3 = l1.toString();
				}else if(mensaje21.equalsIgnoreCase("3454")) {
					System.out.println(l2.toString());
					mensaje3 = l2.toString();
				}else if(mensaje21.equalsIgnoreCase("3456")) {
					System.out.println(l3.toString());
					mensaje3 = l3.toString();
				}else if(mensaje21.equalsIgnoreCase("3457")) {
					System.out.println(l4.toString());
					mensaje3 = l4.toString();
				}else if(mensaje21.equalsIgnoreCase("3458")) {
					System.out.println(l5.toString());
					mensaje3 = l5.toString();
				}else if(mensaje21.equalsIgnoreCase("TIERRA")) {
					System.out.println(l1.toString());
					mensaje3 = l1.toString();
				}else if(mensaje21.equalsIgnoreCase("SAPIENS")) {
					System.out.println(l2.toString());
					mensaje3 = l2.toString();
				}else if(mensaje21.equalsIgnoreCase("HARRY POTTER Y LA PIEDRA FILOSOFAL")) {
					System.out.println(l3.toString());
					mensaje3 = l3.toString();
				}else if(mensaje21.equalsIgnoreCase("ESCUELA DE ROBINSONES")) {
					System.out.println(l4.toString());
					mensaje3 = l4.toString();
				}else if(mensaje.equalsIgnoreCase("AMANTES Y ENEMIGOS")) {
					System.out.println(l5.toString());
					mensaje3 = l5.toString();
				}else if(mensaje21.equalsIgnoreCase("FIN")) {
					
					mensaje3 = "Cliente desconectado";
					}
				
				
					out.writeUTF(mensaje3);	
				
				
				}
				
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
