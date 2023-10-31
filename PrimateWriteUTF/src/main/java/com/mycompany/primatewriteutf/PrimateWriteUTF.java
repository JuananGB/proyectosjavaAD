package com.mycompany.primatewriteutf;

/**
 *
 * @author dam2
 */
import java.io.*;

public class PrimateWriteUTF {

    public static void main(String[] args) {
        // Nombre del archivo en el que se almacenarán las cadenas
        String filename = "texto3.txt";

        try {
            // Crear un flujo de salida de datos
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream);

            // Cadenas a grabar
            String cadena = "o tempo está xélido";

            for (int i = 0; i < 3; i++) {
                // Escribir la cadena en el archivo utilizando writeUTF
                dataOutputStream.writeUTF(cadena);

                // Mostrar el tamaño del archivo después de escribir cada cadena
                System.out.println("Escribiendo la cadena: " + cadena);
                System.out.println("Tamaño del archivo: " + dataOutputStream.size() + " bytes");
            }
                dataOutputStream.writeUTF("ksdfkjshsdf sdfkjnhsdf  sdfkIkasjkaskcadena");
                dataOutputStream.writeUTF("aaaaa");

            // Cerrar el flujo de salida
            dataOutputStream.close();

            // Crear un flujo de entrada de datos
            FileInputStream fileInputStream = new FileInputStream(filename);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);

            // Leer las cadenas desde el archivo
            int remainingBytes = dataInputStream.available();
            while (remainingBytes > 0) {
                String readCadena = dataInputStream.readUTF();
                System.out.println("Cadena leída: " + readCadena);
                System.out.println("Quedan " + remainingBytes + " bytes por leer");
                remainingBytes = dataInputStream.available();
            }

            // Cerrar el flujo de entrada
            dataInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
