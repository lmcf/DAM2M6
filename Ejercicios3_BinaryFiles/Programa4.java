import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Vuelve a ejecutar los problemas anteriores pero en los pasos intermedios
trata de leer el fichero “FicheroDatos.dat” con algún editor de texto del
sistema. ¿Qué pasa? 
*/

public class Programa4 {
	public static void main(String[] args) throws IOException{
		String fichero = "src/FicherosDatos.dat";
		FileOutputStream fileout = new FileOutputStream (fichero);
		DataOutputStream out = new DataOutputStream(fileout);
		String[] nombres = {"Luis","Miguel","Caldeiro","Fernandez"};
		int[] edades = {21,11,31,41};
		for(int i = 0; i<nombres.length;i++) {
			out.writeUTF(nombres[i]);
			out.writeInt(edades[i]);
		}
		
		Process p = Runtime.getRuntime().exec ("subl src/FicherosDatos.dat"); 
		/*  
		 * Al abrir el archivo .dat se muestra el contenido en hexadecimal
		 * */
		
		String fichero2 = "src/FicherosDatos.dat";
		FileInputStream filein = new FileInputStream (fichero2);
		DataInputStream in = new DataInputStream(filein);
		
		String NombreLeido = "";
		int EdadLeida = 0;
		
		try {
			while(((NombreLeido = in.readUTF()) != null) && 
					(((EdadLeida = in.readInt()) != -1))){
				System.out.println(NombreLeido + " " + EdadLeida);
			}
		}catch(IOException IOe){
			in.close();
		}
	}
}

