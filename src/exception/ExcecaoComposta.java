/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ExcecaoComposta extends Exception{
    List<IMinhaExcecao> excecoes = new ArrayList<>();
    
    public String getMensagem(){
        String mensagemComposta = "";
        
        for(IMinhaExcecao minhaExcecao : excecoes){
            mensagemComposta += minhaExcecao.getMensagem()+"\n";
        }
        
        return mensagemComposta;
    }
    
    public void excecaoAdicionar(IMinhaExcecao ex){
        excecoes.add(ex);
    }
    
    public int getSize(){
        return excecoes.size();
    }

    public void exibirJanela(JFrame frame) {
        JOptionPane.showMessageDialog(frame,
        getMensagem(),
        "ERRO!!!",
        JOptionPane.ERROR_MESSAGE);
    }
}
