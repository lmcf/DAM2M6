//package Streams3;
import java.io.*;
/*
Streams 3
Ejercicio 3: Repite el ejercicio anterior pero ahora utilizando la clase PrintWriter
*/
public class Programa3 {
	public static void main ( String [] args) throws IOException {
		File fout = new File("out.txt");
			 
		PrintWriter pw = new PrintWriter ( new FileWriter (fout));
	 
		for (int i = 0; i < 10; i++) {
			pw.println("Line " + (i+1));
		}
		pw.close();
	}
}
