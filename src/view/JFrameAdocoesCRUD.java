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
import javax.management.Query;
import model.Adocoes;
import model.Adotantes;
import model.Animais;

/**
 *
 * @author felip
 */
public class JFrameAdocoesCRUD extends javax.swing.JFrame {
    
    private Adocoes adocoes;
    private Adotantes adotantes;  //aqui
    private Animais animais;      //aqui
    
    private boolean disconnectOnClose;
    
    /**
     * Creates new form JFrameAdocoesCRUD
     */
    public JFrameAdocoesCRUD(Adocoes adocoes,boolean disconnectOnClose) throws Exception {
        initComponents();
        
        this.adocoes = adocoes;
        this.disconnectOnClose = disconnectOnClose;
       
        if( this.adocoes == null ) { 
            this.adocoes = new Adocoes();
            jButtonExcluir.setEnabled(false);
        } else { 
            if( this.adocoes.getIdAdotantes() != null ) {
                adotantes = new Adotantes();
                adotantes.setId_a( this.adocoes.getIdAdotantes().getId_a() );
                adotantes.load();
            }
            
            if( this.adocoes.getIdAdotantes() != null ) {
                animais = new Animais();
                animais.setId( this.adocoes.getIdAnimal().getId());
                animais.load();
            }
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

        jLabelID = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jLabelDataAdocao = new javax.swing.JLabel();
        jTextFieldDataAdocao = new javax.swing.JTextField();
        jLabelAnimalId = new javax.swing.JLabel();
        jTextFieldAnimalId = new javax.swing.JTextField();
        jLabelAdotantesId = new javax.swing.JLabel();
        jTextFieldAdotantesId = new javax.swing.JTextField();
        jButtonExcluir = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonSelecionarAnimal = new javax.swing.JButton();
        jButtonSelecionarAdotante = new javax.swing.JButton();
        jButtonApagarAnimais = new javax.swing.JButton();
        jLabelAVISO = new javax.swing.JLabel();
        jLabelAVISO2 = new javax.swing.JLabel();
        jButtonApagarAdotantes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Adoçoes CRUD");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabelID.setText("ID:");

        jTextFieldID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIDActionPerformed(evt);
            }
        });

        jLabelDataAdocao.setText("Data Adocao:");

        jTextFieldDataAdocao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDataAdocaoActionPerformed(evt);
            }
        });

        jLabelAnimalId.setText("ID Animal:");

        jTextFieldAnimalId.setEditable(false);
        jTextFieldAnimalId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAnimalIdActionPerformed(evt);
            }
        });

        jLabelAdotantesId.setText("ID Adotantes:");

        jTextFieldAdotantesId.setEditable(false);
        jTextFieldAdotantesId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAdotantesIdActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonSelecionarAnimal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/search-icon.png"))); // NOI18N
        jButtonSelecionarAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarAnimalActionPerformed(evt);
            }
        });

        jButtonSelecionarAdotante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/search-icon.png"))); // NOI18N
        jButtonSelecionarAdotante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarAdotanteActionPerformed(evt);
            }
        });

        jButtonApagarAnimais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/eraser-icon.png"))); // NOI18N
        jButtonApagarAnimais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagarAnimaisActionPerformed(evt);
            }
        });

        jLabelAVISO.setText("Usuario: lembre-se de desmarcar a opção \"Disponìvel para adoção\"");

        jLabelAVISO2.setText("em animais CRUD, depois do animal ser adotado!");

        jButtonApagarAdotantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/eraser-icon.png"))); // NOI18N
        jButtonApagarAdotantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagarAdotantesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelAVISO)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelID)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelAnimalId)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldAnimalId, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonSelecionarAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonApagarAnimais, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelAdotantesId)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldAdotantesId, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonSelecionarAdotante, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonApagarAdotantes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelDataAdocao)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldDataAdocao, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabelAVISO2))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelDataAdocao)
                        .addComponent(jTextFieldDataAdocao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonSelecionarAdotante, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jButtonSelecionarAnimal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelAnimalId)
                        .addComponent(jTextFieldAnimalId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldAdotantesId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelAdotantesId))
                    .addComponent(jButtonApagarAnimais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonApagarAdotantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelAVISO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelAVISO2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonExcluir)
                    .addComponent(jButtonSalvar))
                .addGap(19, 19, 19))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void checkInput() throws Exception{
        
        if( jTextFieldID.getText().isEmpty() ) {
            throw new Exception("ID deve ser informado!");
        } else {
            if( !jTextFieldID.getText().matches("\\d+") ) {
                throw new Exception("ID deve ser um número.");
            }               
        }
        
        if( jTextFieldAnimalId.getText().isEmpty() ) {
            throw new Exception("ID do animal deve ser informado!");
        } else {
            if( !jTextFieldAnimalId.getText().matches("\\d+") ) {
                throw new Exception("ID do animal deve ser um número.");
            }               
        }
        
        if( jTextFieldAdotantesId.getText().isEmpty() ) {
            throw new Exception("ID do adotante deve ser informado!");
        } else {
            if( !jTextFieldAdotantesId.getText().matches("\\d+") ) {
                throw new Exception("ID do adotante deve ser um número.");
            }               
        }
        
        if( jTextFieldDataAdocao.getText().isEmpty() && 
             !jTextFieldDataAdocao.getText().matches("\\d{4}-\\d{2}-\\d{2}")) {
           throw new Exception("A Data de Entrada deve ser informada no padrão AAAA-MM-DD!");
        }
        
        if (!animais.getDisponivelAdocao().equals("SIM")) {
            throw new Exception("Este animal não está disponível para adoção.");
        }
 
    }
    
    private void dataDown() throws Exception{
        
        adocoes.setId( Integer.valueOf( jTextFieldID.getText() ) );
        
        adocoes.setIdAdotantes(adotantes);         //aqui
        
        adocoes.setIdAnimal(animais);
       
        if( jTextFieldDataAdocao.getText().isEmpty() ) {
            adocoes.setDataAdocao(null);
        } else {
            adocoes.setDataAdocao( jTextFieldDataAdocao.getText() );
        }
    }
    
    private void dataUp(){
        jTextFieldID.setText( String.valueOf( adocoes.getId() ) );
        
        if(adocoes.getIdAnimal() != null){
            jTextFieldAnimalId.setText( String.valueOf( adocoes.getIdAnimal().getId()) );
        }
        if(adocoes.getIdAdotantes() != null){
            jTextFieldAdotantesId.setText( String.valueOf( adocoes.getIdAdotantes().getId_a()) );
        }
        jTextFieldDataAdocao.setText(  adocoes.getDataAdocao() );
              
    }
    
    private void jTextFieldIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIDActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // TODO add your handling code here:
        try {

            System.out.println("Excluir.");

            checkInput();
            dataDown();
            adocoes.delete(); // delete

            this.dispatchEvent( new WindowEvent( this, WindowEvent.WINDOW_CLOSING ) );

        } catch(Exception ex) {
            LogTrack.getInstance().adicionarLog(ex, true, this);
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:
        try {

            System.out.println("Salvar.");

            checkInput();
            dataDown();
            adocoes.save(); // insert || update

            this.dispatchEvent( new WindowEvent( this, WindowEvent.WINDOW_CLOSING ) );

        } catch(Exception ex) {
            LogTrack.getInstance().adicionarLog(ex, true, this);
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if( disconnectOnClose ) {
            System.out.println("Desconectar BD.");
            try {
                adocoes.disconnectFromDatabase();
            } catch(SQLException ex) {
                LogTrack.getInstance().adicionarLog(ex, true, this);
            }
                    
        }
    }//GEN-LAST:event_formWindowClosing

    private void jTextFieldDataAdocaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDataAdocaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDataAdocaoActionPerformed

    private void jTextFieldAnimalIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAnimalIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAnimalIdActionPerformed

    private void jTextFieldAdotantesIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAdotantesIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAdotantesIdActionPerformed

    private void jButtonSelecionarAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarAnimalActionPerformed
        // TODO add your handling code here:
        try {
            if (animais == null) {
                animais = new Animais();
            }

            JFrameAnimaisConsulta jFrameConsulta;
            jFrameConsulta = new JFrameAnimaisConsulta(animais, false, true);

            jFrameConsulta.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent evt) {
                    // Atualiza o campo com o ID do doador selecionado
                    jTextFieldAnimalId.setText(String.valueOf(animais.getId())); // Use getId() para obter o ID
                }
            });

            jFrameConsulta.setVisible(true);

        } catch (Exception ex) {
            LogTrack.getInstance().adicionarLog(ex, true, this);
        }

    }//GEN-LAST:event_jButtonSelecionarAnimalActionPerformed

    private void jButtonSelecionarAdotanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarAdotanteActionPerformed
        // TODO add your handling code here:
        try {
            if (adotantes == null) {
                adotantes = new Adotantes();
            }

            JFrameAdotantesConsulta jFrameConsulta;
            jFrameConsulta = new JFrameAdotantesConsulta(adotantes, false, true);

            jFrameConsulta.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent evt) {
                    // Atualiza o campo com o ID do doador selecionado
                    jTextFieldAdotantesId.setText(String.valueOf(adotantes.getId_a())); // Use getId() para obter o ID
                }
            });

            jFrameConsulta.setVisible(true);

        } catch (Exception ex) {
            LogTrack.getInstance().adicionarLog(ex, true, this);
        }

    }//GEN-LAST:event_jButtonSelecionarAdotanteActionPerformed

    private void jButtonApagarAnimaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApagarAnimaisActionPerformed
        // TODO add your handling code here:
        adocoes = null;
        jTextFieldAnimalId.setText(null);
    }//GEN-LAST:event_jButtonApagarAnimaisActionPerformed

    private void jButtonApagarAdotantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApagarAdotantesActionPerformed
        // TODO add your handling code here:
        adocoes = null;
        jTextFieldAdotantesId.setText(null);
    }//GEN-LAST:event_jButtonApagarAdotantesActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameAdocoesCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameAdocoesCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameAdocoesCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameAdocoesCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFrameAdocoesCRUD( null, true ).setVisible(true);
                } catch(Exception ex) {
                    LogTrack.getInstance().adicionarLog(ex, true, null);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonApagarAdotantes;
    private javax.swing.JButton jButtonApagarAnimais;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonSelecionarAdotante;
    private javax.swing.JButton jButtonSelecionarAnimal;
    private javax.swing.JLabel jLabelAVISO;
    private javax.swing.JLabel jLabelAVISO2;
    private javax.swing.JLabel jLabelAdotantesId;
    private javax.swing.JLabel jLabelAnimalId;
    private javax.swing.JLabel jLabelDataAdocao;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JTextField jTextFieldAdotantesId;
    private javax.swing.JTextField jTextFieldAnimalId;
    private javax.swing.JTextField jTextFieldDataAdocao;
    private javax.swing.JTextField jTextFieldID;
    // End of variables declaration//GEN-END:variables
}
