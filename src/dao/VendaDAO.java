/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import conexao.ConexaoException;
import entity.Cliente;
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
public class VendaDAO {
    String sql;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    Venda dto;
    
    Venda vendaResultado;
    List<Venda> vendasResultado;
    
    public void inserir(Venda venda) throws ConexaoException{
        try {
            sql = "insert into venda (pagamentoforma, subtotalsoma, valortotal, idcliente, data, dias) " +
                  "values (?, ?, ?, ?, ?, ?);";
            
            stmt = Conexao.getCon().prepareStatement(sql);
            
            java.sql.Date dataSQL;
            
            stmt.setString(1, venda.getPagamentoForma());
            stmt.setDouble(2, venda.getSubtotalSoma());
            stmt.setDouble(3, venda.getValorTotal());
            stmt.setInt(4, venda.getCliente().getId());
            dataSQL = new java.sql.Date(venda.getData().getTime());
            stmt.setDate(5, dataSQL);
            stmt.setInt(6, venda.getDias());
            
            stmt.executeUpdate();
            //System.out.println("Inclusão realizada com sucesso!");
        } catch (SQLException e) {
            //lança a exceção ProdutoDAOException
            System.out.println(e.getMessage());
            //System.out.println("Erro ao inserir dados!!!\n" + e.getMessage());
            //e.printStackTrace();
        }
    }
    
    public Venda findLast() throws ConexaoException{
        try {
            sql = "select venda.id, venda.pagamentoforma, venda.subtotalsoma, venda.valortotal, venda.idcliente, venda.data, venda.dias, cliente.id, cliente.nome, cliente.cpf from venda inner join cliente on venda.idcliente = cliente.id order by venda.id desc limit 1;";

            stmt = Conexao.getCon().prepareStatement(sql);
            
            rs = stmt.executeQuery();
            
            return carregarResultadoSimples(rs);
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        } 
        
        return null;
    }
    
    public List<Venda> findAllPorData(java.util.Date dataInicio, java.util.Date dataFim) throws ConexaoException {
        try { 
            sql = "select venda.id, venda.pagamentoforma, venda.subtotalsoma, venda.valortotal, venda.idcliente, venda.data, venda.dias, cliente.id, cliente.nome, cliente.cpf from venda inner join cliente on venda.idcliente = cliente.id where venda.data > ? AND venda.data < ? order by venda.id;";

            stmt = Conexao.getCon().prepareStatement(sql);
            
            java.sql.Date dataSqlInicio = new java.sql.Date(dataInicio.getTime());
            stmt.setDate(1, dataSqlInicio);
            java.sql.Date dataSqlFim = new java.sql.Date(dataFim.getTime());
            stmt.setDate(2, dataSqlFim);
            
            rs = stmt.executeQuery();
            
            return carregarMultiplosResultados(rs);
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        } 
        
        return null;
    }

    public List<Venda> findAll() throws ConexaoException{
        try {
            sql = "select venda.id, venda.pagamentoforma, venda.subtotal, venda.valortotal, venda.idcliente, venda.data, venda.dias, cliente.id, cliente.nome, cliente.cpf from venda inner join cliente on venda.idcliente = cliente.id order by venda.id;";

            stmt = Conexao.getCon().prepareStatement(sql);
            
            rs = stmt.executeQuery();
            
            return carregarMultiplosResultados(rs);
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        } 
        
        return null;
    }

    private Venda carregarResultadoSimples(ResultSet rs) throws SQLException{
        if (rs.next()) {
            dto = new Venda();
            carregarVO(dto, rs);
            
            return dto;
        }else{
            return null;
        }
    }

    private List<Venda> carregarMultiplosResultados(ResultSet rs) throws SQLException{
        List<Venda> resultList = new ArrayList<>();
        while (rs.next()) {
            dto = new Venda();
            carregarVO(dto, rs);
            resultList.add(dto);
        }
        return resultList;
    }
    
    private void carregarVO(Venda dto, ResultSet rs)throws SQLException{
        java.util.Date dataUtil;
        
        dto.setId(rs.getInt("venda.id"));
        dto.setPagamentoForma(rs.getString("venda.pagamentoforma"));
        dto.setSubtotalSoma(rs.getDouble("venda.subtotalsoma"));
        dto.setValorTotal(rs.getDouble("venda.valortotal"));
        dto.setDias(rs.getInt("venda.dias"));
        dataUtil = new java.util.Date(rs.getDate("venda.data").getTime());
        dto.setData(dataUtil);
        
        Cliente cliente = new Cliente();
        cliente.setId(rs.getInt("cliente.id"));
        cliente.setNome(rs.getString("cliente.nome"));
        cliente.setCpf(rs.getString("cliente.cpf"));
        dto.setCliente(cliente);
    }
}
