
package serializacion1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serializacion1 {

   
    public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException {
        
        mclase m1 = new mclase("ola",-7,2.7);
     //   mclase m2=new mclase("ola",0,2.7);
       
        String nome = m1.getNome();
        int numero1 = m1.getNumero1();
        double numero2 = m1.getNumero2();
        System.out.println(nome);
        System.out.println(numero1);
        System.out.println(numero2);
                 
            ObjectOutputStream serial = new ObjectOutputStream(new FileOutputStream("serial.txt"));
            
            serial.writeObject(m1);
            
            serial.close();
            
            ObjectInputStream OIS=new ObjectInputStream(new FileInputStream("serial.txt"));
            
            m1= (mclase) OIS.readObject();
         nome = m1.getNome();
         numero1 = m1.getNumero1();
         numero2 = m1.getNumero2();
        System.out.println(nome);
        System.out.println(numero1);
        System.out.println(numero2);
            
            
            OIS.close();
            
            
    

    }
    
}

class mclase implements Serializable{
    
    private transient String nome;
    private transient int numero1;
    private double numero2;

    public mclase(String nome, int numero1, double numero2) {
        this.nome = nome;
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    public mclase() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public double getNumero2() {
        return numero2;
    }

    public void setNumero2(double numero2) {
        this.numero2 = numero2;
    }

 
    
     
}
