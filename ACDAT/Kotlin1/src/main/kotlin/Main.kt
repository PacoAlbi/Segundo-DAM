import org.json.JSONException
import org.json.JSONObject
import org.json.XML
import java.io.*

fun main(args: Array<String>) {

    transformaraJSON()
    transformaraXML()

    println("Program arguments: ${args.joinToString()}")
}

/**
 * Precondiciones: Debe tener acceso al XML.
 * Método que lee un archivo XML y lo transforma en un archivo JSON de salida.
 * Postcondiciones: Genera un JSON de salida.
 */
fun transformaraJSON() {
    try {
        val leerXML = FileReader("src/main/kotlin/compras.xml")
        val br = BufferedReader(leerXML)
        val escribirJSON = FileWriter("src/main/kotlin/comprasTransformado.json")
        val bw = BufferedWriter(escribirJSON)
        val json: JSONObject = XML.toJSONObject(leerXML)
        val jsonFormateado: String = json.toString()
        bw.write(jsonFormateado)
        br.close()
        bw.close()
        leerXML.close()
        escribirJSON.close()
    } catch (js: JSONException) {
        System.out.println(js)
        js.printStackTrace()
    } catch (e: IOException) {
        e.printStackTrace()
    }
}

/**
 * Precondiciones: Debe tener acceso al JSON.
 * Método que lee un archivo JSON y crea un archivo XML de salida.
 * Postcondiciones: Genera un XML de salida.
 */
fun transformaraXML() {
    try {
        val leerJSON = FileReader("src/main/kotlin/comprasTransformado.json")
        val br = BufferedReader(leerJSON)
        val escribirXML = FileWriter("src/main/kotlin/comprasTransformado.xml")
        val bw = BufferedWriter(escribirXML)
        val jsonStr = br.readLine()
        val json = JSONObject(jsonStr)
        val xmlSalida: String = XML.toString(json)
        bw.write(xmlSalida)
        println(xmlSalida)
        bw.close()
        br.close()
        escribirXML.close()
        leerJSON.close()
    } catch (js: JSONException) {
        System.out.println(js)
        js.printStackTrace()
    } catch (e: IOException) {
        e.printStackTrace()
    }
}