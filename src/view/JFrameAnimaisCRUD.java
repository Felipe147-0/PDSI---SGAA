/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.LogTrack;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import model.Animais;
import model.SexoEnum;

/**
 *
 * @author felip
 */
public class JFrameAnimaisCRUD extends javax.swing.JFrame {
    
    private Animais animais;
    private ButtonGroup grupoButtonSexo = new ButtonGroup();
    private Boolean disconnectOnClose;
    
    /**
     * Creates new form JFrameAnimaisCRUD
     */
    public JFrameAnimaisCRUD(Animais animais, boolean disconnectOnClose) {
        initComponents();
        
        jRadioButtonMasculino.setActionCommand("MASCULINO");
        jRadioButtonFeminino.setActionCommand("FEMININO");
        grupoButtonSexo.add(jRadioButtonMasculino);
        grupoButtonSexo.add(jRadioButtonFeminino);
        jRadioButtonFeminino.setSelected(true);
        
        
        this.animais = animais;
        this.disconnectOnClose = disconnectOnClose;
        
        if( this.animais == null ) { 
            this.animais = new Animais();
            jButtonExcluir.setEnabled(false);
        } else {
            dataUp();
            jTextFieldId.setEnabled(false);
        }
    }
     private void checkInput() throws Exception{
            
        if( jTextFieldId.getText().isEmpty() ) {
              throw new Exception("ID deve ser informado!");
        } else {
            if( !jTextFieldId.getText().matches("\\d+") ) {
              throw new Exception("O ID deve ser um número.");
            }
        }
          
        if( jTextFieldNome.getText().isEmpty() ) {
              throw new Exception("O Nome deve ser informado!");
        }
        
        if( jTextFieldEspecie.getText().isEmpty() ) {
              throw new Exception("A Especie deve ser informada!");
        }
        
        if( jTextFieldRaca.getText().isEmpty() ) {
              throw new Exception("A Raca deve ser informada!");
        }
        
        if( jTextFieldIdade.getText().isEmpty() ) {
              throw new Exception("A Idade deve ser informada!");
        }
  
        if( jTextAreaSaude.getText().isEmpty() ) {
              throw new Exception("A Saude deve ser informada!");
        }
        
        if( jTextFieldDataEntrada.getText().isEmpty() && 
                !jTextFieldDataEntrada.getText().matches("\\d{4}-\\d{2}-\\d{2}")) {
              throw new Exception("A Data de Entrada deve ser informada no padrão AAAA-MM-DD!");
        }
        
        
     }
     
     private void dataDown() throws Exception {
         
        animais.setId( Integer.valueOf( jTextFieldId.getText() ) );

        if( jTextFieldNome.getText().isEmpty() ) {
            animais.setNome(null);
        } else {
            animais.setNome( jTextFieldNome.getText() );
        }
        
        if( jTextFieldEspecie.getText().isEmpty() ) {
            animais.setEspecie(null);
        } else {
            animais.setEspecie( jTextFieldEspecie.getText() );
        }
        
        if( jTextFieldRaca.getText().isEmpty() ) {
            animais.setRaca(null);
        } else {
            animais.setRaca( jTextFieldRaca.getText() );
        }
        
        if( jTextFieldIdade.getText().isEmpty() ) {
            animais.setIdade(null);
        } else {
            animais.setIdade( jTextFieldIdade.getText() );
        }
        
        animais.setSexo(SexoEnum.valueOf(grupoButtonSexo.getSelection().getActionCommand()));

        if( jTextAreaSaude.getText().isEmpty() ) {
            animais.setSaude(null);
        } else {
            animais.setSaude( jTextAreaSaude.getText() );
        }
        
        if( jTextFieldDataEntrada.getText().isEmpty() ) {
            animais.setDataEntrada(null);
        } else {
            animais.setDataEntrada( jTextFieldDataEntrada.getText() );
        }
        
        if( jCheckBoxDisponivelAdocao.isSelected() ) {
            animais.setDisponivelAdocao("SIM");
        } else {
            animais.setDisponivelAdocao("NÃO");
        }

    }
     
     private void dataUp() {
     
        jTextFieldId.setText( String.valueOf( animais.getId() ) );

        jTextFieldNome.setText( animais.getNome() );
        
        jTextFieldEspecie.setText( animais.getEspecie() );
        
        jTextFieldRaca.setText( animais.getRaca() );
        
        jTextFieldIdade.setText( animais.getIdade() );
        
        
        if (animais.getSexo() == SexoEnum.FEMININO) {
            jRadioButtonFeminino.setSelected(true);
        } else if (animais.getSexo() == SexoEnum.MASCULINO){
            jRadioButtonMasculino.setSelected(true);
        }

        if( animais.getDisponivelAdocao().equals("SIM") ) {
            jCheckBoxDisponivelAdocao.setSelected(true);
        } else {
            jCheckBoxDisponivelAdocao.setSelected(false);
        }
        
        jTextAreaSaude.setText( animais.getSaude() );
        
        jTextFieldDataEntrada.setText( animais.getDataEntrada() );
        
     }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonExcluir = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jLabelId = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelEspecie = new javax.swing.JLabel();
        jTextFieldEspecie = new javax.swing.JTextField();
        jLabelRaca = new javax.swing.JLabel();
        jTextFieldRaca = new javax.swing.JTextField();
        jLabelIdade = new javax.swing.JLabel();
        jTextFieldIdade = new javax.swing.JTextField();
        jRadioButtonMasculino = new javax.swing.JRadioButton();
        jRadioButtonFeminino = new javax.swing.JRadioButton();
        jLabelSaude = new javax.swing.JLabel();
        jCheckBoxDisponivelAdocao = new javax.swing.JCheckBox();
        jLabelDataEntrada = new javax.swing.JLabel();
        jTextFieldDataEntrada = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaSaude = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Animais CRUD");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
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

        jLabelId.setText("ID:");

        jLabelNome.setText("Nome:");

        jLabelEspecie.setText("Especie:");

        jLabelRaca.setText("Raça:");

        jLabelIdade.setText("Idade:");

        jRadioButtonMasculino.setText("Masculino");

        jRadioButtonFeminino.setText("Feminino");
        jRadioButtonFeminino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonFemininoActionPerformed(evt);
            }
        });

        jLabelSaude.setText("Saúde ou Observações:");

        jCheckBoxDisponivelAdocao.setText("Disponivel para adoção");
        jCheckBoxDisponivelAdocao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDisponivelAdocaoActionPerformed(evt);
            }
        });

        jLabelDataEntrada.setText("Data Entrada:");

        jTextAreaSaude.setColumns(20);
        jTextAreaSaude.setRows(5);
        jScrollPane2.setViewportView(jTextAreaSaude);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelRaca)
                                    .addComponent(jLabelIdade))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelDataEntrada)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldDataEntrada))
                                    .addComponent(jTextFieldRaca)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelEspecie)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldEspecie))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelSaude)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelId)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelNome)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBoxDisponivelAdocao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonMasculino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonFeminino)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelId)
                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNome)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEspecie)
                    .addComponent(jTextFieldEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRaca)
                    .addComponent(jTextFieldRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIdade)
                    .addComponent(jTextFieldIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDataEntrada)
                    .addComponent(jTextFieldDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxDisponivelAdocao)
                    .addComponent(jRadioButtonMasculino)
                    .addComponent(jRadioButtonFeminino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelSaude)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonExcluir)
                    .addComponent(jButtonSalvar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // TODO add your handling code here:
        try {

            System.out.println("Excluir.");

            checkInput();
            dataDown();
            animais.delete(); // delete

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
            animais.save(); // insert || update

            this.dispatchEvent( new WindowEvent( this, WindowEvent.WINDOW_CLOSING ) );

        } catch(Exception ex) {
            LogTrack.getInstance().adicionarLog(ex, true, this);
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jRadioButtonFemininoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonFemininoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonFemininoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if( disconnectOnClose ) {
            System.out.println("Desconectar BD.");
            try {
                animais.disconnectFromDatabase();
            } catch(SQLException ex) {
                LogTrack.getInstance().adicionarLog(ex, true, this);
            }
                    
        }
    }//GEN-LAST:event_formWindowClosing

    private void jCheckBoxDisponivelAdocaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxDisponivelAdocaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxDisponivelAdocaoActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameAnimaisCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameAnimaisCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameAnimaisCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameAnimaisCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFrameAnimaisCRUD( null, true ).setVisible(true);
                } catch(Exception ex) {
                    LogTrack.getInstance().adicionarLog(ex, true, null);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JCheckBox jCheckBoxDisponivelAdocao;
    private javax.swing.JLabel jLabelDataEntrada;
    private javax.swing.JLabel jLabelEspecie;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JLabel jLabelIdade;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelRaca;
    private javax.swing.JLabel jLabelSaude;
    private javax.swing.JRadioButton jRadioButtonFeminino;
    private javax.swing.JRadioButton jRadioButtonMasculino;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaSaude;
    private javax.swing.JTextField jTextFieldDataEntrada;
    private javax.swing.JTextField jTextFieldEspecie;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldIdade;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldRaca;
    // End of variables declaration//GEN-END:variables
}
