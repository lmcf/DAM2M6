//package Streams2;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/* 
Streams 2
Ejercicio 3: Crea el siguiente array de String e inserta en el fichero las cadenas una a una
usando el método write (String str)

String prov[] = {“Albacete”, “Avila”, “Badajoz”, “Caceres”, “Huelva”, “Jaen”,
“Madrid”, “Segovia”, “Soria”, “Toledo”, “Valladolid”, “Zamora”}
*/

public class Programa3 {
	
	public static void main ( String [] args) throws IOException {
		String prov[] = {"Albacete", "Avila", "Badajoz", "Caceres", "Huelva", "Jaen", 
				"Madrid", "Segovia", "Soria", "Toledo", "Valladolid", "Zamora"};
		
		File fichero = new File("FicheroTexto3.txt");
		FileWriter fic = new FileWriter (fichero);

		for (String provincia : prov) {
			fic.write(provincia + "\n");
		}
		
		fic.append ('*'); // añadimos un asterisco al final
		fic.close ();   // cerramos fichero
	}
}	





