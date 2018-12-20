import java.io.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.*;  
import org.w3c.dom.*;
import javax.xml.parsers.*;

/*Ejercicio 2.2 - Vas a realizar exactamente lo mismo que en el programa anterior pero en vez 
de utilizar un fichero de acceso aleatorio (como era el caso de 
AleatorioEmpleado.dat) vas a utilizar un fichero de texto con los datos de los 
empleados. */

public class Programa2b {
	public static void main (String args[]) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("src/Empleados.txt"));
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			Document document = implementation.createDocument(null,"Empleados", null);
			document.setXmlVersion("1.0");
			
			String line = null;
			
			while ((line = file.readLine())!=null) {
				System.out.println(line);
				String[] data = line.split(":");
				Element raiz = document.createElement ("empleado");
				document.getDocumentElement().appendChild(raiz);
				CrearElemento("id", data[0], raiz, document);
				CrearElemento("apellido", data[1], raiz, document);
				CrearElemento("dep", data[2], raiz, document);
				CrearElemento("salario", data[3], raiz, document);	
			}
			
			Source source = new DOMSource(document);
			Result result = new StreamResult(new File ("src/Empleados.xml"));
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		file.close();		
	}
	
	static void CrearElemento (String datoEmpleado, String valor, Element raiz, Document document) {
		Element elem = document.createElement (datoEmpleado);
		Text text = document.createTextNode(valor);
		raiz.appendChild (elem);
		elem.appendChild (text);
	}
	
}

