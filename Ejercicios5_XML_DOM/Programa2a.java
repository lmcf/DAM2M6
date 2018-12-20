	import java.io.*;
public class Programa2a {
	/*Ejercicio 2.1 - Vas a realizar exactamente lo mismo que en el programa anterior pero en vez 
	de utilizar un fichero de acceso aleatorio (como era el caso de 
	AleatorioEmpleado.dat) vas a utilizar un fichero de texto con los datos de los 
	empleados. */
	/* No se si el a habia que hacerlo en un java o directamente escribiendo un txt*/
	final static String SALTO_LINEA = "\n";
	public static void main ( String [] args) throws IOException {
		File fichero = new File ("src/Empleados.txt"); 
		if (fichero.exists()) {
			fichero.delete();
		}else {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
			String [] empleado = {
			"1:Fernandez:10:1000.45",
			"2:Gil:20:2400.60",
			"3:Lopez:10:3000.10",
			"4:Ramos:10:1520.35",
			"5:Caldeiro:20:15550.75"};
			
			for (int i = 0; i < empleado.length; i++) {
				bw.append(empleado[i]+SALTO_LINEA);
			}
	
			bw.close();
		}
	}
	
}
