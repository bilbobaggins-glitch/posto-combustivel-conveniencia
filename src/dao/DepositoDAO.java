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
import entity.Deposito;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author aluno
 */
public class DepositoDAO {
    String sql;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    Deposito dto;
    
    Deposito depositoResultado;
    List<Deposito> depositosResultado;
    
    public void inserir(Deposito deposito) throws ConexaoException{
        try {
            sql = "insert into deposito (nome, endereco) " +
                  "values (?, ?);";
            
            stmt = Conexao.getCon().prepareStatement(sql);
            
            java.sql.Date dataSQL;
            
            stmt.setString(1, deposito.getNome());
            stmt.setString(2, deposito.getEndereco());
            
            stmt.executeUpdate();
            //System.out.println("Inclusão realizada com sucesso!");
        } catch (SQLException e) {
            //lança a exceção ProdutoDAOException
            System.out.println(e.getMessage());
            //System.out.println("Erro ao inserir dados!!!\n" + e.getMessage());
            //e.printStackTrace();
        }
    }

    public List<Deposito> findAll() throws ConexaoException{
        try {
            sql = "select * from deposito order by id;";

            stmt = Conexao.getCon().prepareStatement(sql);
            
            rs = stmt.executeQuery();
            
            return carregarMultiplosResultados(rs);
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        } 
        
        return null;
    }

    private Deposito carregarResultadoSimples(ResultSet rs) throws SQLException{
        if (rs.next()) {
            dto = new Deposito();
            carregarVO(dto, rs);
            
            return dto;
        }else{
            return null;
        }
    }

    private List<Deposito> carregarMultiplosResultados(ResultSet rs) throws SQLException{
        List<Deposito> resultList = new ArrayList<>();
        while (rs.next()) {
            dto = new Deposito();
            carregarVO(dto, rs);
            resultList.add(dto);
        }
        return resultList;
    }
    
    private void carregarVO(Deposito dto, ResultSet rs) throws SQLException{
        java.util.Date dataUtil;
        
        dto.setId(rs.getInt("deposito.id"));
        dto.setNome(rs.getString("deposito.nome"));
        dto.setEndereco(rs.getString("deposito.endereco"));
    }
}
