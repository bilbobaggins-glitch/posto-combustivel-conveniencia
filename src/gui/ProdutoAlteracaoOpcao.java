/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.ProdutoAlterar;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import manager.Gerenciador;

/**
 *
 * @author Admin
 */
public class ProdutoAlteracaoOpcao extends javax.swing.JFrame {
    ProdutoAlterar produtoPainel;
    /**
     * Creates new form ProdutoAlteracaoOpcao
     */
    public ProdutoAlteracaoOpcao(ProdutoAlterar produtoPainel) {
        initComponents();
        
        this.produtoPainel = produtoPainel;
    }


    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        estoqueBt = new javax.swing.JButton();
        precoBt = new javax.swing.JButton();
        depositoBt = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        estoqueBt.setText("Adicionar ao estoque");
        estoqueBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estoqueBtActionPerformed(evt);
            }
        });

        precoBt.setText("Atualizar preço");

        depositoBt.setText("Atualizar depósitos");

        jLabel1.setText("Escolha o tipo de alteração que deseja:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(precoBt, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(estoqueBt, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(depositoBt, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(estoqueBt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(precoBt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(depositoBt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void estoqueBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estoqueBtActionPerformed
        // TODO add your handling code here:
        produtoPainel.abrirAlterarEstoque();
        
        this.dispose();
    }//GEN-LAST:event_estoqueBtActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton depositoBt;
    private javax.swing.JButton estoqueBt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton precoBt;
    // End of variables declaration//GEN-END:variables
}
