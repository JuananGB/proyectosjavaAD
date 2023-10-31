/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package baserelacionala;

import java.sql.*;


/**
 *
 * @author postgres
 */
public class BaserelacionalA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       // TODO code application logic here
       
       String jdbcURL = "jdbc:postgresql://localhost:5432/postgres";
       String userName= "postgres";
       String password = "postgres";
       
       try{
           Connection connection= DriverManager.getConnection(jdbcURL,userName,password);
           Statement statement= connection.createStatement();
           
           //BORRAR TABLA SI EXISTE
           
            String dropTableSQL = "DROP TABLE IF EXISTS produtos;";
            statement.executeUpdate(dropTableSQL);
           
            // Crear la tabla 'produtos'
            String createTableSQL = "CREATE TABLE produtos (codigo VARCHAR(3) PRIMARY KEY, descricion VARCHAR(15), prezo INTEGER, datac DATE);";
            statement.executeUpdate(createTableSQL);

           
           
            // Ejecutar los métodos según tus necesidades
            inserirProduto(connection, "p1", "parafusos", 3, "2020-12-27");
            inserirProduto(connection, "p2", "cravos", 4, "2020-04-06");
            inserirProduto(connection, "p3", "tachas", 6, "2020-07-03");
            listaProdutos(connection);
            actualizaPre(connection, "p2", 8);
            eliminaProduto(connection, "p3");
           
           //CONEXIONES
            statement.execute("DROP TABLE IF EXISTS produtos CASCADE;");
            statement.execute("CREATE TABLE produtos (codigo varchar(3), descricion varchar(15), prezo integer, datac date, PRIMARY KEY (codigo));");
            statement.execute("COMMIT;");
            statement.execute("SHOW datestyle;");
            statement.execute("SET datestyle = 'ISO, DMY';");
            statement.execute("ALTER USER postgres WITH PASSWORD 'postgres';");

            //CERRAR SESIÓN
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        
       }
       
    }
       
   // Método para insertar un nuevo producto
    public static void inserirProduto(Connection connection, String codigo, String descricion, int prezo, String datac) throws SQLException {
        String insertSQL = "INSERT INTO produtos (codigo, descricion, prezo, datac) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, codigo);
            preparedStatement.setString(2, descricion);
            preparedStatement.setInt(3, prezo);
            preparedStatement.setDate(4, java.sql.Date.valueOf(datac));
            preparedStatement.executeUpdate();
        }
    }

    // Método para listar productos
    public static void listaProdutos(Connection connection) throws SQLException {
        String selectSQL = "SELECT * FROM produtos";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                String codigo = resultSet.getString("codigo");
                String descricion = resultSet.getString("descricion");
                int prezo = resultSet.getInt("prezo");
                String datac = resultSet.getString("datac");
                System.out.println("Código: " + codigo + ", Descrición: " + descricion + ", Prezo: " + prezo + ", Datac: " + datac);
            }
        }
    }

    // Método para actualizar el precio de un producto
    public static void actualizaPre(Connection connection, String codigo, int nuevoPrezo) throws SQLException {
        String updateSQL = "UPDATE produtos SET prezo = ? WHERE codigo = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
            preparedStatement.setInt(1, nuevoPrezo);
            preparedStatement.setString(2, codigo);
            preparedStatement.executeUpdate();
        }
    }

    // Método para eliminar un producto por código
    public static void eliminaProduto(Connection connection, String codigo) throws SQLException {
        String deleteSQL = "DELETE FROM produtos WHERE codigo = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setString(1, codigo);
            preparedStatement.executeUpdate();
        }
    }
}

    
 
