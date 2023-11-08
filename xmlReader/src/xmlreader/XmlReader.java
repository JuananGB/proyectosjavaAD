package xmlreader;

import java.io.*;
import java.util.ArrayList;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import serializacion2.Product;

public class XmlReader {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        
        String fileName = "/home/postgres/NetBeansProjects/ProyectosAD/XMLwriter/products.xml";
        
        // Crear un ArrayList para almacenar objetos Product
        ArrayList<Product> productList = new ArrayList<>();

        // Crear una instancia de XMLInputFactory para leer XML
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        XMLStreamReader reader = inputFactory.createXMLStreamReader(new FileInputStream(fileName));
        
        while (reader.hasNext()) {
            int eventType= reader.next();
            
            if(eventType == XMLStreamConstants.START_ELEMENT){
                
                String localName = reader.getLocalName();
                
                if ("product".equals(localName)) {
                        // Obtener el valor del atributo en el índice especificado (reemplaza con el índice deseado)
                        String attributeValue = reader.getAttributeValue(0);
                        System.out.println("Elemento: " + localName + ", Atributo: " + attributeValue);
                    }
                
                if ("descripcion".equals(localName)) {
                    // Obtener el texto del elemento
                    String text = reader.getElementText();
                    System.out.println("Descripcion: " + text);
                }
                 if ("precio".equals(localName)) {
                    // Obtener el texto del elemento
                    //String text = reader.getElementText();
                    
                 
                    String num=reader.getElementText();
                    
                    Double nx=Double.valueOf(num);
                   
                    System.out.println("precio: " + nx);
                }
            }
        }

      /*  // Imprimir los datos de los productos desde el ArrayList
        for (Product product : productList) {
            System.out.println("Código: " + product.getCodigo());
            System.out.println("Descripción: " + product.getDescricion()); // Corregido el nombre del método
            System.out.println("Precio: " + product.getPrezo());
            System.out.println();
        } */

        // Cerrar el lector de XML
        reader.close();
    }
}




