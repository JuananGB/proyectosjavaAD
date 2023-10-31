
package productsstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import java.io.*;

class Product {
    private String codigo;
    private String descricion;
    private Double prezo;

    // Constructor por defecto
    public Product() {
        this.codigo = null;
        this.descricion = null;
        this.prezo = 0.0;
    }

    // Constructor con tres parámetros
    public Product(String codigo, String descricion, Double prezo) {
        this.codigo = codigo;
        this.descricion = descricion;
        this.prezo = prezo;
    }

    // Métodos getter y setter para codigo
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    // Métodos getter y setter para descricion
    public String getDescricion() {
        return descricion;
    }

    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }

    // Métodos getter y setter para prezo
    public Double getPrezo() {
        return prezo;
    }

    public void setPrezo(Double prezo) {
        this.prezo = prezo;
    }
}

public class ProductsStream{
    public static void main(String[] args) {
        try {
            // Crear objetos de la clase Product
            Product product1 = new Product("cod1", "parafusos", 3.0);
            Product product2 = new Product("cod2", "cravos", 4.0);
            Product product3 = new Product("cod3", "tachas", 6.0);
            Product product4 = new Product("cod4", "grapas", 2.0);

            // Guardar los valores en el archivo "produtos.txt" utilizando DataOutputStream
            DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("produtos.txt"));

            // Guardar datos de los productos en el archivo
            guardarProducto(outputStream, product1);
            guardarProducto(outputStream, product2);
            guardarProducto(outputStream, product3);
            guardarProducto(outputStream, product4);

            outputStream.close();

            // Leer los datos de los productos desde el archivo utilizando DataInputStream
            DataInputStream inputStream = new DataInputStream(new FileInputStream("produtos.txt"));

            // Crear un objeto Product para cargar los datos
            Product po3 = new Product();

            // Leer y mostrar los valores de los productos
            while (inputStream.available() > 0) {
                cargarProducto(inputStream, po3);
                System.out.println(po3.getCodigo() + " , " + po3.getDescricion() + " , " + po3.getPrezo());
            }

            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para guardar un producto en el archivo
    public static void guardarProducto(DataOutputStream outputStream, Product product) throws IOException {
        outputStream.writeUTF(product.getCodigo());
        outputStream.writeUTF(product.getDescricion());
        outputStream.writeDouble(product.getPrezo());
    }

    // Método para cargar un producto desde el archivo
    public static void cargarProducto(DataInputStream inputStream, Product product) throws IOException {
        product.setCodigo(inputStream.readUTF());
        product.setDescricion(inputStream.readUTF());
        product.setPrezo(inputStream.readDouble());
    }
}

