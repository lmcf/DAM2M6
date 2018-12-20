import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/*
 * CONSULTA. Crea un programa Java que consulte los datos de un empleado 
 * del fichero aleatorio. El programa se ejecutará desde la línea de comandos y 
 * debe recibir un identificador de empleado. Si el empleado existe se 
 * visualizarán sus datos, si no existe se visualizará un mensaje indicándolo.
 */

public class Programa2 {
	public static void main(String[] args) throws IOException{
		System.out.println("Enter ID: ");
		Scanner scanner = new Scanner(System.in);
		int identificadorEmpleado = scanner.nextInt();
		
		leer(identificadorEmpleado);
	}
	
	public static void leer(int identificadorEmpleado) throws IOException{
		File fichero = new File ("src/AleatorioEmpleado.dat");
		RandomAccessFile file = new RandomAccessFile (fichero, "r");
		
		int id, dep ,posicion;
		Double salario;
		char apellido[]= new char[10], aux;
		posicion =0;
		
		for ( ; ; ) {
			file.seek (posicion);
			id = file.readInt(); 
			
			if (id == identificadorEmpleado) {
				for ( int i = 0; i < apellido.length; i++) {
					aux = file.readChar(); 
					apellido[i]=aux;
				}
				String apellidos = new String (apellido);
				dep = file.readInt();
				salario = file.readDouble();
				
				if (id > 0) {
					System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n", id,
					apellidos.trim(), dep, salario);
					break;
				}
				
			}else {
				posicion = posicion + 36;
				if (posicion == file.length()) {
					System.out.println("No existe empleado con ese identificador");
					break;
				}
			}
			
		}

		file.close();
	}
}
