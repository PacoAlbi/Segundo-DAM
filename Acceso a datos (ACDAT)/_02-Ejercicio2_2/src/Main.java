import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        leerXmlDOM();


    }

    public static void leerXmlDOM () {
        DocumentBuilderFactory fabricaCreadorDocumento = DocumentBuilderFactory.newDefaultInstance();

        try {
            DocumentBuilder creadorDocumento = fabricaCreadorDocumento.newDocumentBuilder();
            Document fichero = creadorDocumento.parse("resources/compras.xml");
            Element raiz = fichero.getDocumentElement();

            NodeList listaComercio = raiz.getElementsByTagName("Comercio");

            for (int i = 0; i < listaComercio.getLength(); i++) {
                Node comercio = listaComercio.item(i);
                System.out.println("Comercio" + i);
                System.out.println("=============");
                System.out.println(comercio);
            }


        } catch (ParserConfigurationException e) {
            System.out.println("Error al transformar el xml");
        } catch (IOException e) {
            System.out.println("Error de lectura");
        } catch (SAXException e) {
            System.out.println("Error de SAX");
        }
    }

    public static void leerXmlSax () {
        boolean fecha = false, descripcion = false, precio = false;

        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler();




        } catch (ParserConfigurationException e) {
            System.out.println("Error al parsear el fichero xml");
        } catch (SAXException e) {
            System.out.println("Error de SAX");
        }


    }

}