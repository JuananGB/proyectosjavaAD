
package baserelacionalc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaserelacionalC {
    private Connection connection;

    public BaserelacionalC(String url, String usuario, String contrasena) {
        try {
            // Conectar ao banco de dados
            connection = DriverManager.getConnection(url, usuario, contrasena);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para inserir filas usando sentenças preparadas
    public void insireprep(String codigo, String descricion, double prezo, String dataStr) {
        try {
            // Crie uma sentença preparada
            String query = "INSERT INTO produtos (codigo, descricion, prezo, datac) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Substitua os interrogantes pelos valores concretos
            preparedStatement.setString(1, codigo);
            preparedStatement.setString(2, descricion);
            preparedStatement.setDouble(3, prezo);
            
            // Convierte la cadena de fecha en un objeto Date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date data = dateFormat.parse(dataStr);
            
            // Convierte el objeto Date en java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(data.getTime());
            preparedStatement.setDate(4, sqlDate);

            // Execute a inserção
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Método para atualizar una fila conocido su código usando sentenças preparadas
    public void actuprep(String codigo, String novaDescricion, double novoPrezo, String novaDataStr) {
        try {
            // Crie uma sentença preparada
            String query = "UPDATE produtos SET descricion = ?, prezo = ?, datac = ? WHERE codigo = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Substitua os interrogantes pelos valores concretos
            preparedStatement.setString(1, novaDescricion);
            preparedStatement.setDouble(2, novoPrezo);
            
            // Convierte la cadena de fecha en un objeto Date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date novaData = dateFormat.parse(novaDataStr);
            
            // Convierte el objeto Date en java.sql.Date
            java.sql.Date sqlNovaData = new java.sql.Date(novaData.getTime());
            preparedStatement.setDate(3, sqlNovaData);
            
            preparedStatement.setString(4, codigo);

            // Execute a atualização
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Método para realizar una consulta de todos los registros usando ResultSet con sentença preparada
    public void consultaTotal() {
        try {
            // Crie uma sentença preparada
            String query = "SELECT * FROM produtos";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Execute a consulta e obtenha um ResultSet
            ResultSet resultSet = preparedStatement.executeQuery();

            // Iterar sobre los resultados
            while (resultSet.next()) {
                String codigo = resultSet.getString("codigo");
                String descricion = resultSet.getString("descricion");
                double prezo = resultSet.getDouble("prezo");
                Date datac = resultSet.getDate("datac");

                System.out.println("Código: " + codigo + ", Descricion: " + descricion + ", Prezo: " + prezo + ", Datac: " + datac);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String usuario = "postgres";
        String contrasena = "postgres";

        BaserelacionalC acessoBD = new BaserelacionalC(url, usuario, contrasena);

        // Ejemplo de uso de los métodos
        acessoBD.insireprep("p7", "martillo", 20, "2023-09-14");
        acessoBD.actuprep("p7", "martillo_modificado", 25, "2023-09-15");
        acessoBD.consultaTotal();
    }
}
