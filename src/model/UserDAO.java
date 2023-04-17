
package model;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class UserDAO {
    // int matricula;
    // String password;

    // public UserDAO(int matricula, String password){
    //     this.matricula = matricula;
    //     this.password = password;
    // }

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

    // public void insertRute(){
    //     Connection connection = null;
    //     PreparedStatement pst;
    //     ResultSet rs;     
        
    //     try {
    //         connection = PoolConnection.getInstance().getConnection();

    //         if (connection != null) {
    //             String sql = "INSERT INTO  ";
    //         } else {
                
    //         }
    //     } catch (Exception e) {
    //         // TODO: handle exception
    //     }
    // }


   
}
