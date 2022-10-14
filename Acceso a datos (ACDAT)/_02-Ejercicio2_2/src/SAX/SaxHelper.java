package SAX;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHelper extends DefaultHandler {

    boolean esDescuento = false;
    boolean esFecha = false;
    boolean esDescripcion = false;
    boolean esPrecioUnidad = false;
    boolean esUnidades = false;

    public void startElement(String uri, String localName, String elementos, Attributes atributos) {
        System.out.println("Inicio del elemento :" + elementos);
        switch (elementos) {
            case "fecha":
                esFecha = true;
                break;
            case "descripcion":
                esDescripcion = true;
                break;
            case "precio_unidad":
                esPrecioUnidad = true;
                break;
            case "descuento":
                esDescuento = true;
                break;
            case "unidades":
                esUnidades = true;
                break;
            default:
                break;
        }
    }

    public void characters(char ch[], int inicio, int length) {
        if (esFecha) {
            System.out.println("Fecha: " + new String(ch, inicio, length));
            esFecha = false;
            return;
        }
        if (esDescripcion) {
            System.out.println("Descripción: " + new String(ch, inicio,length));
            esDescripcion = false;
            return;
        }
        if (esPrecioUnidad) {
            System.out.println("Precio por unidad: " + new String(ch, inicio, length));
            esPrecioUnidad = false;
            return;
        }
        if (esDescuento) {
            System.out.println("Descuento: " + new String(ch, inicio, length));
            esDescuento = false;
            return;
        }
        if (esUnidades) {
            System.out.println("Unidades: " + new String(ch, inicio, length));
            esUnidades = false;
        }
    }

    public void endElement(String uri, String localName, String elementos){
        System.out.println("Fin del elemento: " + elementos);
    }

    public Compra sacarObjeto (String cadena){



        return null;
    }
}
