import java.sql.*;

public class pruebajdbc {
  public static void main(String[] args) {
    // Establecer conexión con la base de datos
    String url = "jdbc:mysql://localhost:3306/tramites_tecnm";
    String user = "root";
    String password = "tu_password";
    
    try (Connection conn = DriverManager.getConnection(url, user, password)) {
      // Realizar consulta a la tabla 'alumnos' y recuperar el nombre
      String query = "SELECT nombre FROM alumnos WHERE id = ?";
      PreparedStatement stmt = conn.prepareStatement(query);
      stmt.setInt(1, 1); // establecer el valor del parámetro
      ResultSet rs = stmt.executeQuery();
      
      // Imprimir el nombre recuperado
      if (rs.next()) {
        String nombre = rs.getString("nombre");
        System.out.println("Nombre: " + nombre);
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}
