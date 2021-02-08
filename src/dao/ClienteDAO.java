/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import conexao.ConexaoException;
import entity.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author aluno
 */
public class ClienteDAO {
    String sql;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    Cliente dto;
    
    Cliente clienteResultado;
    List<Cliente> clientesResultado;
    
    public void inserir(Cliente cliente) throws ConexaoException{
        try {
            sql = "insert into cliente (nome, cpf, sexo, telefone, endereco, datadenascimento) " +
                  "values (?, ?, ?, ?, ?, ?);";
            
            stmt = Conexao.getCon().prepareStatement(sql);
            
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getSexo());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getEndereco());
            java.sql.Date dataSQL = new java.sql.Date(cliente.getDataDeNascimento().getTime());
            stmt.setDate(6, dataSQL);
            
            stmt.executeUpdate();
            //System.out.println("Inclusão realizada com sucesso!");
        } catch (SQLException e) {
            //lança a exceção ProdutoDAOException
            System.out.println(e.getMessage());
            //System.out.println("Erro ao inserir dados!!!\n" + e.getMessage());
            //e.printStackTrace();
        }
    }

    public List<Cliente> findAll() throws ConexaoException{
        try {
            sql = "select cliente.id, cliente.nome, cliente.cpf, cliente.sexo, cliente.telefone, cliente.endereco, cliente.datadenascimento from cliente order by cliente.id;";

            stmt = Conexao.getCon().prepareStatement(sql);
            
            rs = stmt.executeQuery();
            
            return carregarMultiplosResultados(rs);
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        } 
        
        return null;
    }

    private Cliente carregarResultadoSimples(ResultSet rs) throws SQLException{
        if (rs.next()) {
            dto = new Cliente();
            carregarVO(dto, rs);
            
            return dto;
        }else{
            return null;
        }
    }

    private List<Cliente> carregarMultiplosResultados(ResultSet rs) throws SQLException{
        List<Cliente> resultList = new ArrayList<>();
        while (rs.next()) {
            dto = new Cliente();
            carregarVO(dto, rs);
            resultList.add(dto);
        }
        return resultList;
    }
    
    private void carregarVO(Cliente dto, ResultSet rs)throws SQLException{
        dto.setId(rs.getInt("cliente.id"));
        dto.setNome(rs.getString("cliente.nome"));
        dto.setCpf(rs.getString("cliente.cpf"));
        dto.setDataDeNascimento(rs.getDate("cliente.datadenascimento"));
        dto.setEndereco(rs.getString("cliente.endereco"));
        dto.setSexo(rs.getString("cliente.sexo"));
        dto.setTelefone(rs.getString("cliente.telefone"));
    }
}
