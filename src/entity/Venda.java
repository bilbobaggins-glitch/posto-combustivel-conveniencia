/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Venda {
    private int id;
    private Date data;
    private int dias;
    private Cliente cliente;
    private String pagamentoForma;
    private double subtotalSoma;
    private double valorTotal;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the pagamentoForma
     */
    public String getPagamentoForma() {
        return pagamentoForma;
    }

    /**
     * @param pagamentoForma the pagamentoForma to set
     */
    public void setPagamentoForma(String pagamentoForma) {
        this.pagamentoForma = pagamentoForma;
    }

    /**
     * @return the subtotalSoma
     */
    public double getSubtotalSoma() {
        return subtotalSoma;
    }

    /**
     * @param subtotalSoma the subtotalSoma to set
     */
    public void setSubtotalSoma(double subtotalSoma) {
        this.subtotalSoma = subtotalSoma;
    }

    /**
     * @return the valorTotal
     */
    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }



}
