/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.gitxadrezpoo2.modelo.cdp.pattern.Fabrica;

import poo.xadrez.modelo.cdp.Casa;
import poo.xadrez.modelo.cdp.Peca;
import poo.xadrez.modelo.cdp.Tabuleiro;

/**
 *
 * @author Junior
 */
public class FabricaPrimitiva {
    public static FabricaPrimitiva getInstance() {
        return FabricaHolder.INSTANCE;
    }
    private static class FabricaHolder {
        private static final FabricaPrimitiva INSTANCE = new FabricaPrimitiva();
    }
    public Tabuleiro ConstroiTabuleiro(){
        return new  Tabuleiro();
    }
    public Peca constroiPeca(){
        return new Peca();
    }
    public Casa ControiCasa(){
        return new Casa();
    }
}
