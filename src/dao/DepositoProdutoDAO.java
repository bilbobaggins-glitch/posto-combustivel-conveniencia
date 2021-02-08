/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import conexao.ConexaoException;
import entity.Deposito;
import entity.DepositoProduto;
import entity.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author aluno
 */
public class DepositoProdutoDAO {
    String sql;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    DepositoProduto dto;
    
    DepositoProduto depositoProdutoResultado;
    List<DepositoProduto> depositoProdutosResultado;
    
    public void inserir(DepositoProduto depositoProduto) throws ConexaoException{
        try {
            sql = "insert into depositoProduto (iddeposito, idproduto) " +
                  "values (?, ?);";
            
            stmt = Conexao.getCon().prepareStatement(sql);
            
            stmt.setInt(1, depositoProduto.getDeposito().getId());
            stmt.setInt(2, depositoProduto.getProduto().getId());
            
            stmt.executeUpdate();
            //System.out.println("Inclusão realizada com sucesso!");
        } catch (SQLException e) {
            //lança a exceção ProdutoDAOException
            System.out.println(e.getMessage());
            //System.out.println("Erro ao inserir dados!!!\n" + e.getMessage());
            //e.printStackTrace();
        }
    }

    public List<DepositoProduto> findAll() throws ConexaoException{
        try {
            sql = "select deposito.id, deposito.nome, deposito.endereco, depositoproduto.iddeposito, depositoproduto.idproduto, produto.id, produto.nome, produto.precoatual, produto.quantidade from (produto inner join depositoproduto on produto.id = depositoproduto.idproduto) inner join deposito on depositoproduto.iddeposito = deposito.id order by id;";

            stmt = Conexao.getCon().prepareStatement(sql);
            
            rs = stmt.executeQuery();
            
            return carregarMultiplosResultados(rs);
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        } 
        
        return null;
    }

    private DepositoProduto carregarResultadoSimples(ResultSet rs) throws SQLException{
        if (rs.next()) {
            dto = new DepositoProduto();
            carregarVO(dto, rs);
            
            return dto;
        }else{
            return null;
        }
    }

    private List<DepositoProduto> carregarMultiplosResultados(ResultSet rs) throws SQLException{
        List<DepositoProduto> resultList = new ArrayList<>();
        while (rs.next()) {
            dto = new DepositoProduto();
            carregarVO(dto, rs);
            resultList.add(dto);
        }
        return resultList;
    }
    
    private void carregarVO(DepositoProduto dto, ResultSet rs)throws SQLException{
        Deposito deposito = new Deposito();
        deposito.setId(rs.getInt("deposito.id"));
        deposito.setEndereco(rs.getString("deposito.endereco"));
        deposito.setNome(rs.getString("deposito.nome"));
        
        Produto produto = new Produto();
        produto.setId(rs.getInt("produto.id"));
        produto.setNome(rs.getString("produto.nome"));
        produto.setPrecoAtual(rs.getDouble("produto.precoatual"));
        produto.setQuantidade(rs.getInt("produto.quantidade"));
        
        dto.setDeposito(deposito);
        dto.setProduto(produto);
    }
}
