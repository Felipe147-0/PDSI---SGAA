
package controller;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

//utilização do padrão singleton para implemtar uma unica conexão com o banco de dados 

public class DataBaseConnection {
    
    private static DataBaseConnection singleton;
    
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private ResultSetMetaData resultSetMetaData;
   
    private String url= AppConfig.getUrl();
    private String user = AppConfig.getUser();
    private String password = AppConfig.getPassword();
    
    private DataBaseConnection(){
        
    }
    
    public static DataBaseConnection getInstance(){
        if(singleton == null){
            singleton= new DataBaseConnection();
        }
        return singleton;
    }
    

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatament() {
        return statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public ResultSetMetaData getResultSetMetaData() {
        return resultSetMetaData;
    }
    
    public void connect() throws SQLException {
        
        if( connection == null)
            connection = DriverManager.getConnection(url, user, password);
        
    }
 
    public void creatStatement() throws SQLException{
       
        if( connection == null)
            connect();
            
        if( statement == null)
            statement = connection.createStatement ( ResultSet.TYPE_SCROLL_INSENSITIVE, resultSet.CONCUR_READ_ONLY);
        
    }
    
    public void executeQuery(String query) throws SQLException{
        
        if( statement == null)
            creatStatement();
        
        resultSet = statement.executeQuery(query);
        resultSetMetaData = resultSet.getMetaData();
        
    }
    
    public boolean executeSQL(String sql) throws SQLException{
       
        if( statement == null)
            creatStatement();
        
        return statement.execute(sql);
    }
    
    public void disconnect() throws SQLException {
        
        if( resultSet != null )
            resultSet.close();
        
        if(statement != null)
            statement.close();
        
        if(connection != null)
            connection.close();
        
        resultSet = null;
        statement = null;
        connection = null;
        
    }
    
    
}
