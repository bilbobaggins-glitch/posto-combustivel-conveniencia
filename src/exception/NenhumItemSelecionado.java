/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Admin
 */
public class NenhumItemSelecionado implements IMinhaExcecao {

    @Override
    public String getMensagem() {
        return "Insira um item no carrinho!";
    }
    
}
