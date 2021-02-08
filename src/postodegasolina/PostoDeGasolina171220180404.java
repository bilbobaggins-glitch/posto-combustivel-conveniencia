/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postodegasolina171220180404;

import gui.JanelaPrincipal;
import manager.Gerenciador;

/**
 *
 * @author Admin
 */
public class PostoDeGasolina171220180404 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Gerenciador gerenciador = new Gerenciador();
        JanelaPrincipal janelaPrincipal = new JanelaPrincipal(gerenciador);
        janelaPrincipal.setVisible(true);
    }
    
}
