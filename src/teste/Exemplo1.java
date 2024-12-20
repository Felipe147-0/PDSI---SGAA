/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
Exemplo de INSERT e DELETE.
*/
public class Exemplo1 {
    public static void main(String[] args) throws SQLException {
        
        // url
        String url = "jdbc:mysql://localhost:3306/SGAA-AQ3016439";
        
        // user
        String user = "root";
        
        // password
        String pass = "root";
        
        // gerencia a conexão
        Connection connection = null;
        
        // criar conexão
        connection = DriverManager.getConnection( url, user, pass );
        
        // meio para script SQL
        Statement statement = null;
        
        // cria Statement para executar script SQL no banco de dados
        statement = connection.createStatement();
        
        statement.execute(" INSERT INTO animais VALUES (13, 'doggo 13','dog','srd','10','1','ok','2024-10-10','1')");

        //statement.execute(" DELETE FROM animais WHERE id = 13 ");
        
        // fechar o "script" SQL
        //statement.close();
        
        // fechar a conexão
        //connection.close();
        
    }
}