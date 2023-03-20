package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;


public class PoolConnection {
    public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/java_curso";
        String username = "root";
        String password = ""; 

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM ");
            while (resultado.next()) {
                System.out.println();
            }

        } catch (SQLException e) {
            
            e.printStackTrace();
        }




    }
}
