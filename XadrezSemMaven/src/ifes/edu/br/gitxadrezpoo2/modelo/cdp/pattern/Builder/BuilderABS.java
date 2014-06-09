/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.gitxadrezpoo2.modelo.cdp.pattern.Builder;

import poo.xadrez.modelo.cdp.Casa;
import poo.xadrez.modelo.cdp.Peca;
import poo.xadrez.modelo.cdp.Tabuleiro;
import ifes.edu.br.gitxadrezpoo2.modelo.cdp.pattern.Fabrica.FabricaPrimitiva;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Junior
 */
public abstract class BuilderABS {
    protected Tabuleiro tabu = FabricaPrimitiva.getInstance().ConstroiTabuleiro();
    protected Peca PECA = null;
    protected Peca PEAO_BRANCO = null;
    protected Peca PEAO_PRETO = null;
    protected Casa CASA = null;
    
    public void AlocarCasa() {
        String id = "";
        // colocando casas no tabuleiro
        for (int linha = 1; linha < 9; linha++) {
            for (int coluna = 1; coluna < 9; coluna++) {
                if (CASA == null) {
                    Casa casaTabuleiro = FabricaPrimitiva.getInstance().ControiCasa();
                    CASA = casaTabuleiro;
                    casaTabuleiro.setPosicao(linha, coluna);
                    id = "" + linha + "" + coluna;
                    tabu.getTabuleiro().put(id, casaTabuleiro);
                } else {
                    try {
                        Casa input = CASA.clone();
                        input.setPosicao(linha, coluna);
                        id = "" + linha + "" + coluna;
                        tabu.getTabuleiro().put(id, input);
                    } catch (CloneNotSupportedException ex) {
                        Logger.getLogger(BuilderTabuleiroNovo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

}
