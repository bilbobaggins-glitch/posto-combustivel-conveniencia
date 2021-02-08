/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import conexao.ConexaoException;
import entity.Cliente;
import entity.Venda;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import manager.Gerenciador;


/**
 *
 * @author Admin
 */
public class ClientePainel extends javax.swing.JPanel {
    Gerenciador gerenciador;
    /**
     * Creates new form PainelCliente
     */
    public ClientePainel (Gerenciador gerenciador) throws ConexaoException {
        initComponents();
        
        this.gerenciador = gerenciador;

        List<Cliente> clientes = gerenciador.clientesBuscarTodos();
        
        if(clientes != null && clientes.size() > 0){
            
            DefaultTableModel model = (DefaultTableModel) clientesTbl.getModel();

            for(Cliente cliente : clientes){
                model.addRow(new Object[]{
                        cliente.getNome(),
                        cliente.getCpf(),
                        cliente.getTelefone(),
                        cliente.getEndereco(),
                        cliente.getDataDeNascimento(),
                        cliente.getSexo()
                });
            };
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sexoGpBt = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nomeCxTx = new javax.swing.JFormattedTextField();
        cpfCxTx = new javax.swing.JFormattedTextField();
        enderecoCxTx = new javax.swing.JFormattedTextField();
        telefoneCxTx = new javax.swing.JFormattedTextField();
        clienteAdicionarBt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        clientesTbl = new javax.swing.JTable();
        masculinoBt = new javax.swing.JRadioButton();
        femininoBt = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        dataNascimentoJCld = new com.toedter.calendar.JDateChooser();

        jLabel1.setText("Nome: ");

        jLabel2.setText("Data de nascimento: ");

        jLabel3.setText("CPF: ");

        jLabel4.setText("Endereço: ");

        jLabel5.setText("Telefone: ");

        try {
            cpfCxTx.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            telefoneCxTx.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        clienteAdicionarBt.setText("Adicionar");
        clienteAdicionarBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clienteAdicionarBtMouseClicked(evt);
            }
        });

        clientesTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "Telefone", "Endereço", "Data de nascimento", "Sexo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(clientesTbl);
        if (clientesTbl.getColumnModel().getColumnCount() > 0) {
            clientesTbl.getColumnModel().getColumn(0).setResizable(false);
            clientesTbl.getColumnModel().getColumn(1).setResizable(false);
            clientesTbl.getColumnModel().getColumn(2).setResizable(false);
            clientesTbl.getColumnModel().getColumn(3).setResizable(false);
            clientesTbl.getColumnModel().getColumn(4).setResizable(false);
            clientesTbl.getColumnModel().getColumn(5).setResizable(false);
            clientesTbl.getColumnModel().getColumn(5).setPreferredWidth(5);
        }

        sexoGpBt.add(masculinoBt);
        masculinoBt.setText("Masculino");

        sexoGpBt.add(femininoBt);
        femininoBt.setText("Feminino");

        jLabel6.setText("Sexo: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(cpfCxTx, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataNascimentoJCld, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(masculinoBt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(femininoBt))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(telefoneCxTx, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(enderecoCxTx, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 54, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(7, 7, 7)
                                        .addComponent(nomeCxTx, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(clienteAdicionarBt, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomeCxTx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cpfCxTx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(dataNascimentoJCld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(masculinoBt)
                    .addComponent(femininoBt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(telefoneCxTx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enderecoCxTx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clienteAdicionarBt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clienteAdicionarBtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clienteAdicionarBtMouseClicked
        // TODO add your handling code here:
        Cliente cliente = new Cliente();
        cliente.setNome(nomeCxTx.getText());
        cliente.setCpf(cpfCxTx.getText());
        cliente.setDataDeNascimento(dataNascimentoJCld.getDate());
        if(masculinoBt.isSelected()){
            cliente.setSexo("M");
        }else{
            cliente.setSexo("F");
        }
        cliente.setTelefone(telefoneCxTx.getText());
        cliente.setEndereco(enderecoCxTx.getText());
        
        try {
            gerenciador.clienteInserir(cliente);
        } catch (ConexaoException ex) {
        }
        
        try {
            atualizarTabela();
        } catch (ConexaoException ex) {
        }
    }//GEN-LAST:event_clienteAdicionarBtMouseClicked
    
    private void atualizarTabela() throws ConexaoException{
        List<Cliente> clientes = gerenciador.clientesBuscarTodos();
        
        if(clientes != null && clientes.size() > 0){
            
            DefaultTableModel model = (DefaultTableModel) clientesTbl.getModel();
            model.setRowCount(0);

            for(Cliente cliente : clientes){
                model.addRow(new Object[]{
                        cliente.getNome(),
                        cliente.getCpf(),
                        cliente.getTelefone(),
                        cliente.getEndereco(),
                        cliente.getDataDeNascimento(),
                        cliente.getSexo()
                });
            };
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clienteAdicionarBt;
    private javax.swing.JTable clientesTbl;
    private javax.swing.JFormattedTextField cpfCxTx;
    private com.toedter.calendar.JDateChooser dataNascimentoJCld;
    private javax.swing.JFormattedTextField enderecoCxTx;
    private javax.swing.JRadioButton femininoBt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton masculinoBt;
    private javax.swing.JFormattedTextField nomeCxTx;
    private javax.swing.ButtonGroup sexoGpBt;
    private javax.swing.JFormattedTextField telefoneCxTx;
    // End of variables declaration//GEN-END:variables
}
