/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.gitxadrezpoo2.modelo.cdp.pattern.Fabrica;

import poo.xadrez.modelo.cdp.CorPeca;
import poo.xadrez.modelo.cdp.Peca;

/**
 *
 * @author Junior
 */
public interface FabricaPecasITC {
    public Peca ConstroiPeao(int linha, int coluna, CorPeca cor);
    public Peca ConstroiTorre(int linha, int coluna, CorPeca cor);
    public Peca ConstroiCavalo(int linha, int coluna, CorPeca cor);
    public Peca ConstroiBispo(int linha, int coluna, CorPeca cor);
    public Peca ConstroiRainha(int linha, int coluna, CorPeca cor);
    public Peca ConstroiRei(int linha, int coluna, CorPeca cor);
}
