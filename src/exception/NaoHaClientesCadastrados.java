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
public class NaoHaClientesCadastrados implements IMinhaExcecao {

    @Override
    public String getMensagem() {
        return "Cadastre um cliente para poder abrir esse painel! ";
    }
    
}
