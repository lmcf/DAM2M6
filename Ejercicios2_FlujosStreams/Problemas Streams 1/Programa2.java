import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/*
Streams 1
Ejercicio2: Modifica el código anterior para que el programa vaya leyendo caracteres de
20 en 20.
*/

public class Programa2 {
	public static void main ( String [] args) throws IOException {
		char[] buf = new char[20];
		File fichero = new File ("Programa2.java");  // declaración fichero
		FileReader flu = new FileReader (fichero); // creamos flujo de entrada hacia el fichero
		while ((flu.read(buf))!=-1) {   //Vamos leyendo de 20 caracteres en 20
			System.out.print ((buf) ); //hacemos cast a char del entero leído

		}
		flu.close();
	}
}