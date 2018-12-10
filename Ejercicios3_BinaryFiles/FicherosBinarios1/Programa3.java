import java.io.*;
/*
Ahora escribe un programa que permita visualizar los datos grabados
anteriormente en el fichero FicheroDatos.dat. Se deben obtener en el mismo
orden en el que se escribieron, es decir, primero obtenemos el nombre y
luego la edad
*/

public class Programa3 {
	public static void main(String[] args) throws IOException{
		String fichero = "src/FicherosDatos.dat";
		FileInputStream filein = new FileInputStream (fichero);
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
