/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SOAP;

import Entidades.Carro;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Djéssica Eickstaedt
 */
public class ClienteInterfaceAltera extends javax.swing.JFrame {

    /**
     * Creates new form ClienteInterfaceAdiciona
     */
    public ClienteInterfaceAltera() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        campo_marca = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campo_potencia = new javax.swing.JTextField();
        campo_carga = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        campo_complemento = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        campo_ano = new javax.swing.JTextField();
        campo_modelo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campo_codigo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        salvar = new javax.swing.JButton();
        botao_busca = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Marca:");

        campo_marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_marcaActionPerformed(evt);
            }
        });

        jLabel5.setText("Potência:");

        campo_potencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_potenciaActionPerformed(evt);
            }
        });

        campo_carga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_cargaActionPerformed(evt);
            }
        });

        jLabel6.setText("Carga:");

        campo_complemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_complementoActionPerformed(evt);
            }
        });

        jLabel7.setText("Complemento:");

        campo_ano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_anoActionPerformed(evt);
            }
        });

        campo_modelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_modeloActionPerformed(evt);
            }
        });

        jLabel3.setText("Modelo:");

        jLabel4.setText("Ano:");

        campo_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_codigoActionPerformed(evt);
            }
        });

        jLabel8.setText("Código:");

        salvar.setText("Salvar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        botao_busca.setText("Buscar");
        botao_busca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_buscaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(187, Short.MAX_VALUE)
                .addComponent(salvar)
                .addGap(150, 150, 150))
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(campo_codigo)
                .addGap(30, 30, 30)
                .addComponent(botao_busca)
                .addGap(66, 66, 66))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(campo_modelo))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(campo_marca, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(25, 25, 25)
                            .addComponent(campo_ano)))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(campo_potencia, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(campo_carga))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(campo_complemento)))
                    .addGap(19, 19, 19)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(campo_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_busca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                .addComponent(salvar)
                .addGap(25, 25, 25))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(83, 83, 83)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(campo_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(campo_potencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(campo_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(campo_carga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(campo_ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(campo_complemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(121, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campo_marcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_marcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_marcaActionPerformed

    private void campo_potenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_potenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_potenciaActionPerformed

    private void campo_cargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_cargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_cargaActionPerformed

    private void campo_complementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_complementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_complementoActionPerformed

    private void campo_anoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_anoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_anoActionPerformed

    private void campo_modeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_modeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_modeloActionPerformed

    private void campo_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_codigoActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
       SoapClient cliente = new SoapClient();
       Carro carro = new Carro(
               Integer.parseInt(campo_codigo.getText()), 
               campo_marca.getText(), 
               campo_modelo.getText(), 
               Integer.parseInt(campo_ano.getText()), 
               Float.parseFloat(campo_potencia.getText()), 
               Float.parseFloat(campo_potencia.getText()), 
               campo_complemento.getText()
       );
       
        try {
            if ( cliente.altera(carro))
                JOptionPane.showMessageDialog(rootPane, "Carro alterado com sucesso.");
                else
                  JOptionPane.showMessageDialog(rootPane, "ERRO");
        } catch (Exception ex) {
            Logger.getLogger(ClienteInterfaceAltera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_salvarActionPerformed

    private void botao_buscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_buscaActionPerformed
       SoapClient cliente = new SoapClient();
        try { 
            Carro carro = cliente.consulta(Integer.parseInt(campo_codigo.getText()));
            campo_ano.setText(String.valueOf(carro.getAno()));
            campo_carga.setText(String.valueOf(carro.getCarga()));
            campo_complemento.setText(carro.getComplemento());
            campo_marca.setText(carro.getMarca());
            campo_modelo.setText(carro.getModelo());
            campo_potencia.setText(String.valueOf(carro.getPotencia()));
        } catch (Exception ex) {
            Logger.getLogger(ClienteInterfaceAltera.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_botao_buscaActionPerformed

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
            java.util.logging.Logger.getLogger(ClienteInterfaceAltera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteInterfaceAltera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteInterfaceAltera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteInterfaceAltera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteInterfaceAltera().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_busca;
    private javax.swing.JTextField campo_ano;
    private javax.swing.JTextField campo_carga;
    private javax.swing.JTextField campo_codigo;
    private javax.swing.JTextField campo_complemento;
    private javax.swing.JTextField campo_marca;
    private javax.swing.JTextField campo_modelo;
    private javax.swing.JTextField campo_potencia;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton salvar;
    // End of variables declaration//GEN-END:variables
}
