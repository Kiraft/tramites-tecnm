package model;


import java.sql.SQLException;


import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;


public class PoolConnection {

    private final String URL = "jdbc:mysql://localhost:3306/tramites_tecnm?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String USER = "root";
    private final String PASS = "";

    private static PoolConnection dataSource;
    private BasicDataSource basicDataSource = null;

    private PoolConnection() {
        basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername(USER);
        basicDataSource.setPassword(PASS);
        basicDataSource.setUrl(URL);
        
        basicDataSource.setMinIdle(5);
        basicDataSource.setMaxIdle(20);
        basicDataSource.setMaxTotal(50);
        basicDataSource.setMaxWaitMillis(-1);

    }

    public static PoolConnection getInstance() {
        if (dataSource == null) {
            dataSource = new PoolConnection();
            return dataSource;
        } else {
            return dataSource;
        }
    }

    public Connection getConnection() throws SQLException{
      return this.basicDataSource.getConnection();
    }
    
    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    } 

}
