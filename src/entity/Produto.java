/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Admin
 */
public class Produto {
    private int id;
    private String nome;
    private double precoAtual;
    private int quantidade;

    public String toString(){
        return nome;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }
   
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * @return the precoAtual
     */
    public double getPrecoAtual() {
        return precoAtual;
    }

    /**
     * @param precoAtual the precoAtual to set
     */
    public void setPrecoAtual(double precoAtual) {
        this.precoAtual = precoAtual;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    
    
}
