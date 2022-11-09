package SAX;

import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        leerXmlSax();
    }

    public static void leerXmlSax () {

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {

            SAXParser saxParser = factory.newSAXParser();
            SaxHelper handler = new SaxHelper();
            saxParser.parse("resources/compras.xml", handler);
            SaxHelper.sacarTicket();

        } catch (ParserConfigurationException e) {
            System.out.println("Error al parsear el fichero xml");
        } catch (SAXException e) {
            System.out.println("Error de SAX");
        } catch (IOException e) {
            System.out.println("Error de lectura/escritura");
        }
    }



















    /*public static void leerXmlDOM () {
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
    }*/
}