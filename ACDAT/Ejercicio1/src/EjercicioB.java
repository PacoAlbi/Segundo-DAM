import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class EjercicioB {

    import java.io.*;

    public class apartadoB {
        public static void main(String[] args) {
            File file = new File("AD");
            recorreCarpeta(file.getAbsolutePath());
        }

        public static void recorreCarpeta(String rutaCarpeta) {
            String miNombre = "Pedro Cornejo Carvajal";
            String nombreCarpeta;
            File index = new File(rutaCarpeta);
            if (index.isDirectory()) {
                String[] carpetas = index.list();
                String html;

                for (int i = 0; i < carpetas.length; i++) {
                    rutaCarpeta = index.getAbsolutePath() + "\\" + carpetas[i];
                    File carpetaInternas = new File(rutaCarpeta);
                    nombreCarpeta = carpetas[i];
                    html = "<html>\n" +
                            "   <head>\n" +
                            "      <title> " +
                            nombreCarpeta +
                            " </title>\n" +
                            "   </head>\n" +
                            "   <body>\n" +
                            "      <h1>" +
                            "Ruta: " + rutaCarpeta +
                            "</h1>\n" +
                            "      <h3>Autor: " +
                            miNombre +
                            "</h3>\n" +
                            "   </body>\n" +
                            "</html>";

                    if (!carpetaInternas.getName().equals("index.html")) {
                        escribirHtml(rutaCarpeta, html);
                    }
                    recorreCarpeta(rutaCarpeta);
                }
            }
        }

        public static void escribirHtml (String ruta, String html) {

            File index = new File(ruta + "\\index.html");
            try {

                BufferedWriter bw = new BufferedWriter(new FileWriter(index));
                bw.write(html);
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

}
