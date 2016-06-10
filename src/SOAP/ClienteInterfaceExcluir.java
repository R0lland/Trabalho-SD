/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SOAP;

import Entidades.Carro;
import Logs.Logs;
import javax.swing.JOptionPane;

/**
 *
 * @author Djéssica Eickstaedt
 */
public class ClienteInterfaceExcluir extends javax.swing.JFrame {
    private String address = "http://127.0.0.1:1991/SOAP";

    public ClienteInterfaceExcluir(String address) {
        initComponents();
        this.address = address;
    }

    /**
     * Creates new form ClienteInterfaceAdiciona
     */
    public ClienteInterfaceExcluir() {
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
        excluir = new javax.swing.JButton();
        botao_busca = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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

        excluir.setText("Excluir");
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        botao_busca.setText("Buscar");
        botao_busca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_buscaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Excluir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(excluir))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(169, 169, 169)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
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
                                .addComponent(campo_ano, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campo_potencia, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(campo_carga))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campo_complemento))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(campo_codigo, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addComponent(botao_busca)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(campo_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_busca))
                .addGap(49, 49, 49)
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
                .addGap(18, 18, 18)
                .addComponent(excluir)
                .addContainerGap())
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

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        SoapClient cliente = new SoapClient(address);
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
            cliente.consulta(Integer.parseInt(campo_codigo.getText()));
            cliente.excluir(carro);
            JOptionPane.showMessageDialog(rootPane, "Carro excluido com sucesso.");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "ERRO: " + ex.getMessage());
        }
    }//GEN-LAST:event_excluirActionPerformed

    private void botao_buscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_buscaActionPerformed
        SoapClient cliente = new SoapClient(address);
        try {
            
            Carro carro = cliente.consulta(Integer.parseInt(campo_codigo.getText()));
            campo_ano.setText(String.valueOf(carro.getAno()));
            campo_carga.setText(String.valueOf(carro.getCarga()));
            campo_complemento.setText(carro.getComplemento());
            campo_marca.setText(carro.getMarca());
            campo_modelo.setText(carro.getModelo());
            campo_potencia.setText(String.valueOf(carro.getPotencia()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "ERRO: " + ex.getMessage());
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
            java.util.logging.Logger.getLogger(ClienteInterfaceExcluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteInterfaceExcluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteInterfaceExcluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteInterfaceExcluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClienteInterfaceExcluir().setVisible(true);
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
    private javax.swing.JButton excluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
