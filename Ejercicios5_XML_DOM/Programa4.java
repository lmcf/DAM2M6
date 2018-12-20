import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;

/* Ejercicio 5. Crea un programa Java que lea el documento anterior y muestre toda la 
información que contenga.*/

public class Programa4 {
	final static String SALTO_LINEA = "\n";
	public static void main (String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File ("src/Artistas.xml"));
			System.out.printf ("Elemento raíz : %s %n", document.getDocumentElement().getNodeName());
			NodeList albums = document.getElementsByTagName("album");
			System.out.printf ("Nodos album a recorrer: %d %n", albums.getLength());
			System.out.println();
			
			for (int i = 0; i < albums.getLength(); i++) {
				Node emple = albums.item(i);
				Short elementoNode = Node.ELEMENT_NODE;
				
				if (emple.getNodeType() == elementoNode){
					Element elemento = (Element) emple;
					System.out.printf("autor: %s %n", elemento.getElementsByTagName("autor").item(0).getTextContent());
					System.out.printf(" | titulo: %s %n", 
							elemento.getElementsByTagName("titulo").item(0).getTextContent());
					System.out.printf(" | format: %s %n", 
							elemento.getElementsByTagName("formato").item(0).getTextContent() + SALTO_LINEA);
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			}
	}
}