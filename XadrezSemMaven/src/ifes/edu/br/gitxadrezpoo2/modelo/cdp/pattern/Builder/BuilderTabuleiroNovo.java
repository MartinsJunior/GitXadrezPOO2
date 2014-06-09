/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.edu.br.gitxadrezpoo2.modelo.cdp.pattern.Builder;

import java.util.logging.Level;
import java.util.logging.Logger;
import poo.xadrez.modelo.cdp.Casa;
import poo.xadrez.modelo.cdp.CorPeca;
import poo.xadrez.modelo.cdp.Posicao;
import poo.xadrez.modelo.cdp.Tabuleiro;
import ifes.edu.br.gitxadrezpoo2.modelo.cdp.pattern.Fabrica.FabricaPecas;
import ifes.edu.br.gitxadrezpoo2.modelo.cdp.pattern.Fabrica.FabricaPrimitiva;
import poo.xadrez.modelo.cdp.TipoPeca;

/**
 *
 * @author Junior
 */
public class BuilderTabuleiroNovo extends BuilderABS implements BuilderITC {

    public void AlocarPeao() {
        InserePeao(2, CorPeca.PRETO);
        InserePeao(7, CorPeca.BRANCO);
    }

    public void AlocarTorre() {
        InsereTorre(1, CorPeca.PRETO);
        InsereTorre(8, CorPeca.BRANCO);
    }

    public void AlocarCavalo() {
        InsereCavalo(1, CorPeca.PRETO);
        InsereCavalo(8, CorPeca.BRANCO);
    }

    public void AlocarBispo() {
        InsereBispo(1, CorPeca.PRETO);
        InsereBispo(8, CorPeca.BRANCO);

    }

    public void AlocarRei() {
        InsereRei(1, CorPeca.PRETO);
        InsereRei(8, CorPeca.BRANCO);
    }

    public void AlocarRainha() {
        InsereRainha(1, CorPeca.PRETO);
        InsereRainha(8, CorPeca.BRANCO);
    }

    private void InserePeao(int contadorLinha, CorPeca cor) {
        for (int contadorColuna = 1; contadorColuna < 9; contadorColuna++) {
            tabu.getCasa("" + contadorLinha + "" + contadorColuna).setPeca(FabricaPecas.getInstance().retornaPeca(TipoPeca.PEAO, contadorLinha, contadorColuna, cor));
        }
    }

    private void InsereTorre(int contadorLinha, CorPeca cor) {
        for (int contadorColuna = 1; contadorColuna < 10; contadorColuna += 7) {
            tabu.getCasa("" + contadorLinha + "" + contadorColuna).setPeca(FabricaPecas.getInstance().ConstroiTorre(contadorLinha, contadorColuna, cor));
        }
    }

    private void InsereCavalo(int contadorLinha, CorPeca cor) {
        for (int contadorColuna = 2; contadorColuna < 10; contadorColuna += 5) {
            tabu.getCasa("" + contadorLinha + "" + contadorColuna).setPeca(FabricaPecas.getInstance().ConstroiCavalo(contadorLinha, contadorColuna, cor));
        }
    }

    private void InsereBispo(int contadorLinha, CorPeca cor) {
        for (int contadorColuna = 3; contadorColuna < 7; contadorColuna += 3) {
            tabu.getCasa("" + contadorLinha + "" + contadorColuna).setPeca(FabricaPecas.getInstance().ConstroiBispo(contadorLinha, contadorColuna, cor));
        }
    }

    private void InsereRainha(int linha, CorPeca cor) {
        tabu.getCasa("" + linha + "" + 4).setPeca(FabricaPecas.getInstance().ConstroiRainha(linha, 4, cor));

    }

    private void InsereRei(int linha, CorPeca cor) {
        tabu.getCasa("" + linha + "" + 5).setPeca(FabricaPecas.getInstance().ConstroiRei(linha, 5, cor));
    }

    public Tabuleiro CriarTabuleiro() {
        return tabu;
    }

}
