/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import conexao.ConexaoException;
import entity.Cliente;
import entity.Produto;
import entity.Venda;
import entity.VendaProduto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author aluno
 */
public class VendaProdutoDAO {
    String sql;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    VendaProduto dto;
    
    VendaProduto vendaProdutoResultado;
    List<VendaProduto> vendaProdutosResultado;
    
    public void inserir(VendaProduto vendaProduto) throws ConexaoException{
        try {
            sql = "insert into vendaproduto (idvenda, idproduto, quantidade) " +
                  "values (?, ?, ?);";
            
            stmt = Conexao.getCon().prepareStatement(sql);
            
            java.sql.Date dataSQL;
            
            stmt.setInt(1, vendaProduto.getVenda().getId());
            stmt.setInt(2, vendaProduto.getProduto().getId());
            stmt.setInt(3, vendaProduto.getQuantidade());
            
            stmt.executeUpdate();
            //System.out.println("Inclusão realizada com sucesso!");
        } catch (SQLException e) {
            //lança a exceção ProdutoDAOException
            System.out.println(e.getMessage());
            //System.out.println("Erro ao inserir dados!!!\n" + e.getMessage());
            //e.printStackTrace();
        }
    }

    public List<VendaProduto> findAll() throws ConexaoException{
        try {
            sql = "select venda.id, venda.pagamentoforma, venda.subtotalsoma, venda.valortotal, venda.idcliente, venda.data, venda.datapagamento, vendaproduto.idvenda, vendaproduto.idproduto, vendaproduto.quantidade, produto.id, produto.precoatual, produto.quantidade, produto.nome from (venda inner join vendaproduto where venda.id = vendaproduto.idvenda) inner join produto on vendaproduto.idproduto = produto.id order by id;";

            stmt = Conexao.getCon().prepareStatement(sql);
            
            rs = stmt.executeQuery();
            
            return carregarMultiplosResultados(rs);
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        } 
        
        return null;
    }

    private VendaProduto carregarResultadoSimples(ResultSet rs) throws SQLException{
        if (rs.next()) {
            dto = new VendaProduto();
            carregarVO(dto, rs);
            
            return dto;
        }else{
            return null;
        }
    }

    private List<VendaProduto> carregarMultiplosResultados(ResultSet rs) throws SQLException{
        List<VendaProduto> resultList = new ArrayList<>();
        while (rs.next()) {
            dto = new VendaProduto();
            carregarVO(dto, rs);
            resultList.add(dto);
        }
        return resultList;
    }
    
    private void carregarVO(VendaProduto dto, ResultSet rs) throws SQLException{
        java.util.Date dataUtil;
        
        Venda venda = new Venda();
        venda.setId(rs.getInt("venda.id"));
        venda.setCliente(null);
        dataUtil = new java.util.Date(rs.getDate("venda.data").getTime());
        venda.setData(dataUtil);
        venda.setDias(rs.getInt("venda.dias"));
        venda.setSubtotalSoma(rs.getDouble("venda.subtotalsoma"));
        venda.setValorTotal(rs.getDouble("venda.valortotal"));
        venda.setPagamentoForma(rs.getString("venda.pagamentoforma"));
        
        Produto produto = new Produto();
        produto.setId(rs.getInt("produto.id"));
        produto.setNome(rs.getString("produto.nome"));
        produto.setQuantidade(rs.getInt("produto.quantidade"));
        produto.setPrecoAtual(rs.getDouble("produto.precoatual"));
        
        dto.setQuantidade(rs.getInt("quantidade"));
        dto.setVenda(venda);
        dto.setProduto(produto);
    }

    public List<VendaProduto> findAllPorVenda(Venda venda) throws ConexaoException {
        try {
            sql = "select venda.id, venda.pagamentoforma, venda.subtotalsoma, venda.valortotal, venda.idcliente, venda.data, venda.dias, vendaproduto.idvenda, vendaproduto.idproduto, vendaproduto.quantidade, produto.id, produto.precoatual, produto.quantidade, produto.nome from (venda inner join vendaproduto on venda.id = vendaproduto.idvenda) inner join produto on vendaproduto.idproduto = produto.id where venda.id = ? order by venda.id;";

            stmt = Conexao.getCon().prepareStatement(sql);

            stmt.setInt(1, venda.getId());
            
            rs = stmt.executeQuery();
            
            return carregarMultiplosResultados(rs);
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        } 
        
        return null;
    }
}
