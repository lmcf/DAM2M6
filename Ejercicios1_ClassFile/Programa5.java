import java.io.*;
import java.util.Scanner;
/*
Ejercicio 5: Realiza un programa Java que muestre la siguiente información de un fichero
cualquiera: Nombre, ruta relativa, ruta absoluta, permisos y tamaño.
*/

public class Programa5{
	public static void main (String[] args) {
		try {
			File f = new File(args[0]);
			System.out.println("Nombre: " + f.getName());
			System.out.println("Ruta Relativa: " + f.getPath());
			System.out.println("Ruta Absoluta: " + f.getAbsolutePath());
			System.out.println("Puede Leer: " + f.canRead());
			System.out.println("Puede Escribir: " + f.canWrite());
			System.out.println("Puede Ejecutar: " + f.canExecute());
			System.out.println("Tamaño: " + f.length() + " Bytes");
			
		}catch(NullPointerException ex){
			System.out.println("Error en argumento introducido");
		}
	}
}