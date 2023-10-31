
package com.mycompany.copybytesimaxe;

import java.io.*;

public class Copybytesimaxe {
    public static void main(String[] args) {
        try {
            FileInputStream in = new FileInputStream("/home/dam2/Documentos/AD/foto.jpg");
            FileOutputStream out = new FileOutputStream("foto2.jpg");

            int byteLee;
            while ((byteLee = in.read()) != -1) {
                out.write(byteLee);
            }

            in.close();
            out.close();

            File foto2 = new File("foto2.jpg");
            long tamanoFoto2 = foto2.length();
            System.out.println("Tamaño de foto2.jpg: " + tamanoFoto2 + " bytes");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




