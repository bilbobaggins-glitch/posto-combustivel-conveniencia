/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import conexao.ConexaoException;
import entity.Deposito;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import manager.Gerenciador;

/**
 *
 * @author Admin
 */
public class DepositoPainel extends javax.swing.JPanel {
    Gerenciador gerenciador;
    /**
     * Creates new form DepositoPainel
     */
    public DepositoPainel(Gerenciador gerenciador) {
        initComponents();
        
        this.gerenciador = gerenciador;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomeTxtFld = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        enderecoTxtFld = new javax.swing.JTextField();
        adicionarBt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        depositosTbl = new javax.swing.JTable();

        jLabel1.setText("Nome: ");

        jLabel2.setText("Endereço: ");

        adicionarBt.setText("Adicionar");
        adicionarBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarBtActionPerformed(evt);
            }
        });

        depositosTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Endereço"
            }
        ));
        jScrollPane1.setViewportView(depositosTbl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 243, Short.MAX_VALUE)
                .addComponent(adicionarBt, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(253, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nomeTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(enderecoTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomeTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(enderecoTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adicionarBt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void adicionarBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarBtActionPerformed
        // TODO add your handling code here:
        try {
            Deposito deposito = new Deposito();
            deposito.setNome(nomeTxtFld.getText());
            deposito.setEndereco(enderecoTxtFld.getText());
            gerenciador.depositoInserir(deposito);
            
            atualizarTabela();
        } catch (ConexaoException ex) {
            Logger.getLogger(DepositoPainel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_adicionarBtActionPerformed

    private void atualizarTabela() throws ConexaoException{
        List<Deposito> depositos = gerenciador.depositosBuscarTodos();
        
        if(depositos != null && depositos.size() > 0){
            
            DefaultTableModel model = (DefaultTableModel) depositosTbl.getModel();
            model.setRowCount(0);

            for(Deposito deposito : depositos){
                model.addRow(new Object[]{
                    deposito.getNome(),
                    deposito.getEndereco()
                });
            };
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarBt;
    private javax.swing.JTable depositosTbl;
    private javax.swing.JTextField enderecoTxtFld;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeTxtFld;
    // End of variables declaration//GEN-END:variables
}
