/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import com.toedter.calendar.JDateChooser;
import conexao.ConexaoException;
import dao.ClienteDAO;
import dao.DepositoDAO;
import dao.DepositoProdutoDAO;
import dao.ProdutoDAO;
import dao.VendaDAO;
import dao.VendaProdutoDAO;
import entity.Cliente;
import entity.Deposito;
import entity.DepositoProduto;
import entity.Produto;
import entity.Venda;
import entity.VendaProduto;
import exception.DiasNaoNumero;
import exception.ExcecaoComposta;
import exception.NenhumItemSelecionado;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Gerenciador {
    Venda vendaNova;
    Produto produtoNovo;
    List<DepositoProduto> produtoNovoDepositoProdutos1;
    List<DepositoProduto> produtoNovoDepositoProdutos2;
    List<VendaProduto> vendaNovaVendaProdutos1;
    List<VendaProduto> vendaNovaVendaProdutos2;
    
    public List<DepositoProduto> getProdutoNovoDepositoProdutos(){
        return produtoNovoDepositoProdutos1;
    }
    
    public void clienteInserir(Cliente cliente) throws ConexaoException {
        (new ClienteDAO()).inserir(cliente);
    }

    public void depositoInserir(Deposito deposito) throws ConexaoException {
        (new DepositoDAO()).inserir(deposito);
    }

    public void produtoIniciar() {
        produtoNovo = new Produto();
    }
    
    public void produtoAddDepositoProduto(Deposito deposito){
        if(produtoNovoDepositoProdutos1 == null){
            produtoNovoDepositoProdutos1 = new ArrayList<>();
        } 
        
        DepositoProduto depositoProduto = new DepositoProduto();
        depositoProduto.setDeposito(deposito);
        depositoProduto.setProduto(produtoNovo);
        
        produtoNovoDepositoProdutos1.add(depositoProduto);
    }
    
    public void produtoConcluir() throws ConexaoException{
        (new ProdutoDAO()).inserir(produtoNovo);
        produtoNovo = (new ProdutoDAO()).findLast();
        
        produtoNovoDepositoProdutos2 = new ArrayList<>();
        
        for(DepositoProduto depositoProduto1 : produtoNovoDepositoProdutos1){
            DepositoProduto depositoProduto2 = new DepositoProduto();
            depositoProduto2.setProduto(produtoNovo);
            depositoProduto2.setDeposito(depositoProduto1.getDeposito());
            produtoNovoDepositoProdutos2.add(depositoProduto2);
        }
        
        for(DepositoProduto depositoProduto : produtoNovoDepositoProdutos2){
            (new DepositoProdutoDAO()).inserir(depositoProduto);
        }
    }
    
    public void produtoCancelar(){
        produtoNovo = null;
    }

    public List<Produto> produtosBuscarTodos() throws ConexaoException {
        return (new ProdutoDAO()).findAll();
    }

    public List<Deposito> depositosBuscarTodos() throws ConexaoException {
        return (new DepositoDAO()).findAll();
    }

    public void produtoSetNome(String nome) {
        produtoNovo.setNome(nome);
    }

    public void produtoSetQuantidade(int quantidade) {
        produtoNovo.setQuantidade(quantidade);
    }
    
    public void produtoSetPreco(double preco) {
        produtoNovo.setPrecoAtual(preco);
    }

    public void vendaIniciar() {
        vendaNova = new Venda();
    }

    public List<Cliente> clientesBuscarTodos() throws ConexaoException {
        return (new ClienteDAO()).findAll();
    }

    public void vendaAddVendaProduto(Produto produto, int quantidade) {
        if(vendaNovaVendaProdutos1 == null){
            vendaNovaVendaProdutos1 = new ArrayList<>();
        } 
        
        VendaProduto vendaProduto = new VendaProduto();
        vendaProduto.setProduto(produto);
        vendaProduto.setQuantidade(quantidade);
        
        vendaNovaVendaProdutos1.add(vendaProduto);
    }

    public Iterable<VendaProduto> getVendaNovaVendaProdutos() {
        return vendaNovaVendaProdutos1;
    }

    public double vendaNovaGetSubtotal() {
        return vendaNova.getSubtotalSoma();
    }

    public double vendaNovaGetTotal() {
        return vendaNova.getValorTotal();
    }

    public void vendaNovaCalcular() {
        Double subtotal = 0.00;
        for(VendaProduto vendaProduto : vendaNovaVendaProdutos1){
            subtotal += vendaProduto.getProduto().getPrecoAtual() *
                    vendaProduto.getQuantidade();
        }
        
        Double total =  (1 + 0.005 * vendaNova.getDias()) * subtotal;
        vendaNova.setSubtotalSoma(subtotal);
        vendaNova.setValorTotal(total);
    }

    public void vendaNovaSetPagamentoForma(String forma) {
        vendaNova.setPagamentoForma(forma);
    }

    public void vendaNovaSetDias(int dias) {
        vendaNova.setDias(dias);
    }

    public void vendaNovaSetData(Date date) {
        vendaNova.setData(date);
    }

    public void vendaNovaSetCliente(Cliente cliente) {
        vendaNova.setCliente(cliente);
    }

    public void vendaFinalizar() throws ConexaoException {
        (new VendaDAO()).inserir(vendaNova);
        vendaNova = (new VendaDAO()).findLast();
        
        vendaNovaVendaProdutos2 = new ArrayList<>();
        
        for(VendaProduto vendaProduto1 : vendaNovaVendaProdutos1){
            VendaProduto vendaProduto2 = new VendaProduto();
            vendaProduto2.setVenda(vendaNova);
            vendaProduto2.setProduto(vendaProduto1.getProduto());
            vendaProduto2.setQuantidade(vendaProduto1.getQuantidade());
            vendaNovaVendaProdutos2.add(vendaProduto2);
            

        }
        
        for(VendaProduto vendaProduto : vendaNovaVendaProdutos2){
            (new VendaProdutoDAO()).inserir(vendaProduto);
            (new ProdutoDAO()).atualizarQuantidade(vendaProduto.getProduto(),
            vendaProduto.getProduto().getQuantidade() - vendaProduto.getQuantidade());
        }
    }

    public List<Venda> vendaBuscarPorData(Date dataInicio, Date dataFim) throws ConexaoException {
        return (new VendaDAO()).findAllPorData(dataInicio, dataFim);
    }

    public List<VendaProduto> vendaFindProdutos(Venda venda) throws ConexaoException {
        return (new VendaProdutoDAO()).findAllPorVenda(venda);
    }

        public List<Produto> produtoBuscarTodos() {
        try{
            ProdutoDAO produtoDAO = new ProdutoDAO();
            List<Produto> produtos = produtoDAO.findAll();
            
//            if(produtos.size() < 1){
//                ExcecaoComposta exComp = new ExcecaoComposta();
//                exComp.excecaoAdicionar(new NaoHaProdutosCadastrados());
//                
//                throw exComp;
//            }
            
            return produtos;
        } catch (ConexaoException ex) {
            Logger.getLogger(Gerenciador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public void produtoAdicionarQuantidade(Produto produto, Integer quantidade) {
        try {
            ProdutoDAO produtoDAO = new ProdutoDAO();

            produtoDAO.atualizarQuantidade(produto,
                    quantidade + produto.getQuantidade());
        } catch (ConexaoException ex) {
            Logger.getLogger(Gerenciador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void vendaCalcularFailTeste(String dias) throws ExcecaoComposta {
        ExcecaoComposta exComp = new ExcecaoComposta();
        
        if(!dias.matches("-?\\d+(\\.\\d+)?") && vendaNova.getPagamentoForma().equals("aprazo")){
            exComp.excecaoAdicionar(new DiasNaoNumero());
        }
        
        if(vendaNovaVendaProdutos1 == null || vendaNovaVendaProdutos1.size() < 1){
            exComp.excecaoAdicionar(new NenhumItemSelecionado());
        }
        
        if(exComp.getSize() > 0){
            throw exComp;
        }
    }
}
