/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SOAP;

/**
 *
 * @author Djéssica Eickstaedt
 */
public class ClienteIntefacePrincipal extends javax.swing.JFrame {

    /**
     * Creates new form ClienteIntefacePrincipal
     */
    public ClienteIntefacePrincipal() {
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

        jLabel1 = new javax.swing.JLabel();
        botao_adiciona = new javax.swing.JButton();
        botao_altera = new javax.swing.JButton();
        botao_excluir = new javax.swing.JButton();
        botao_consulta = new javax.swing.JButton();
        botao_lista = new javax.swing.JButton();
        address = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cliente SOAP");

        botao_adiciona.setText("Adicionar");
        botao_adiciona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_adicionaActionPerformed(evt);
            }
        });

        botao_altera.setText("Alterar");
        botao_altera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_alteraActionPerformed(evt);
            }
        });

        botao_excluir.setText("Excluir");
        botao_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_excluirActionPerformed(evt);
            }
        });

        botao_consulta.setText("Consultar");
        botao_consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_consultaActionPerformed(evt);
            }
        });

        botao_lista.setText("Lista Ano/Modelo");
        botao_lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_listaActionPerformed(evt);
            }
        });

        address.setText("http://127.0.0.1:1991/SOAP");

        jLabel2.setText("Endereço");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(146, 146, 146))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botao_adiciona, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botao_altera, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botao_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(botao_excluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botao_lista, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(128, 128, 128))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(botao_adiciona)
                .addGap(18, 18, 18)
                .addComponent(botao_altera)
                .addGap(18, 18, 18)
                .addComponent(botao_consulta)
                .addGap(18, 18, 18)
                .addComponent(botao_excluir)
                .addGap(18, 18, 18)
                .addComponent(botao_lista)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botao_adicionaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_adicionaActionPerformed

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClienteInterfaceAdiciona(address.getText()).setVisible(true);
            }
        });
    }//GEN-LAST:event_botao_adicionaActionPerformed

    private void botao_alteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_alteraActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClienteInterfaceAltera(address.getText()).setVisible(true);
            }
        });
    }//GEN-LAST:event_botao_alteraActionPerformed

    private void botao_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_excluirActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClienteInterfaceExcluir(address.getText()).setVisible(true);
            }
        });
    }//GEN-LAST:event_botao_excluirActionPerformed

    private void botao_consultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_consultaActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClienteInterfaceConsulta(address.getText()).setVisible(true);
            }
        });
    }//GEN-LAST:event_botao_consultaActionPerformed

    private void botao_listaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_listaActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClienteInterfaceListaAnoModelo(address.getText()).setVisible(true);
            }
        });
    }//GEN-LAST:event_botao_listaActionPerformed

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
            java.util.logging.Logger.getLogger(ClienteIntefacePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteIntefacePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteIntefacePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteIntefacePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClienteIntefacePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JButton botao_adiciona;
    private javax.swing.JButton botao_altera;
    private javax.swing.JButton botao_consulta;
    private javax.swing.JButton botao_excluir;
    private javax.swing.JButton botao_lista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
