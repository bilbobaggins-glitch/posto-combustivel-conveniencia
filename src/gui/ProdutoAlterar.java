/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entity.Produto;
//import exception.ExcecaoComposta;
import java.awt.Point;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import manager.Gerenciador;

/**
 *
 * @author Admin
 */
public class ProdutoAlterar extends javax.swing.JPanel {
    Gerenciador gerenciador;
    Produto produtoSlc;
    List<Produto> produtos;
    /**
     * Creates new form ProdutoPainel
     */
    public ProdutoAlterar(Gerenciador gerenciador) {
        initComponents();
        
        this.gerenciador = gerenciador;
    }

    private void abrirJanela(JFrame jframe){
        double x = this.getLocationOnScreen().getX();
        double y = this.getLocationOnScreen().getY();
        double dx = this.getSize().getWidth();
        double dy = this.getSize().getHeight();
        double xx = x + (dx / 2);
        double yy = y + (dy / 2);
        double dxx = jframe.getSize().getWidth() / 2;
        double dyy = jframe.getSize().getHeight() / 2;
        
        jframe.setLocation(new Point((int) xx - (int) dxx, (int) yy - (int) dyy));
        
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
        produtosTbl = new javax.swing.JTable();
        buscarTodosBt = new javax.swing.JButton();

        produtosTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Preço atual", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        produtosTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                produtosTblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(produtosTbl);

        buscarTodosBt.setText("Buscar todos");
        buscarTodosBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarTodosBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buscarTodosBt, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buscarTodosBt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void produtosTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_produtosTblMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2 && produtos != null){
            int linhaSlc = produtosTbl.getSelectedRow();
            produtoSlc = produtos.get(linhaSlc);
            
            abrirJanela(new ProdutoAlteracaoOpcao(this));
        }
    }//GEN-LAST:event_produtosTblMouseClicked

    private void buscarTodosBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarTodosBtActionPerformed
        // TODO add your handling code here:
        tabelaBuscarTodos();
    }//GEN-LAST:event_buscarTodosBtActionPerformed

    public void tabelaBuscarTodos(){
        DefaultTableModel model = (DefaultTableModel) produtosTbl.getModel();
        model.setRowCount(0);
        
            produtos = gerenciador.produtoBuscarTodos();
//        } catch (ExcecaoComposta ex) {
//            Logger.getLogger(ProdutoPainel.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        for(Produto produto : produtos){
            model.addRow(new Object[]{
                    produto.getId(),
                    produto.getNome(),
                    produto.getPrecoAtual(),
                    produto.getQuantidade()
            });
        }
    }
    
    public void abrirAlterarEstoque(){
        abrirJanela(new ProdutoAlterarEstoqueJanela(this, gerenciador, produtoSlc));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarTodosBt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable produtosTbl;
    // End of variables declaration//GEN-END:variables

}