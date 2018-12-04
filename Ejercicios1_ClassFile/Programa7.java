import java.io.*;
/* 
Ejercicio 7. Realiza un programa que elimine el directorio creado en el punto anterior. Para ello
habrás de eliminar todos los archivos que se encuentren dentro del directorio. 
*/

public class Programa7 {
	public static void main(String[] args) {
		File carpeta = new File("NuevoDir");

		try {
			if (carpeta.exists()) {
				for (File file : carpeta.listFiles()){
					file.delete();
				}

				carpeta.delete();
				
				System.out.println("Directorio eliminado correctamente");
			} else {
				System.out.println("El directorio no existe");
			}
		} catch (Exception Ex ) {
			System.out.println("Unknow Error");
		}
	}
}
