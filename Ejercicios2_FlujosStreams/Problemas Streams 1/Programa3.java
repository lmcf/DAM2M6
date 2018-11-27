import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/*
Streams 1
Ejercicio3: Modifica el código anterior para que se le puede pasar el nombre del fichero
al programa.
*/

public class Programa3 {

	private static Scanner lectura;

	public static void main ( String [] args) throws IOException {
		
		System.out.println("Introduzca nombre archivo:");
		lectura = new Scanner(System.in);
		String directorio = lectura.nextLine();	
		
		char[] buf = new char[20];
		File fichero = new File (directorio);  // declaración fichero
		FileReader flu = new FileReader (fichero); // creamos flujo de entrada hacia el fichero
		while ((flu.read(buf))!=-1) {   //Vamos leyendo de 20 caracteres en 20
			System.out.print ((buf) ); //hacemos cast a char del entero leído
		}
		flu.close();
	}
}