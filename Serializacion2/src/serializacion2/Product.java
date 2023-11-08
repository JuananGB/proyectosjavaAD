
package serializacion2;

import java.io.Serializable;

/**
 *
 * @author postgres
 */
public class Product implements Serializable {
      private String codigo;
    private String descricion;
    private Double prezo;

    // Constructor por defecto
    public Product() {
  
    }

    // Constructor con tres parámetros
    public Product(String codigo, String descricion, Double prezo) {
        this.codigo = codigo;
        this.descricion = descricion;
        this.prezo = prezo;
    }

    // Métodos getter y setter para codigo
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    // Métodos getter y setter para descricion
    public String getDescricion() {
        return descricion;
    }

    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }

    // Métodos getter y setter para prezo
    public Double getPrezo() {
        return prezo;
    }

    public void setPrezo(Double prezo) {
        this.prezo = prezo;
    }
}
