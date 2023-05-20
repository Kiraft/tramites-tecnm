
package model;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ArchivosDAO {

    private int getId(int matricula) {
        Connection connection = null;
        PreparedStatement pst;
        ResultSet rs;
        int userId = -1;

        try {

            connection = PoolConnection.getInstance().getConnection();

            if (connection != null) {

                String sql = "SELECT id FROM alumnos WHERE numero_control=?";

                pst = connection.prepareStatement(sql);
                pst.setInt(1, matricula);

                rs = pst.executeQuery();

                if (rs.next()) {
                    userId = rs.getInt("id");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error al conectarse con la base de datos", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Hubo un error de ejecución, posibles errores:\n" + ex.getMessage());
        } finally {

            try {
                if (connection != null) {
                    PoolConnection.getInstance().closeConnection(connection);
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }

        }

        return userId;
    }
    
    public void setArchivo(int matricula, String ruta_archivo, int tipo_archivo) {

        Connection connection = null;
        PreparedStatement pst;
    
        int id = getId(matricula);
    
        try {
    
            connection = PoolConnection.getInstance().getConnection();
    
            if (connection != null) {
    
                String sql = "INSERT INTO archivos (alumno_id, tipos_archivo_id, ruta_archivo, subido, aprovado) " +
                             "VALUES (?, ?, ?, ?, ?)";
    
                pst = connection.prepareStatement(sql);
    
                pst.setInt(1, id);
                pst.setInt(2, tipo_archivo);
                pst.setString(3, ruta_archivo);
                pst.setBoolean(4, true);
                pst.setBoolean(5, false);
    
                int rowsAffected = pst.executeUpdate();
                // Hacer algo con rowsAffected si es necesario
    
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error al conectarse con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
    
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hubo un error de ejecución, posibles errores:\n" + ex.getMessage());
        } finally {
    
            try {
                if (connection != null) {
                    PoolConnection.getInstance().closeConnection(connection);
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
    
        }
    
    }

    public void deleteArchivo(int matricula, int tiposArchivoId) {

        Connection connection = null;
        PreparedStatement pst;

        int id = getId(matricula);
    
        try {
    
            connection = PoolConnection.getInstance().getConnection();
    
            if (connection != null) {
    
                String sql = "DELETE FROM archivos WHERE alumno_id = ? AND tipos_archivo_id = ?";
    
                pst = connection.prepareStatement(sql);
                pst.setInt(1, id);
                pst.setInt(2, tiposArchivoId);
    
                int rowsAffected = pst.executeUpdate();
                // Hacer algo con rowsAffected si es necesario
    
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error al conectarse con la base de datos", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
    
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Hubo un error de ejecución, posibles errores:\n" + ex.getMessage());
        } finally {
    
            try {
                if (connection != null) {
                    PoolConnection.getInstance().closeConnection(connection);
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
    
        }
    
    }



    
        // ...
    
        // public boolean[] obtenerArchivosSubidos(int matricula) {

        //     int id = getId(matricula);
        //     boolean[] archivosSubidos = new boolean[8]; // Array para almacenar el estado de cada archivo (8 en total)
    
        //     // Consulta SQL para obtener los archivos subidos por el usuario
        //     String query = "SELECT tipos_archivo_id FROM archivos WHERE alumno_id = ?";
    
        //     try (Connection conn = PoolConnection.getInstance().getConnection();
        //          PreparedStatement statement = conn.prepareStatement(query)) {

        //         statement.setInt(1, id);
        //         ResultSet resultSet = statement.executeQuery();
    
        //         // Marcar como "true" los archivos que ya han sido subidos por el usuario
        //         while (resultSet.next()) {
        //             int tipoArchivoId = resultSet.getInt("tipos_archivo_id");
        //             archivosSubidos[tipoArchivoId - 1] = true; // Restamos 1 para ajustar el índice del array
        //         }

        //     } catch (SQLException e) {
        //         e.printStackTrace();
        //     }
    
        //     return archivosSubidos;
        // }

        
    
        // ...

    
}
