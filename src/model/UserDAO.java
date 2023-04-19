
package model;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class UserDAO {

    public int login (int matricula, String password){
        
        Connection connection = null;
        PreparedStatement pst;
        ResultSet rs;
        int state = -1;

        try{
            
            connection = PoolConnection.getInstance().getConnection();
            
            if(connection!=null){
                
                String sql = "SELECT * FROM alumnos WHERE numero_control=? AND password=?";
                
                pst = connection.prepareStatement(sql);
                pst.setInt(1, matricula);
                pst.setString(2, password);
                
                rs = pst.executeQuery();
                
                if(rs.next()){
                    state = 1;
                }else{
                    state = 0;
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "Hubo un error al conectarse con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            
        }catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Hubo un error de ejecución, posibles errores:\n"
                                              + ex.getMessage());
        }finally{
            
            try{
                if(connection != null){
                    PoolConnection.getInstance().closeConnection(connection);            
                }            
            }catch(SQLException ex){
                System.err.println(ex.getMessage());            
            }

        }
        
        
        return state;
        
    }

    private int getUser(int matricula) {
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


    public void settArchivo(int matricula, String ruta_archivo, int tamano_archivo) {
        
        Connection connection = null;
        PreparedStatement pst;
        ResultSet rs;

        try{
            
            connection = PoolConnection.getInstance().getConnection();
            
            if(connection!=null){
                
                String sql = "INSERT INTO archivos (alumno_id, tipos_archivos_id, ruta_archivo, tamano_archivo, subido, aprovado) " + "VALUES (?, ?, ?, ?, ?)";

                
                pst = connection.prepareStatement(sql);

                pst.setInt(1, getUser(matricula));
                // pst.setInt(2, tipos_archivos_id);
                pst.setString(2, ruta_archivo);
                pst.setInt(3, tamano_archivo);
                pst.setBoolean(4, false);
                pst.setBoolean(5, false);

                rs = pst.executeQuery();
                
                
            }else{
                JOptionPane.showMessageDialog(null, "Hubo un error al conectarse con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            
        }catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Hubo un error de ejecución, posibles errores:\n"
                                              + ex.getMessage());
        }finally{
            
            try{
                if(connection != null){
                    PoolConnection.getInstance().closeConnection(connection);            
                }            
            }catch(SQLException ex){
                System.err.println(ex.getMessage());            
            }

        }
        
        
    }

    public String getNombre(int matricula){

        Connection connection = null;
        PreparedStatement pst;
        ResultSet rs;
        String nombre = null;

        
    	try{
            
            connection = PoolConnection.getInstance().getConnection();
            
            if(connection!=null){
                
                String sql = "SELECT nombres, apellido_paterno, apellido_materno from alumnos WHERE matricula = ?";
                
                pst = connection.prepareStatement(sql);
                pst.setInt(1, matricula);
                
                rs = pst.executeQuery();
                
                
                if (rs.next()) {
                    nombre = rs.getString("nombres") + rs.getString("apellido_paterno") + rs.getString("apellido_materno");
                }

            }else{
                JOptionPane.showMessageDialog(null, "Hubo un error al conectarse con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            
        }catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Hubo un error de ejecución, posibles errores:\n"
                                              + ex.getMessage());
        }finally{
            
            try{
                if(connection != null){
                    PoolConnection.getInstance().closeConnection(connection);            
                }            
            }catch(SQLException ex){
                System.err.println(ex.getMessage());            
            }

        }
        return nombre;        
    }
    
}
