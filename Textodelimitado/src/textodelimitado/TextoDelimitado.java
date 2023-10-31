
package textodelimitado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


import java.io.*;



public class TextoDelimitado {
    public static void main(String[] args) {
        String[] cod = {"p1", "p2", "p3"};
        String[] desc = {"parafusos", "cravos", "tachas"};
        int[] prezo = {3, 4, 5};

        // Grabar los datos en un archivo de texto delimitado
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("productos.txt")))) {
            for (int i = 0; i < cod.length; i++) {
                writer.println(cod[i] + "\t" + desc[i] + "\t" + prezo[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Leer los datos del archivo de texto delimitado
        try (BufferedReader reader = new BufferedReader(new FileReader("productos.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                // Dividir la línea en campos utilizando el tabulador como separador
                String[] campos = linea.split("\t");
                if (campos.length == 3) {
                    String codigo = campos[0];
                    String descripcion = campos[1];
                    int precio = Integer.parseInt(campos[2]);

                    // Imprimir los valores de cada campo por separado
                    System.out.println("Código: " + codigo);
                    System.out.println("Descripción: " + descripcion);
                    System.out.println("Precio: " + precio);
                    System.out.println(); // Separador entre registros
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

