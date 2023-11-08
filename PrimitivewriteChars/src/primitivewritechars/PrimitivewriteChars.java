
package primitivewritechars;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PrimitivewriteChars {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
            //Nombre del archivo donde se guardarán las cadenas de bytes 
      
            String filename = "texto5.txt";
       
       try{  
            // Crear un flujo de salida de datos
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            DataOutputStream dO = new DataOutputStream(bufferedOutputStream);
            
            
            // Cadenas a grabar
            String cadena = "olas"; 
            
            
           
                      for (int i = 0; i < 3; i++) {
                // Escribir la cadena en el archivo utilizando writeChars
                dO.writeChars(cadena);

                // Mostrar el tamaño del archivo después de escribir cada cadena
                System.out.println("Escribiendo la cadena: " + cadena);
                System.out.println("Tamaño del archivo: " + dO.size() + " bytes");
            }   
                       dO.writeChars("ksdfkjshsdf sdfkjnhsdf  sdfkIkasjkaskcadena");
                dO.writeChars("aaaaa");
          dO.close();
          
             // Crear un flujo de entrada de datos
            FileInputStream fileInputStream = new FileInputStream(filename);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            DataInputStream dI = new DataInputStream(bufferedInputStream);
           int remainingBytes = dI.available();
            
           while (remainingBytes > 0) {
               String palabra="";
                 for (int i = 0; i < 4; i++) {
                char letra = dI.readChar();
                palabra=palabra +letra;
                 }
               System.out.println(palabra);

//                System.out.println("Cadena leída: " + readCadena);
//                System.out.println("Quedan " + remainingBytes + " bytes por leer");
                remainingBytes = dI.available();
            }
          
          
        
           
       }catch(IOException e){
           e.printStackTrace();
       }
        
     
       
        
        
    
    }
    
}
