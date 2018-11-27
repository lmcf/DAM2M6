//package Streams3;
import java.io.*;
/*
Streams 3
Ejercicio2: Escribe un programa que, utilizando la clase BufferedWriter, escriba 10 filas
de caracteres en un fichero de texto y después de escribir cada fila salta una
línea con el método newLine()
*/
public class Programa2 {
	public static void main ( String [] args) throws IOException {
		File fout = new File("out.txt");
		FileOutputStream fos = new FileOutputStream(fout);
	 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	 
		for (int i = 0; i < 10; i++) {
			bw.write("Line " + (i+1));
			bw.newLine();
		}
	 
		bw.close();
	}
}
