

package com.mycompany.copybytesimaxe2;

/**
 *
 * @author dam2
 */
import java.io.*;

public class CopyBytesImaxe2 {
    public static void main(String[] args) {
        try {
            FileInputStream in = new FileInputStream("/home/dam2/Documentos/AD/foto.jpg");
            BufferedInputStream bufferedIn = new BufferedInputStream(in);

            FileOutputStream out = new FileOutputStream("foto2.jpg");
            BufferedOutputStream bufferedOut = new BufferedOutputStream(out);

            int byteLido;
            while ((byteLido = bufferedIn.read()) != -1) {
                bufferedOut.write(byteLido);
            }

            bufferedIn.close();
            bufferedOut.close();

            File foto2 = new File("foto2.jpg");
            long tamanoFoto2 = foto2.length();
            System.out.println("Tamaño de foto2.jpg: " + tamanoFoto2 + " bytes");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

