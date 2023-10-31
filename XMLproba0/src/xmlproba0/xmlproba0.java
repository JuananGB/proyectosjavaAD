
package xmlproba0;

import java.io.FileWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class xmlproba0 {
    public static void main(String[] args) {
        // Definir el nombre del archivo de salida
        String nombreArchivo = "autores.xml";

        // Crear un objeto XMLOutputFactory
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();

        try {
            // Crear un objeto XMLStreamWriter para escribir en el archivo
            FileWriter fileWriter = new FileWriter(nombreArchivo);
            XMLStreamWriter writer = outputFactory.createXMLStreamWriter(fileWriter);

            // Iniciar el documento XML con la versión especificada
            writer.writeStartDocument("1.0");

            // Escribir el elemento raíz
            writer.writeStartElement("autores");

            // Escribir el primer autor y sus atributos y elementos
            writer.writeStartElement("autor");
            writer.writeAttribute("codigo", "a1");
            writer.writeStartElement("nome");
            writer.writeCharacters("Alexandre Dumas");
            writer.writeEndElement();
            writer.writeStartElement("titulo");
            writer.writeCharacters("El conde de montecristo");
            writer.writeEndElement();
            writer.writeStartElement("titulo");
            writer.writeCharacters("Los miserables");
            writer.writeEndElement();
            writer.writeEndElement();

            // Escribir el segundo autor y sus atributos y elementos
            writer.writeStartElement("autor");
            writer.writeAttribute("codigo", "a2");
            writer.writeStartElement("nome");
            writer.writeCharacters("Fiodor Dostoyevski");
            writer.writeEndElement();
            writer.writeStartElement("titulo");
            writer.writeCharacters("El idiota");
            writer.writeEndElement();
            writer.writeStartElement("titulo");
            writer.writeCharacters("Noches blancas");
            writer.writeEndElement();
            writer.writeEndElement();

            // Cerrar el elemento raíz
            writer.writeEndElement();

            // Finalizar el documento
            writer.writeEndDocument();

            // Cerrar el archivo
            writer.close();

            System.out.println("Documento XML creado con éxito: " + nombreArchivo);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
   


