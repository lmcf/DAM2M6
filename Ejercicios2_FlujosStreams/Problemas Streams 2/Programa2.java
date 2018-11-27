//package Streams2;
import java.io.*;
/*
Streams 2
Ejercicio2: Modifica el ejemplo anterior para, en vez de escribir los caracteres uno a uno,
escribir todo el array usando el método write (char [] buf)

NOTA: si queremos añadir caracteres al final de un fichero de texto podemos utilizar el siguiente
constructor de FileWriter → FileWriter fic = new FileWriter (fichero , true)
*/

public class Programa2 {
	public static void main ( String [] args) throws IOException {
		File fichero = new File("FicheroTexto2.txt");
		FileWriter fic = new FileWriter (fichero);
		String cadena = "Este texto se ha puesto de golpe";
		char[] buf = cadena.toCharArray ();
		fic.write (buf);// Escribimos de golpe la cadena de texto
		fic.append ('*'); // añadimos un asterisco al final
		fic.close ();   // cerramos fichero
	}
}	
