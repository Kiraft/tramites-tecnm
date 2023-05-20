
package model;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class AlumnoDAO {

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


        
    public String getNombre(int matricula){

        Connection connection = null;
        PreparedStatement pst;
        ResultSet rs;
        String nombre = null;
        
    	try{
            
            connection = PoolConnection.getInstance().getConnection();
            
            if(connection!=null){
                
                String sql = "SELECT nombres from alumnos WHERE numero_control = ?";
                
                pst = connection.prepareStatement(sql);
                pst.setInt(1, matricula);
                
                rs = pst.executeQuery();
                
                
                if (rs.next()) {
                    nombre = rs.getString("nombres");
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

    public String getCarrera(int matricula){

        Connection connection = null;
        PreparedStatement pst;
        ResultSet rs;
        String carrera = null;
        
    	try{
            
            connection = PoolConnection.getInstance().getConnection();
            
            if(connection!=null){
                
                String sql = "SELECT carrera from alumnos WHERE numero_control = ?";
                
                pst = connection.prepareStatement(sql);
                pst.setInt(1, matricula);
                
                rs = pst.executeQuery();
                
                
                if (rs.next()) {
                    carrera = rs.getString("carrera");
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
        return carrera;        
    }
    
    public String getCorreo(int matricula){

        Connection connection = null;
        PreparedStatement pst;
        ResultSet rs;
        String correo = null;
        
    	try{
            
            connection = PoolConnection.getInstance().getConnection();
            
            if(connection!=null){
                
                String sql = "SELECT correo from alumnos WHERE numero_control = ?";
                
                pst = connection.prepareStatement(sql);
                pst.setInt(1, matricula);
                
                rs = pst.executeQuery();
                
                
                if (rs.next()) {
                    correo = rs.getString("correo");
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
        return correo;        
    }
}
