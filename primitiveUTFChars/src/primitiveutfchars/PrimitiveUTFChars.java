/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package primitiveutfchars;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PrimitiveUTFChars {

   
    public static void main(String[] args) {
        
            String filename = "texto6.txt";
        
        
        try{
            // Crear un flujo de salida de datos
            FileOutputStream fO = new FileOutputStream(filename);
            BufferedOutputStream bO = new BufferedOutputStream(fO);
            DataOutputStream dO = new DataOutputStream(bO);
            
            // Cadena a gardar
            
            String cadena="Está en casa";
            
            
            // UTF
            
         
                // Escribir la cadena en el archivo utilizando writeUTF
                dO.writeUTF(cadena);

                // Mostrar el tamaño del archivo después de escribir cada cadena
                System.out.println("writeUTF escribindo: " + cadena);
                System.out.println("Bytes totais escritos: "+dO.size());
           
            
            
            // CHARS
           String cadea2="ola que tal estas";
               // Escribir la cadena en el archivo utilizando writeChars
               dO.writeChars(cadea2);

               // Mostrar el tamaño del archivo después de escribir cada cadena
               System.out.println("writeChars escribindo: " + cadea2);
               System.out.println("Bytes totais escritos: "+dO.size());
           
            
             // UTF
            
            
                // Escribir la cadena en el archivo utilizando writeUTF
                dO.writeUTF(cadena);

                // Mostrar el tamaño del archivo después de escribir cada cadena
                System.out.println("writeUTF escribindo: " + cadena);
                System.out.println("Bytes totais escritos: "+dO.size());
            
           
            // Cerrar el flujo de salida
               dO.close();
               
           // Crear un flujo de entrada de datos
            FileInputStream fI = new FileInputStream(filename);
            BufferedInputStream bI = new BufferedInputStream(fI);
            DataInputStream dI = new DataInputStream(bI);
            
           // Leer las cadenas desde el archivo
                        int remainingBytes = dI.available();

                String readCadena = dI.readUTF();
                System.out.println("lemos a  primeira cadea ( UTF): " + readCadena);
                 remainingBytes = dI.available();
                System.out.println("Quedan " + remainingBytes + " bytes por leer");
                
                               

               String palabra="";
                for (int i = 0; i < cadea2.length(); i++) {
                char letra = dI.readChar();
                palabra=palabra +letra;
                 }
               System.out.println("lemos a  segunda cadea (chars): " + palabra);
                  remainingBytes = dI.available();
                System.out.println("Quedan " + remainingBytes + " bytes por leer");
               
                readCadena = dI.readUTF();
                System.out.println("lemos a terceira cadea ( UTF): " + readCadena);
                 remainingBytes = dI.available();
                System.out.println("Quedan " + remainingBytes + " bytes por leer");
                
                
                
                
                

            // Cerrar el flujo de entrada
            dI.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
}
