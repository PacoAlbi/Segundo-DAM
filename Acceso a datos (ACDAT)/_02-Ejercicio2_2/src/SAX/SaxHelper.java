package SAX;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHelper extends DefaultHandler {

  /*  private static String fecha;
    private static double valorTotal = 0;
    private static int cantidadProductos = 0;
    private static double totalDescuentos = 0;
    private static double precio = 0;
    private static double unidades = 1;*/

    private static Compra compra = new Compra();

    boolean esDescuento = false;
    static boolean esFecha = false;
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

    public void characters(char[] ch, int inicio, int length) {
        if (esFecha) {
            System.out.println("Fecha: " + new String(ch, inicio, length));
            compra.setFecha(new String(ch, inicio, length));
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
            compra.setPrecio(compra.getPrecio()+sacarDoble(ch, inicio, length));
            esPrecioUnidad = false;
            return;
        }
        if (esDescuento) {
            System.out.println("Descuento: " + new String(ch, inicio, length));
            compra.setTotalDescuentos(compra.getTotalDescuentos()+sacarDoble(ch, inicio, length));
            esDescuento = false;
            return;
        }
        if (esUnidades) {
            System.out.println("Unidades: " + new String(ch, inicio, length));
            compra.setUnidades(compra.getUnidades()+sacarDoble(ch, inicio, length));
            esUnidades = false;
        }
    }

    private static Double sacarDoble (char[] ch, int inicio, int length){
        return Double.parseDouble(new String(ch, inicio, length).replace(",","."));
    }

    /*public void endElement(String uri, String localName, String elementos){
        System.out.println("Fin del elemento: " + elementos);
    }*/

    public static void sacarTicket (){
        Double totalPagar;
        while (esFecha){

            System.out.println(compra);
            System.out.println();
        }
    }
}
