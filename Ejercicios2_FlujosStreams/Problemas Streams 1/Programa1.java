import java.io.*;
/*
Streams 1
Eejrcicio1: Prueba el código anterior
*/

public class Programa1 {
	public static void main ( String [] args) throws IOException {
		File fichero = new File ("Programa1.java");  // declaración fichero
		FileReader flu = new FileReader (fichero); // creamos flujo de entrada hacia el fichero
		int i;
		while ((i=flu.read())!=-1) {   //Vamos leyendo carácter a carácter
			System.out.println ((char) i); //hacemos cast a char del entero leído
		}
		flu.close();
	}
}