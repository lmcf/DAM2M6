import java.io.*;
import java.util.Scanner;
/*
Ejercicio 4: Añade al programa anterior las instrucciones necesarias para que envíe un mensaje de
error en caso de que el directorio pasado como argumento no exista.
*/

public class Programa4{
	public static void main (String[] args) {
		try {
			File f = new File(args[0]);
			File[] paths;
			paths = f.listFiles();

			for (File path:paths){
				System.out.print(path + "\n");
			}
		}catch(NullPointerException ex){
			System.out.println("Error en argumento introducido");
		}
	}
}