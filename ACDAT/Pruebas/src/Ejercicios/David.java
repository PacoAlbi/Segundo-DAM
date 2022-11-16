package Ejercicios;

import java.io.*;


public class David {

    public static void main(String[] args) {
        String palabraPrimera, palabraComparar;
        try{
            do {
                BufferedReader reader= new BufferedReader(new FileReader("palabras.txt")) ;
                palabraPrimera=leerPalabra(reader);
                if(palabraPrimera!=null) {//Si palabraPrimera es null habremos terminado de ordenar las palabras
                    palabraComparar=leerPalabra(reader);
                    while ((palabraPrimera != null) && (palabraComparar != null)) {//Comparamos todas las palabras y sacamos la mayor que no se haya escrito todavia
                        palabraPrimera = sacarMayor(palabraPrimera, palabraComparar);
                        palabraComparar=leerPalabra(reader);

                    }
                    if (palabraPrimera != null) {
                        BufferedWriter writer= new BufferedWriter(new FileWriter("palabrasOrdenadas.txt", true));
                        writer.write(palabraPrimera);
                        writer.write(System.lineSeparator());
                        writer.close();//Hay que cerrar el fichero para que en la siguiente iteracion podamos ver las palabras que llevamos escritas
                    }
                }
            }while (palabraPrimera!=null);
            BufferedWriter writer= new BufferedWriter(new FileWriter("palabrasOrdenadas.txt", true));
            writer.write("David Carvajal");
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * Este metodo lee una palabra que no este escrita en el fichero de salida, si todas esta escritan en el fichero de salida se devolvera una palabara con valor null
     * @param reader
     * @return
     */
    public static String leerPalabra(BufferedReader reader) throws IOException {
        String palabra;
        boolean repetida=true;
        do {
            palabra = reader.readLine();
            if(palabra!=null) {
                repetida = comprobarSiEscrito(palabra);
            }
        } while (repetida && palabra != null);
        return palabra;
    }
    /**

     * Este metodo compara dos String y devolvera el mas chico de ellos
     * @param palabra
     * @param comparador
     * @return
     */
    public static String sacarMayor(String palabra, String comparador){
        if(palabra.compareTo(comparador)<=0){
            return palabra;
        }else {
            return comparador;
        }
    }

    /**
     * Este metodo comprobora si un string se encuentra dentro del archivo palabrasOrdenadas.txt
     * @param palabra
     * @return
     */
    public static boolean comprobarSiEscrito(String palabra ){
        boolean salida=false;
        String comparar;
        try(BufferedReader reader= new BufferedReader(new FileReader("palabrasOrdenadas.txt"))){
            comparar=reader.readLine();
            while (comparar!=null&& !salida){
                if(comparar.compareTo(palabra)==0){
                    salida=true;
                }
                comparar=reader.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return salida;
    }
}