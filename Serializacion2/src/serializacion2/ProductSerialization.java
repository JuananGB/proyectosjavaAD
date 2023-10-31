
package serializacion2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductSerialization extends Product{
    public static void main(String[] args) {
        String[] cod = {"p1", "p2", "p3"};
        String[] desc = {"parafusos", "cravos", "tachas"};
        int[] prezo = {3, 4, 5};

        List<Product> products = new ArrayList<>();
        
        String fileName = "products.txt";

        // Crear los objetos Product y añadirlos a la lista
        for (int i = 0; i < cod.length; i++) {
            Product product = new Product(cod[i], desc[i], (double)prezo[i]);
            products.add(product);
        }

        try {
            // Crear un archivo de salida para la serialización
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            // Escribir los objetos en el archivo
            for (Product product : products) {
                out.writeObject(product);
            }

            out.writeObject(null); // Marcar el final del archivo

            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Leer los objetos del archivo
        try {
            FileInputStream fileIn = new FileInputStream("products.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            Product product;
            while ((product = (Product) in.readObject()) != null) {
                System.out.println("Código: " + product.getCodigo());
                System.out.println("Descripción: " + product.getDescricion());
                System.out.println("Precio: " + product.getPrezo());
                System.out.println();
            }

            in.close();
            fileIn.close();
        } catch (EOFException e) {
            // Fin del archivo
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}



