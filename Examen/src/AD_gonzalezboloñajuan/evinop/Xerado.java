/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AD_gonzalezboloñajuan.evinop;

import java.io.Serializable;

/**
 *
 * @author vant
 */
public class Xerado implements Serializable{
String num;
String nomeuva;
String tratacidez;
int total;

    public Xerado() {
    }

    public Xerado(String num, String nomeuva, String tratacidez, int total) {
        this.num = num;
        this.nomeuva = nomeuva;
        this.tratacidez = tratacidez;
        this.total = total;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getNomeuva() {
        return nomeuva;
    }

    public void setNomeuva(String nomeuva) {
        this.nomeuva = nomeuva;
    }

    public String getTratacidez() {
        return tratacidez;
    }

    public void setTratacidez(String tratacidez) {
        this.tratacidez = tratacidez;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Xerado{");
        sb.append("num=").append(num);
        sb.append(", nomeuva=").append(nomeuva);
        sb.append(", tratacidez=").append(tratacidez);
        sb.append(", total=").append(total);
        sb.append('}');
        return sb.toString();
    }
    
    

}
