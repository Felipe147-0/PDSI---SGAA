/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.LogTrack;
import controller.ResultSetTableModel;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import static java.util.Locale.filter;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.Adotantes;

/**
 *
 * @author felip
 */
public class JFrameAdotantesConsulta extends javax.swing.JFrame {
    
    private Adotantes adotantes;
    
    private boolean disconnectOnClose;    
    private boolean selection;
    
    private String query = "SELECT id as ID, nome as Nome, cpf as CPF, telefone as Telefone, endereco as Endereco FROM adotantes";
    
    private ResultSetTableModel result;
    private final TableRowSorter< TableModel > filter; 

    /**
     * Creates new form JFrameAdotantesConsulta
     */
    public JFrameAdotantesConsulta(Adotantes adotantes, boolean disconnectOnClose,  boolean selection) throws Exception {
        initComponents();
        
        this.adotantes = adotantes;
        this.disconnectOnClose = disconnectOnClose;
        
        this.selection = selection;
        jButtonSelecionar.setEnabled( this.selection );
        
        result = new ResultSetTableModel(query);
        jTableConsulta.setModel(result);
        
        filter = new TableRowSorter<>(result);
        jTableConsulta.setRowSorter(filter);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConsulta = new javax.swing.JTable();
        jLabelFiltro = new javax.swing.JLabel();
        jButtonFiltrar = new javax.swing.JButton();
        jButtonSelecionar = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonAdicionar = new javax.swing.JButton();
        jTextFieldFiltro = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Adotantes");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTableConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableConsulta);

        jLabelFiltro.setText("Filtro:");

        jButtonFiltrar.setText("Filtrar");
        jButtonFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltrarActionPerformed(evt);
            }
        });

        jButtonSelecionar.setText("Selecionar");
        jButtonSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarActionPerformed(evt);
            }
        });

        jButtonAlterar.setText("Alterar");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelFiltro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                        .addComponent(jButtonSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdicionar)
                    .addComponent(jButtonAlterar)
                    .addComponent(jButtonSelecionar)
                    .addComponent(jButtonFiltrar)
                    .addComponent(jTextFieldFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFiltro))
                .addGap(33, 33, 33))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
         if( disconnectOnClose ) {
            System.out.println("Descontectar BD.");
            try {
                result.disconnectFromDatabase();
            } catch(SQLException ex) {
                LogTrack.getInstance().adicionarLog(ex, true, this);
            }
        }
    }//GEN-LAST:event_formWindowClosing

    private void jButtonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrarActionPerformed
        // TODO add your handling code here:
        System.out.println("Filtrar.");

        String padrao = jTextFieldFiltro.getText();
        if( padrao.isEmpty() ) {
            filter.setRowFilter(null);
        } else {
            filter.setRowFilter( RowFilter.regexFilter( padrao ) );
        }
    }//GEN-LAST:event_jButtonFiltrarActionPerformed

    private void jButtonSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarActionPerformed
        // TODO add your handling code here:
        int row = jTableConsulta.getSelectedRow();
        if( row != -1 ) {
            
            System.out.println("Selecionar.");
            
            int id = (int) jTableConsulta.getValueAt(row, 0);
            
            adotantes.setId(id); // 
            
            try {                
                adotantes.load();                
                this.dispatchEvent( new WindowEvent( this, WindowEvent.WINDOW_CLOSING ) );
            } catch(Exception ex) {
                LogTrack.getInstance().adicionarLog(ex, true, this);
            }
            
        }
    }//GEN-LAST:event_jButtonSelecionarActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        // TODO add your handling code here:

        int row = jTableConsulta.getSelectedRow();
        if( row != -1 ) {

            System.out.println("Alterar.");

            int id = (int) jTableConsulta.getValueAt(row, 0);

            Adotantes adotantes = new Adotantes();
            adotantes.setId(id);

            try {

                adotantes.load();

                JFrameAdotantesCRUD jFrameCRUD;
                // a janela jFrameCRUD irá alterar o objeto persistente usuario
                jFrameCRUD = new JFrameAdotantesCRUD( adotantes, false );

                jFrameCRUD.addWindowListener( new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent evt) {
                        try {
                            System.out.println("Atualizar JTable.");
                            result.setQuery(query);
                        } catch( SQLException ex ) {
                            LogTrack.getInstance().adicionarLog(ex, true, null);
                        }
                    }
                } );

                jFrameCRUD.setVisible(true);

            } catch(Exception ex) {
                LogTrack.getInstance().adicionarLog(ex, true, this);
            }

        }
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        // TODO add your handling code here:
        try {

            JFrameAdotantesCRUD jFrameCRUD;
            // null porque o objeto persistente ainda não existe
            jFrameCRUD = new JFrameAdotantesCRUD( null, false );

            jFrameCRUD.addWindowListener( new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent evt) {
                    try {
                        System.out.println("Atualizar JTable.");
                        result.setQuery(query);
                    } catch( SQLException ex ) {
                        LogTrack.getInstance().adicionarLog(ex, true, null);
                    }
                }
            } );

            jFrameCRUD.setVisible(true);

        } catch( Exception ex ) {
            LogTrack.getInstance().adicionarLog(ex, true, this);
        }
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameAdotantesConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameAdotantesConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameAdotantesConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameAdotantesConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFrameAdotantesConsulta(null, true, false).setVisible(true);
                } catch ( Exception ex ) {
                    LogTrack.getInstance().adicionarLog( ex, true, null );
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonFiltrar;
    private javax.swing.JButton jButtonSelecionar;
    private javax.swing.JLabel jLabelFiltro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableConsulta;
    private javax.swing.JTextField jTextFieldFiltro;
    // End of variables declaration//GEN-END:variables
}
