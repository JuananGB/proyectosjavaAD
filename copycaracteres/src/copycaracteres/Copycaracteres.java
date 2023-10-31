
package copycaracteres;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author dam2
 */
public class Copycaracteres {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try{
            FileReader fR= new FileReader("texto1.txt");
            FileWriter fw= new FileWriter("texto2.txt");

            //Leemeos el fichero y lo mostramos por pantalla
            int valor = fR.read();
            while(valor !=-1){
               fw.write(valor);
                valor = fR.read();
            }
            fR.close();
            fw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
