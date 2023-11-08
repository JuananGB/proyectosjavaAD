/*
XMLproba0ler

Tratase de ler os contidos do documento XML que se xenerou no exercicio anterior usando os metodos apropiados.

as clases a usar son moi similares:
XMLInputFactory 
XMLStreamReader

metodos da clase XMLStreamreader:
hasNext() : para preguntar se ainda quedan elementos a ler 
next(): para ler o seguinte elemento
getEventType() : retorna un enteiro que  indica o tipo de elemento leido. Este enteiro
 correspondese con unha constante definida por a interface XMLStreamConstants e que pode ser una das seguintes:

                   START_ELEMENT
                   END_ELEMENT
                   ATTRIBUTE
                   CHARACTERS
                   COMMENT
                   SPACE
                   DTD

para preguntar por exemplo se o tipo de evento leido e un Start Element  preguntaremos se este e igual a  XMLStreamConstants.START_ELEMENT:
getLocalName():devolta o nome do elemento actual
getAttributeValue(posidion_do_atributo_dende_0):  devolta un string con o atributo almacenado no indice especificado
getElementText() : devolta o valor de un elemento de texto

*/

package xmlproba0ler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class XMLproba0ler {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        
            // Crear una instancia de XMLInputFactory
            XMLInputFactory factory = XMLInputFactory.newFactory();
            
            // Abrir un FileInputStream para el archivo XML
            FileInputStream fileInputStream = new FileInputStream("/home/postgres/NetBeansProjects/ProyectosAD/XMLproba0/autores.xml"); // Reemplaza con la ubicación de tu archivo XML
            
            // Crear un XMLStreamReader para leer el archivo XML
            XMLStreamReader reader = factory.createXMLStreamReader(fileInputStream);

            while (reader.hasNext()) {
                int eventType = reader.next();
                
                // Comprobar el tipo de evento actual
                if (eventType == XMLStreamConstants.START_ELEMENT) {
                    // Obtener el nombre del elemento actual
                    String localName = reader.getLocalName();
                    
                    // Verificar si el elemento coincide con el que estamos buscando
                    if ("autor".equals(localName)) {
                        // Obtener el valor del atributo en el índice especificado (reemplaza con el índice deseado)
                        String attributeValue = reader.getAttributeValue(0);
                        System.out.println("Elemento: " + localName + ", Atributo: " + attributeValue);
                    }
                   if ("nome".equals(localName)) {
                    // Obtener el texto del elemento
                    String text = reader.getElementText();
                    System.out.println("nome: " + text);
                }
                   
                   if ("titulo".equals(localName)) {
                    // Obtener el texto del elemento
                    String text = reader.getElementText();
                    System.out.println("titulo: " + text);
                } 
                   
                   
            }

            // Cerrar el lector
            reader.close();
        
        }
    }
}

