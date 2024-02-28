
package exa15brevep;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;

public class Platos implements Serializable {
    private String codigop;
    private String nomep;
    private int graxaTotal;  // Nuevo campo para almacenar la grasa total
    private static final long serialVersionUID = 8392045065187432538L;


    public Platos() {
        this("", "");
    }

    public Platos(String codigo, String nome) {
        this.codigop = codigo;
        this.nomep = nome;
    }

    public void setCodigop(String code) {
        this.codigop = code;
    }

    public String getCodigop() {
        return codigop;
    }

    public void setNomep(String nome) {
        this.nomep = nome;
    }

    public String getNomep() {
        return nomep;
    }

    public int getGraxaTotal() {
        return graxaTotal;
    }

    public void setGraxaTotal(int graxaTotal) {
        this.graxaTotal = graxaTotal;
    }

    // Método para calcular la grasa total del plato
    public void calcularGraxaTotal() {
        // Implementar el cálculo de la grasa total aquí
        // Puedes dejar este método vacío por ahora si prefieres calcular la grasa total en otro lugar
    }

    // Método para mostrar información del plato
    public void mostrarInformacion() {
        System.out.println("Código del plato: " + codigop);
        System.out.println("Nombre del plato: " + nomep);
        System.out.println("Grasa total: " + graxaTotal);
        System.out.println();
    }

    @Override
    public String toString() {
        return "Código del plato: " + codigop + "\n" +
               "Nombre del plato: " + nomep + "\n";
    }
}


