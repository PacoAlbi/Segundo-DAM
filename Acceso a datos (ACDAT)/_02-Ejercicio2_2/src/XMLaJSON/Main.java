package XMLaJSON;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        //transformaraJSON();
        transformaraXML();
    }

    /**
     * Precondiciones: Debe tener acceso al XML.
     * Método que lee un archivo XML y lo transforma en un archivo JSON de salida.
     * Postcondiciones: Genera un JSON de salida.
     */
    public static void transformaraJSON () {

        try {
            FileReader leerXML = new FileReader("resources/compras.xml");
            BufferedReader br = new BufferedReader(leerXML);
            FileWriter escribirJSON = new FileWriter("src/XMLaJSON/comprasTransformado.json");
            BufferedWriter bw = new BufferedWriter(escribirJSON);
            JSONObject json = XML.toJSONObject(leerXML);
            String jsonFormateado = json.toString();
            bw.write(jsonFormateado);
            br.close();
            bw.close();
            leerXML.close();
            escribirJSON.close();
        } catch (JSONException js) {
            System.out.println(js);
            js.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Precondiciones: Debe tener acceso al JSON.
     * Método que lee un archivo JSON y crea un archivo XML de salida.
     * Postcondiciones: Genera un XML de salida.
     */
    public static void transformaraXML () {

        try {
            FileReader leerJSON = new FileReader("src/XMLaJSON/comprasTransformado.json");
            BufferedReader br = new BufferedReader(leerJSON);
            FileWriter escribirXML = new FileWriter("src/XMLaJSON/comprasTransformado.xml");
            BufferedWriter bw = new BufferedWriter(escribirXML);
            JSONObject json = new JSONObject(leerJSON);

            while (!json.isEmpty()){
                String xmlSalida = json.toString();
                bw.write(xmlSalida);
                System.out.println(xmlSalida);
            }

            bw.close();
            br.close();
            escribirXML.close();
            leerJSON.close();
        } catch (JSONException js) {
            System.out.println(js);
            js.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
