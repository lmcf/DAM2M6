import java.io.*;
import java.util.Scanner;
/*
Ejercicio 3: Realiza un programa Java que utilice el método listFiles() para mostrar la lista de
ficheros de un directorio que se pasará al programa desde los argumentos del main
*/

public class Programa3{
	public static void main (String[] args) {
		File f = new File(args[0]);
		File[] paths;
		paths = f.listFiles();
		
		for (File path:paths){
			System.out.print(path + "\n");
		}
	}
}