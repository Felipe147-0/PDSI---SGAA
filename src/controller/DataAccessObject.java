package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringJoiner;

/*
Implementação do padrão Data Access Object(DAO), 
esconde a compĺexidade da composição de codigos/scripts SQL.
*/
public abstract class DataAccessObject {
    
   private DataBaseConnection dbConnection;
   
   private String table;
   private boolean novel;
   private boolean changed;
   
//padrão unity of work(mapear os campos alterados)
   private HashMap<String, Object> dirty;
   
   public DataAccessObject(String table){
       
       dbConnection = DataBaseConnection.getInstance();
       
       this.table = table;
       novel = true;
       changed = false;
       
       dirty = new HashMap<>();
       
   }
   
    public void addChange(String key, Object value){
        dirty.put(key, value);
        changed = true;
    } 
   
    private void insert() throws SQLException { 
        String sql = " INSERT INTO " + table;
        
        StringJoiner fields = new StringJoiner(",");
        StringJoiner values = new StringJoiner(",");
        
        for(String k : dirty.keySet()){
            
            fields.add(k);
            
            Object v = dirty.get(k);
            
            if( v == null){
                values.add("NULL");            
            } else {
                if( v instanceof String){
                    values.add("'" + v + "'");
                } else { 
                   values.add(v.toString());
                }
            }
            
        }
        
        sql += " (" + fields.toString() +") ";
        sql += "VALUES (" + values.toString()+ ")";
        
        System.out.println(sql);
        dbConnection.executeSQL(sql);
    }
    
    private void update() throws SQLException {
        String sql = "UPDATE " + table + " SET ";
        
        StringJoiner setClause = new StringJoiner(", ");
        
        for (String key : dirty.keySet()) {
                 
            Object value = dirty.get(key);
        
                if (value == null) {
                    setClause.add(key + " = NULL");
                } else if (value instanceof String) {
                    setClause.add(key + " = '" + value + "'");
                } else {
                     setClause.add(key + " = " + value.toString());
                }
        
        }
        
        sql += setClause.toString();
        sql += " WHERE " + getWhereClauseForOneEntry();
         
        System.out.println(sql);
        dbConnection.executeSQL(sql);
    }
            
    public void save() throws SQLException  {
        
        if( changed == true){
            
            if(novel == true){
                insert();
                novel = false;
                
            } else {
                update();
                
            }
            
            changed = false;
            dirty.clear();
        }
        
    }
    
    public void delete() throws SQLException {
        String sql = " DELETE FROM " + table + " WHERE ";
        
        sql += getWhereClauseForOneEntry();
        
        System.out.println(sql);
        dbConnection.executeSQL(sql);
        
    }
    
    
    
    protected abstract String getWhereClauseForOneEntry();
    
    public boolean load() throws Exception {
       
        String sql = "SELECT * FROM " + table + " WHERE";
        sql += getWhereClauseForOneEntry();
        
        System.out.println(sql);
        dbConnection.executeQuery(sql);
        
        boolean status = dbConnection.getResultSet().next();
        
        if( status == true ){
        
            ArrayList<Object> data = new ArrayList<>(); /*criação do arrayList com o 
            resultado do select para que este seja atribuido aos devidos atributos na implementação do metodo fill()*/

            for (int i = 1; i <= dbConnection.getResultSetMetaData().getColumnCount(); i++ )
                data.add (dbConnection.getResultSet().getObject(i));

            fill(data);
            
            novel = false;
            changed = false;
            dirty.clear();
            
        }
        
        return status;
    }
    
    protected abstract void fill(ArrayList<Object> data) throws Exception;


    public void disconnectFromDatabase() throws SQLException {
        System.out.println( this.getClass() + " Desconectar DB. " );
        dbConnection.disconnect();
    }
}


