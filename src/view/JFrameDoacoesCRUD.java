/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.LogTrack;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import model.Doacoes;
import model.Doadores;

/**
 *
 * @author felip
 */
public class JFrameDoacoesCRUD extends javax.swing.JFrame {

    private Doacoes doacoes;
    private Doadores doadores;
    private boolean disconnectOnClose;
    
    
    
    /**
     * Creates new form JFrameDoacoesCRUD
     */
    public JFrameDoacoesCRUD(Doacoes doacoes, boolean disconnectOnClose){
        initComponents();
        
        this.doadores = new Doadores();
        this.doacoes = doacoes;
        this.disconnectOnClose = disconnectOnClose;
        
        if( this.doacoes == null ) { 
            this.doacoes = new Doacoes();
            jButtonExcluir.setEnabled(false);
        } else {
            dataUp();
            jTextFieldID.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSalvar = new javax.swing.JButton();
        jLabelID = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jButtonExcluir = new javax.swing.JButton();
        jLabelDataDoacao = new javax.swing.JLabel();
        jTextFieldDataDoacao = new javax.swing.JTextField();
        jLabelTipoDoacao = new javax.swing.JLabel();
        jTextFieldTipoDoacao = new javax.swing.JTextField();
        jLabelValor = new javax.swing.JLabel();
        jTextFieldValor = new javax.swing.JTextField();
        jLabelDescricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescricao = new javax.swing.JTextArea();
        jLabelDoadoresId = new javax.swing.JLabel();
        jTextFieldDoadoresId = new javax.swing.JTextField();
        jButtonSelecionarDoador = new javax.swing.JButton();
        jButtonApagarDoadores = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Doaçoes CRUD");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jLabelID.setText("ID:");

        jTextFieldID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIDActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jLabelDataDoacao.setText("Data Doação");

        jLabelTipoDoacao.setText("Tipo de Doação:");

        jLabelValor.setText("Valor:");

        jLabelDescricao.setText("Descrição:");

        jTextAreaDescricao.setColumns(20);
        jTextAreaDescricao.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDescricao);

        jLabelDoadoresId.setText("Doadores ID:");

        jTextFieldDoadoresId.setEditable(false);
        jTextFieldDoadoresId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDoadoresIdActionPerformed(evt);
            }
        });

        jButtonSelecionarDoador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/search-icon.png"))); // NOI18N
        jButtonSelecionarDoador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarDoadorActionPerformed(evt);
            }
        });

        jButtonApagarDoadores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/eraser-icon.png"))); // NOI18N
        jButtonApagarDoadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagarDoadoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTipoDoacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldTipoDoacao))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelDataDoacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDataDoacao, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDescricao)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelValor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelDoadoresId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldDoadoresId, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSelecionarDoador, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonApagarDoadores, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDataDoacao)
                    .addComponent(jTextFieldDataDoacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelID))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTipoDoacao)
                    .addComponent(jTextFieldTipoDoacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelValor)
                        .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelDoadoresId)
                        .addComponent(jTextFieldDoadoresId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonSelecionarDoador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonApagarDoadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonExcluir))
                .addGap(26, 26, 26))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:
        try {

            System.out.println("Salvar.");

            checkInput();
            dataDown();
            doacoes.save(); // insert || update

            this.dispatchEvent( new WindowEvent( this, WindowEvent.WINDOW_CLOSING ) );

        } catch(Exception ex) {
            LogTrack.getInstance().adicionarLog(ex, true, this);
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jTextFieldIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIDActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // TODO add your handling code here:
        try {

            System.out.println("Excluir.");

            checkInput();
            dataDown();
            doacoes.delete(); // delete

            this.dispatchEvent( new WindowEvent( this, WindowEvent.WINDOW_CLOSING ) );

        } catch(Exception ex) {
            LogTrack.getInstance().adicionarLog(ex, true, this);
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void checkInput() throws Exception {
        
        if( jTextFieldID.getText().isEmpty() ) {
            throw new Exception("ID deve ser informado!");
        } else {
            if( !jTextFieldID.getText().matches("\\d+") ) {
                throw new Exception("ID deve ser um número.");
            }               
        }
        
        if( jTextFieldTipoDoacao.getText().isEmpty() ) {
                throw new Exception("O Tipo de Doacao deve ser informado!");
            }
        
        if( jTextAreaDescricao.getText().isEmpty() ) {
                throw new Exception("A Descricao deve ser informada!");
            }
        
        if( jTextFieldValor.getText().isEmpty() ) {
                throw new Exception("O Valor deve ser informado!");
            }
        
        String data = jTextFieldDataDoacao.getText().trim();
           if(data.isEmpty()) {
               throw new Exception("O campo data de adoção não pode estar vazio.");
           }

           try {
               LocalDate.parse(data); // Valida a data e o formato
           } catch (DateTimeParseException e) {
               throw new Exception("A data de adoção deve estar no formato válido YYYY-MM-DD.");
           }


           if( jTextFieldDoadoresId.getText().isEmpty() ) {
               throw new Exception("ID do doador deve ser informado!");
                   } else {
               if( !jTextFieldDoadoresId.getText().matches("\\d+") ) {
                   throw new Exception("ID do doador deve ser um número.");
                   }               
           }
    }

    private void dataDown() throws Exception{
        
        doacoes.setId( Integer.valueOf( jTextFieldID.getText() ) );
        
        doacoes.setDoadores(doadores);
       
        if( jTextFieldTipoDoacao.getText().isEmpty() ) {
                doacoes.setTipoDoacao(null);
            } else {
                doacoes.setTipoDoacao( jTextFieldTipoDoacao.getText() );
        }
        
        if( jTextAreaDescricao.getText().isEmpty() ) {
                doacoes.setDescricao(null);
            } else {
                doacoes.setDescricao( jTextAreaDescricao.getText() );
        }
        
        if( jTextFieldValor.getText().isEmpty() ) {
                doacoes.setValor(null);
            } else {
                doacoes.setValor( jTextFieldValor.getText() );
        }
        
        if( jTextFieldDataDoacao.getText().isEmpty() ) {
                doacoes.setDataDoacao(null);
            } else {
                doacoes.setDataDoacao( jTextFieldDataDoacao.getText() );
        }
          
    }

    private void dataUp(){
     
        jTextFieldID.setText( String.valueOf( doacoes.getId() ) );
        
        jTextFieldDoadoresId.setText( String.valueOf( doadores.getIdd() ) );
          
        jTextFieldTipoDoacao.setText( doacoes.getTipoDoacao() );
        
        jTextAreaDescricao.setText( doacoes.getDescricao() );
        
        jTextFieldValor.setText( doacoes.getValor() );
        
        jTextFieldDataDoacao.setText(doacoes.getDataDoacao() );
    }
    
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        if( disconnectOnClose ) {
            System.out.println("Desconectar BD.");
            try {
                doacoes.disconnectFromDatabase();
            } catch(SQLException ex) {
                LogTrack.getInstance().adicionarLog(ex, true, this);
            }
                    
        }
    }//GEN-LAST:event_formWindowClosed

    private void jTextFieldDoadoresIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDoadoresIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDoadoresIdActionPerformed

    private void jButtonSelecionarDoadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarDoadorActionPerformed
        // TODO add your handling code here:

       try {
    if (doadores == null) {
        doadores = new Doadores();
    }

    JFrameDoadoresConsulta jFrameConsulta;
    jFrameConsulta = new JFrameDoadoresConsulta(doadores, false, true);

    jFrameConsulta.addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosed(java.awt.event.WindowEvent evt) {
            // Atualiza o campo com o ID do doador selecionado
            jTextFieldDoadoresId.setText(String.valueOf(doadores.getIdd())); // Use getId() para obter o ID
        }
    });

    jFrameConsulta.setVisible(true);

} catch (Exception ex) {
    LogTrack.getInstance().adicionarLog(ex, true, this);
}


    }//GEN-LAST:event_jButtonSelecionarDoadorActionPerformed

    private void jButtonApagarDoadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApagarDoadoresActionPerformed
        // TODO add your handling code here:
        doadores = null;
        jTextFieldDoadoresId.setText(null);
    }//GEN-LAST:event_jButtonApagarDoadoresActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameDoacoesCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameDoacoesCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameDoacoesCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameDoacoesCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFrameDoacoesCRUD( null, true ).setVisible(true);
                } catch(Exception ex) {
                    LogTrack.getInstance().adicionarLog(ex, true, null);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonApagarDoadores;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonSelecionarDoador;
    private javax.swing.JLabel jLabelDataDoacao;
    private javax.swing.JLabel jLabelDescricao;
    private javax.swing.JLabel jLabelDoadoresId;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelTipoDoacao;
    private javax.swing.JLabel jLabelValor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaDescricao;
    private javax.swing.JTextField jTextFieldDataDoacao;
    private javax.swing.JTextField jTextFieldDoadoresId;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldTipoDoacao;
    private javax.swing.JTextField jTextFieldValor;
    // End of variables declaration//GEN-END:variables

    
}
