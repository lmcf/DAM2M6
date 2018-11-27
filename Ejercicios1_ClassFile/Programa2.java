import java.io.*;
import java.util.Scanner;
/*
Ejercicio 2: Ahora haz los cambios necesarios para que el programa anterior muestre los ficheros
del directorio introducido desde línea de comandos al ejecutar el programa
*/

public class Programa2{
	private static Scanner lectura;

	public static void main (String[] args) {
		System.out.print("Introduzca directorio \n");
		lectura = new Scanner(System.in);
		String directorio = lectura.nextLine(); //Leemos la primera linia del scanner donde esta el directorio absoluto
		File f = new File(directorio);
		String[] archivos = f.list();
		System.out.printf("Ficheros en el directorio actual: %d %n", archivos.length);
		for (int i=0; i<archivos.length; i++){
			File f2 = new File(f, archivos[i]);
			System.out.printf("Nombre: %s, es fichero?: %b, es directorio?:%b %n", archivos[i],f2.isFile(), f2.isDirectory());
		}
	}
}