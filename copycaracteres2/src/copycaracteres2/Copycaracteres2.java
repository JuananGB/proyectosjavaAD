
package copycaracteres2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class Copycaracteres2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try{
            FileReader fR=new FileReader("textoX.txt");
            BufferedReader bR= new BufferedReader(fR);
            FileWriter fW= new FileWriter("textoXX.txt");
            BufferedWriter bW= new BufferedWriter(fW);
            String linea=bR.readLine();
            while(linea!=null){
               bW.write(linea);
               bW.newLine();
               linea = bR.readLine();
                    
            }
            bR.close();
            bW.close();
        }catch(IOException e){
            e.printStackTrace();
         
    }
    
}
    

}
