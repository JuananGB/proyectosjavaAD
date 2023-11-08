
package xmlwriter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter; 
import serializacion2.*;
public class XMLWriter {
    public static void main(String[] args) throws FileNotFoundException, IOException, XMLStreamException, ClassNotFoundException {
        // Nombre del archivo que contiene los objetos serializados
        String fileName = "/home/postgres/NetBeansProjects/ProyectosAD/Serializacion2/products.txt";


     
            // Abrir el archivo en modo lectura y crear un ObjectInputStream
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
                      // Crear una instancia de XMLOutputFactory para escribir XML
            XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = outputFactory.createXMLStreamWriter(new FileWriter("products.xml",StandardCharsets.UTF_8));
             Product product = new Product();
    
            writer.writeStartDocument();
            writer.writeStartElement("products");
            while ((product = (Product) in.readObject()) != null) {
            
                writer.writeStartElement("product");
                writer.writeAttribute("codigo", product.getCodigo());

                writer.writeStartElement("descripcion");
                writer.writeCharacters(product.getDescricion());
                writer.writeEndElement();

                writer.writeStartElement("precio");
                writer.writeCharacters(Double.toString(product.getPrezo()));
                writer.writeEndElement();

                writer.writeEndElement();
            }

            writer.writeEndElement();
            writer.writeEndDocument();
            writer.flush();
            writer.close();
    }
}


