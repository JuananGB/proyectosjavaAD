
package baserelacionalb;

/**
 *
 * @author postgres
 */
import java.sql.*;

public class BaserelacionalB {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/postgres";
        String userName = "postgres";
        String password = "postgres";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, userName, password);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            // Realiza una consulta SQL para seleccionar todos los campos de la tabla 'produtos'
            String selectSQL = "SELECT produtos.* FROM produtos";
            ResultSet resultSet = statement.executeQuery(selectSQL);

            // 1. Listar el contenido completo del ResultSet
            listarContenido(resultSet);

            // 2. Actualizar un registro, por ejemplo, cambiar el precio del producto p2 a 8
            actualizarRegistro(resultSet, "p2", 8);

            // 3. Insertar un nuevo registro, por ejemplo, agregar el producto p4, martillo, 20
            insertarRegistro(resultSet, "p4", "martillo", 20, "2023-09-14");

            // 4. Borrar un registro, por ejemplo, eliminar la fila con el código p3
            borrarRegistro(resultSet, "p3");

            // Cerrar ResultSet y conexión
            resultSet.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void listarContenido(ResultSet resultSet) throws SQLException {
        // Iterar sobre el ResultSet y mostrar el contenido de cada fila
        resultSet.beforeFirst(); // Mover el cursor al inicio
        while (resultSet.next()) {
            String codigo = resultSet.getString("codigo");
            String descricion = resultSet.getString("descricion");
            int prezo = resultSet.getInt("prezo");
            String datac = resultSet.getString("datac");
            System.out.println("Código: " + codigo + ", Descrición: " + descricion + ", Prezo: " + prezo + ", Datac: " + datac);
        }
    }

    public static void actualizarRegistro(ResultSet resultSet, String codigo, int nuevoPrezo) throws SQLException {
        resultSet.beforeFirst();
        while (resultSet.next()) {
            if (resultSet.getString("codigo").equals(codigo)) {
                resultSet.updateInt("prezo", nuevoPrezo);
                resultSet.updateRow();
                System.out.println("Registro actualizado: Código " + codigo + " - Nuevo precio: " + nuevoPrezo);
                break;
            }
        }
    }

   public static void insertarRegistro(ResultSet resultSet, String codigo, String descricion, int prezo, String datac) throws SQLException {
    try {
        resultSet.moveToInsertRow();
        resultSet.updateString("codigo", codigo);
        resultSet.updateString("descricion", descricion);
        resultSet.updateInt("prezo", prezo);
        resultSet.updateDate("datac", java.sql.Date.valueOf(datac));
        resultSet.insertRow();
        resultSet.moveToCurrentRow();
        System.out.println("Registro insertado: Código " + codigo + ", Descrición " + descricion);
    } catch (SQLException e) {
        if (e.getSQLState().equals("23505")) {
            // El código ya existe, intenta una actualización
            resultSet.last(); // Mueve el cursor al último registro
            resultSet.updateString("descricion", descricion);
            resultSet.updateInt("prezo", prezo);
            resultSet.updateDate("datac", java.sql.Date.valueOf(datac));
            resultSet.updateRow();
            resultSet.moveToCurrentRow();
            System.out.println("Registro actualizado: Código " + codigo + ", Descrición " + descricion);
        }
    }
}



    public static void borrarRegistro(ResultSet resultSet, String codigo) throws SQLException {
        resultSet.beforeFirst();
        while (resultSet.next()) {
            if (resultSet.getString("codigo").equals(codigo)) {
                resultSet.deleteRow();
                System.out.println("Registro eliminado: Código " + codigo);
                break;
            }
        }
    }
}

