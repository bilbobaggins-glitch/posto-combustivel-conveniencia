/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import conexao.ConexaoException;
import entity.Produto;
import entity.Venda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author aluno
 */
public class ProdutoDAO {
    String sql;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    Produto dto;
    
    Produto produtoResultado;
    List<Produto> produtosResultado;
    
    public void inserir(Produto produto) throws ConexaoException{
        try {
            sql = "insert into produto (nome, precoatual, quantidade) " +
                  "values (?, ?, ?);";
            
            stmt = Conexao.getCon().prepareStatement(sql);
            
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPrecoAtual());
            stmt.setInt(3, produto.getQuantidade());
            
            stmt.executeUpdate();
            //System.out.println("Inclusão realizada com sucesso!");
        } catch (SQLException e) {
            //lança a exceção ProdutoException
            System.out.println(e.getMessage());
            //System.out.println("Erro ao inserir dados!!!\n" + e.getMessage());
            //e.printStackTrace();
        }
    }

    public List<Produto> findAll() throws ConexaoException{
        try {
            sql ="select produto.id, produto.nome, produto.precoatual, produto.quantidade from produto order by produto.id;";

            stmt = Conexao.getCon().prepareStatement(sql);
            
            rs = stmt.executeQuery();
            
            return carregarMultiplosResultados(rs);
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        } 
        
        return null;
    }

    public Produto findLast() throws ConexaoException{
        try {
            sql ="select produto.id, produto.nome, produto.precoatual, produto.quantidade from produto order by id desc limit 1;";

            stmt = Conexao.getCon().prepareStatement(sql);
            rs = stmt.executeQuery();
            
            return carregarResultadoSimples(rs);
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        } 
        
        return null;
    }
    
    private Produto carregarResultadoSimples(ResultSet rs) throws SQLException{
        if (rs.next()) {
            dto = new Produto();
            carregarVO(dto, rs);
            
            return dto;
        }else{
            return null;
        }
    }

    private List<Produto> carregarMultiplosResultados(ResultSet rs) throws SQLException{
        List<Produto> resultList = new ArrayList<>();
        while (rs.next()) {
            dto = new Produto();
            carregarVO(dto, rs);
            resultList.add(dto);
        }
        return resultList;
    }
    
    private void carregarVO(Produto dto, ResultSet rs)throws SQLException{
        dto.setId(rs.getInt("produto.id"));
        dto.setNome(rs.getString("produto.nome"));
        dto.setPrecoAtual(rs.getDouble("produto.precoatual"));
        dto.setQuantidade(rs.getInt("produto.quantidade"));
    }

    public void atualizarQuantidade(Produto produto, int quantidade) throws ConexaoException {
        try {
            sql = "update produto set quantidade = ? where id = ?; ";
            
            stmt = Conexao.getCon().prepareStatement(sql);
            
            stmt.setInt(1, quantidade);
            stmt.setInt(2, produto.getId());
            
            stmt.executeUpdate();
            //System.out.println("Inclusão realizada com sucesso!");
        } catch (SQLException e) {
            //lança a exceção ProdutoDAOException
            System.out.println(e.getMessage());
            //System.out.println("Erro ao inserir dados!!!\n" + e.getMessage());
            //e.printStackTrace();
        }
    }
}
