//package Streams3;
import java.io.*;
import java.util.Scanner;
/*
Streams 3
Ejercicio 1: Escribe un programa en java que muestre por pantalla un fichero de texto
que le pasamos como argumento (o utilizando scanner) utilizando la clase
BufferedReader
*/

public class Programa1 {
	public static void main ( String [] args) throws IOException {
		System.out.println("nombre del archivo de texto:");
		Scanner lectura = new Scanner(System.in);
		String archivo = lectura.nextLine();
		
		FileReader file = new FileReader(archivo);
	    BufferedReader br = new BufferedReader(file);

		String line;
		while ((line = br.readLine()) != null) {
		    System.out.println(line);
		}
	}
}
