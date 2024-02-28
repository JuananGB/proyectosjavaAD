
package exa15brevep;
 
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Exa15brevep {
    public static void main(String[] args) {
        try {
            // Cargar objetos desde el archivo platoss
            FileInputStream fileIn = new FileInputStream("/home/postgres/Descargas/platoss");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Platos p1 = (Platos) objectIn.readObject();
            Platos p2 = (Platos) objectIn.readObject();
            objectIn.close();
            
             String jdbcURL = "jdbc:postgresql://localhost:5432/postgres";
             String userName = "postgres";
             String password = "postgres";

            // ME CONECTO A LA BASE DE DATOS POSTGRES

            Connection connection = DriverManager.getConnection(jdbcURL, userName, password);

            // Consultar la base de datos para obtener información sobre los componentes
            String consulta = "SELECT nomec, peso, graxa FROM composicion " +
                              "JOIN componentes ON composicion.codc = componentes.codc";
            PreparedStatement statement = connection.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            // Iterar sobre el resultado de la consulta
            while (resultSet.next()) {
                String nomeComponente = resultSet.getString("nomec");
                int peso = resultSet.getInt("peso");
                int graxa = resultSet.getInt("graxa");

                // Calcular la grasa parcial
                int graxaParcial = (peso / 100) * graxa;

                // Actualizar la grasa total del plato correspondiente
                if (nomeComponente.equals(p1.getCodigop())) {
                    p1.setGraxaTotal(p1.getGraxaTotal() + graxaParcial);
                } else if (nomeComponente.equals(p2.getCodigop())) {
                    p2.setGraxaTotal(p2.getGraxaTotal() + graxaParcial);
                }
            }

            // Cerrar la conexión con la base de datos
            connection.close();

            // Calcular la grasa total para cada plato
            p1.calcularGraxaTotal();
            p2.calcularGraxaTotal();

            // Mostrar la información de los platos
            System.out.println(p1);
            System.out.println("graxatotal:" + p1.getGraxaTotal());
            System.out.println();

            System.out.println(p2);
            System.out.println("graxatotal:" + p2.getGraxaTotal());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
