/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entity.Produto;
import manager.Gerenciador;

/**
 *
 * @author Admin
 */
public class ProdutoAlterarEstoqueJanela extends javax.swing.JFrame {
    Gerenciador gerenciador;
    Produto produtoSlc;
    ProdutoAlterar produtoAlterar;
    /**
     * Creates new form ProdutoAlterarEstoqueJanela
     */
    public ProdutoAlterarEstoqueJanela(ProdutoAlterar produtoAlterar, Gerenciador gerenciador, Produto produtoSlc) {
        initComponents();
        
        this.gerenciador = gerenciador;
        this.produtoSlc = produtoSlc;
        this.produtoAlterar = produtoAlterar;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        quantidadeSpn = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        adicionarBt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Quantidade: ");

        adicionarBt.setText("Adicionar");
        adicionarBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(adicionarBt, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                    .addComponent(quantidadeSpn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantidadeSpn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(adicionarBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adicionarBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarBtActionPerformed
        // TODO add your handling code here:
        gerenciador.produtoAdicionarQuantidade(produtoSlc, (Integer) quantidadeSpn.getValue());
        
        produtoAlterar.tabelaBuscarTodos();
        
        this.dispose();
    }//GEN-LAST:event_adicionarBtActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarBt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSpinner quantidadeSpn;
    // End of variables declaration//GEN-END:variables
}