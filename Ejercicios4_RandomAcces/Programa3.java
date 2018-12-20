import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Programa3 {
	public static void main(String[] args) throws IOException {
		try {
			int input_id = Integer.parseInt(args[0]);
			String input_apellido = args[1];
			int input_dep = Integer.parseInt(args[2]);
			Double input_salario = Double.parseDouble(args[3]);
			
			comprobarEmpleado(input_id,input_apellido,input_dep,input_salario);
			
			leer();
			
		}catch (ArrayIndexOutOfBoundsException exception) {
			System.out.println("Introduce bien los datos por argumentos/parametros");
		}
		
	}
	public static void insertarEmpleado (int w_id, String w_apellido,int w_dep, Double w_salario ) throws IOException {
		File fichero = new File("src/AleatorioEmpleado.dat");
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");
		
		int posicion = (int) file.length();
		file.seek(posicion);
		file.writeInt(w_id);
		file.writeChars(w_apellido);
		file.writeInt(w_dep);
		file.writeDouble(w_salario);
		
		file.close();

	}
	
	public static void comprobarEmpleado(int c_id, String c_apellido,int c_dep, Double c_salario) throws IOException{
		File fichero = new File ("src/AleatorioEmpleado.dat");
		RandomAccessFile file = new RandomAccessFile (fichero, "r");
		
		int id ,posicion;
		posicion = 0;
		
		for ( ; ; ) {
			file.seek (posicion);
			id = file.readInt(); 

			
			if (id == c_id) {
				System.out.printf("El empleado ya existe");
				break;
							
			}else {
				posicion = posicion + 36;
				System.out.println(posicion + " " +file.length());
				if (posicion == file.length()+4) {
					if (c_id > 0) {
						insertarEmpleado(c_id,c_apellido,c_dep,c_salario);
					}else {
						System.out.println("El id introducido no es valido");
					}
					break; 
				}
			}
			
		}

		file.close();
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
