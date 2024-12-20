package controller;

import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

public class ResultSetTableModel extends AbstractTableModel {
    
    private DataBaseConnection dbConnection;
    
    private int numberOfRows;
    private int numberOfColumns;

    
    public ResultSetTableModel(String query) throws SQLException {
        
        dbConnection = DataBaseConnection.getInstance();
        
        numberOfRows = 0;
        numberOfColumns = 0;
        
        setQuery(query);
        
    }
    
    public void setQuery(String query) throws SQLException {
        
        dbConnection.executeQuery(query);
        
        if( dbConnection.getResultSet().next() ) {
            
            dbConnection.getResultSet().last();
            numberOfRows = dbConnection.getResultSet().getRow();
            
            numberOfColumns = dbConnection.getResultSetMetaData().getColumnCount();
        }
        else { 
            numberOfRows = 0;
            numberOfColumns = 0;
        }
        
        // notifica a JTable de que modelo foi alterado
        fireTableStructureChanged();
        
    }

    
    @Override
    public int getColumnCount() {
        return numberOfColumns;
    }

    @Override
    public int getRowCount() {
        return numberOfRows;
    }

    @Override
    public Object getValueAt(int row, int column) { // row column começa em zero
        try {
            // getResultSet() row e column começa em 1
            dbConnection.getResultSet().absolute( row + 1 );
            return dbConnection.getResultSet().getObject( column + 1 );
        } catch ( Exception ex ) {
            LogTrack.getInstance().adicionarLog( ex, true, null );
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        try {
            // getResultSetMetaData() row e column começa em 1
            return dbConnection.getResultSetMetaData().getColumnLabel( column + 1 );
        } catch( Exception ex ) {           
            LogTrack.getInstance().adicionarLog( ex, true, null );
        }
        return "";
    }
    
        
    public void disconnectFromDatabase() throws SQLException {
        System.out.println( this.getClass() + " Desconectar DB." );
        dbConnection.disconnect();
    }
    
}