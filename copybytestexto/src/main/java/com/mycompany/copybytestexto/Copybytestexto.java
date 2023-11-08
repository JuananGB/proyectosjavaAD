/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.copybytestexto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copybytestexto {

    public static void main(String[] args) {
        String inputFile = "texto1.txt";
        String outputFile = "texto2.txt";

        // Copia el contenido de texto1.txt a texto2.txt
        copyBytes(inputFile, outputFile);

        // Añade el contenido de texto1.txt a texto2.txt
        appendBytes(inputFile, outputFile);
    }

    // Método para copiar bytes de un archivo a otro
    public static void copyBytes(String inputFile, String outputFile) {
        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile)) {

            int byteRead;
            while ((byteRead = fis.read()) != -1) {
                fos.write(byteRead);
            }
            System.out.println("Copia de bytes completada.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para añadir bytes de un archivo a otro sin sobrescribir
    public static void appendBytes(String inputFile, String outputFile) {
        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile, true)) {

            int byteRead;
            while ((byteRead = fis.read()) != -1) {
                fos.write(byteRead);
            }
            System.out.println("Añadido de bytes completado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

