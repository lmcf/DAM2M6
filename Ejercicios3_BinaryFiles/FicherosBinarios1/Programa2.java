import java.io.*;
/*
 Escribe un programa que inserte datos en “FicherosDatos.dat”. Los datos los
tomará de dos arrays definidos en el propio programa. Uno contendrá los
nombres de una serie de personas y el otro sus edades. Se irá recorriendo
los arrays e iremos escribiendo en el fichero el nombre (mediante el método
writeUTF(String str) y la edad (writeInt (int v)). NOTA: si queremos añadir
bytes al final del fichero (FicheroDatos.dat) se puede usar el siguiente
constructor: FileOutputStream fileout = new FileOutputStream (fichero, true)
 */

public class Programa2 {
	public static void main(String[] args) throws IOException{
		String fichero = "src/FicherosDatos.dat";
		FileOutputStream fileout = new FileOutputStream (fichero, true);
		DataOutputStream out = new DataOutputStream(fileout);
		String[] nombres = {"Luis","Miguel","Caldeiro","Fernandez"};
		int[] edades = {21,11,31,41};
		for(int i = 0; i<nombres.length;i++) {
			out.writeUTF(nombres[i]);
			out.writeInt(edades[i]);
		}
	}
}
