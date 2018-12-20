import java.io.*;
import java.io.IOException;

/*
 * Ejercicio 1:
 * Implementa los ejemplos anteriores y comprueba su correcto funcionamiento 
 * */
public class Programa1 {
	/*
	 * El Programa 1 de ejemplo lo hago en un mismo programa con dos metodos
	 * para hacerlo mas vistoso y ordenado.
	 */
	
	public static void main(String[] args) throws IOException{
		escribir();
		leer();
		
	}
	
	public static void escribir() throws IOException {
		File fichero = new File("src/AleatorioEmpleado.dat");
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");
		
		// Datos Empleados
		String apellido[] = {"Fernandez","Gil","Lopez","Ramos"};
		int dep[] = {10,20,10,10};
		Double salario[] = {1000.45,2400.60,3000.0,1500.56};
		
		// Buffer para almacenar el apellido
		StringBuffer buffer = null;
		
		//Cantidad de elementos del array
		int n = apellido.length;
		
		//Recorremos la array
		for (int i = 0; i < n; i++) {
			file.writeInt(i+1); //Identificador
			buffer = new StringBuffer (apellido[i]);
			buffer.setLength(10); //Fijo en 10 carateres la longitud del apellido
			
			//Inserciones secuenciales en fichero
			file.writeChars(buffer.toString());
			file.writeInt(dep[i]);
			file.writeDouble(salario[i]);
		}
		file.close(); //Cerramos fichero
	}
	
	public static void leer() throws IOException{
		File fichero = new File ("src/AleatorioEmpleado.dat");
		RandomAccessFile file = new RandomAccessFile (fichero, "r");
		int id, dep ,posicion;
		Double salario;
		char apellido[]= new char[10], aux;
		posicion =0;
		
		for ( ; ; ){
			// Nos posicionamos en posicion
			file.seek (posicion); 
			
			// Obtengo identificar de Empleado
			id = file.readInt(); 
			
			for ( int i =0; i<apellido.length; i++) {
				// Voy leyendo carácter a carácter el apellido y lo guardo
				aux = file.readChar(); 
				
				// en el array apellido
				apellido[i]=aux;
			}
			String apellidos = new String (apellido);
			
			//Lectura de departamento y salario
			dep = file.readInt();
			salario = file.readDouble();
			
			if (id >0)
				System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n", id,
				apellidos.trim(), dep, salario);
			
			//Me posiciono para el siguiente empleado.
			//Cada uno ocupa 36 bytes
			posicion = posicion + 36; 
			
			//Si he recorrido todo el fichero saldo del for
			if (file.getFilePointer() == file.length()) break;
		}
		file.close();
	}
}
