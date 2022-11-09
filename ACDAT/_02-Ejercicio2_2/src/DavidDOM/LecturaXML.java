package DavidDOM;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class LecturaXML {

    public static void main(String[] args) {

        try {
            DocumentBuilderFactory fabricaCreadorDocumento = DocumentBuilderFactory.newInstance();
            DocumentBuilder creadorDocumento = fabricaCreadorDocumento.newDocumentBuilder();
            Document documento = creadorDocumento.parse("resources/compras.xml");
            //Obtener el elemento raíz del documento
            Element raiz = documento.getDocumentElement();

            //Obtener la lista de nodos que tienen etiqueta "compra"
            NodeList listaCompras = raiz.getElementsByTagName("Compras");
            //Recorrer la lista de compras
            mostrar(listaCompras);
        }  catch (IOException ex) {
            System.out.println("ERROR: Se ha producido un error el leer el fichero\n"+ex.getMessage());
            ex.printStackTrace();
        } catch (ParserConfigurationException ex) {
            System.out.println("ERROR: No se ha podido crear el generador de documentos XML\n"+ex.getMessage());
            ex.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    static public void mostrar(NodeList datoscompra) {
        for(int j=0; j<datoscompra.getLength(); j++) {
            //Obtener de la lista de datos un dato tras otro
            Node dato = datoscompra.item(j);

            //Comprobar que el dato se trata de un nodo de tipo Element
            if(dato.getNodeType()==Node.ELEMENT_NODE) {
                //Obtener la lista de los datos que contiene esa compra
                //			        if(lista.getLength()>0) {
                System.out.print(dato.getNodeName()+": ");
                //El valor está contenido en un hijo del nodo Element
                Node datoContenido = dato.getFirstChild();
                //Mostrar el valor contenido en el nodo que debe ser de tipo Text
                if(datoContenido!=null && datoContenido.getNodeType()==Node.TEXT_NODE) {
                    System.out.println(datoContenido.getTextContent());
                }
                NodeList lista = dato.getChildNodes();
                if(lista.getLength()>0)
                    mostrar(lista);
            }
        }//Mostrar el nombre del tipo de dato





        /*try {

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document document = db.parse("compras.xml");

            Element raiz = document.getDocumentElement();
            NodeList listaCompra = raiz.getElementsByTagName("compra");


            for (int i = 0; i < listaCompra.getLength(); i++) {

                Node compra = listaCompra.item(i);

                System.out.println("Compra " + (i + 1));
                System.out.println("===============");

                NodeList datosCompra = compra.getChildNodes();

                for (int j = 0; j < datosCompra.getLength(); j++) {

                    Node dato = datosCompra.item(j);

                    if (dato.getNodeType() == Node.ELEMENT_NODE) {
                        System.out.print(dato.getNodeName() + " : ");
                        Node datoContenido = dato.getFirstChild();

                        if (datoContenido != null && datoContenido.getNodeType() == Node.TEXT_NODE) {
                            System.out.println(datoContenido.getNodeValue());
                        }
                    }

                }
            }


            System.out.println();


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }*/

    }
}
