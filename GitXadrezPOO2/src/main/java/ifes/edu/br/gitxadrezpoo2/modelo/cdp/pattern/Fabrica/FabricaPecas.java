/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.edu.br.gitxadrezpoo2.modelo.cdp.pattern.Fabrica;

import poo.xadrez.modelo.cdp.CorPeca;
import poo.xadrez.modelo.cdp.Peca;
import poo.xadrez.modelo.cdp.TipoPeca;
import poo.xadrez.modelo.cdp.movimento.AndarDiagonais;
import poo.xadrez.modelo.cdp.movimento.AndarDoRei;
import poo.xadrez.modelo.cdp.movimento.AndarEmL;
import poo.xadrez.modelo.cdp.movimento.AndarHorizontal;
import poo.xadrez.modelo.cdp.movimento.AndarPeao;
import poo.xadrez.modelo.cdp.movimento.AndarVertical;

/**
 *
 * @author Junior
 */
public class FabricaPecas extends FabricaPecasABS {

    public static FabricaPecas getInstance() {
        return FabricaPecasHolder.INSTANCE;
    }

    private static class FabricaPecasHolder {

        private static final FabricaPecas INSTANCE = new FabricaPecas();
    }

    public Peca retornaPeca(TipoPeca nomePeca, int linha, int coluna, CorPeca cor) {
        if (nomePeca.equals(TipoPeca.PEAO)) {
            return ConstroiPeao(linha, coluna, cor);
        } else {
            if (nomePeca.equals(TipoPeca.TORRE)) {
                return ConstroiTorre(linha, coluna, cor);
            } else {
                if (nomePeca.equals(TipoPeca.CAVALO)) {
                    return ConstroiCavalo(linha, coluna, cor);
                } else {
                    if (nomePeca.equals(TipoPeca.BISPO)) {
                        return ConstroiBispo(linha, coluna, cor);
                    } else {
                        if (nomePeca.equals(TipoPeca.RAINHA)) {
                            return ConstroiRainha(linha, coluna, cor);
                        } else {
                            return ConstroiRei(linha, coluna, cor);
                        }
                    }
                }
            }
        }
    }
    public Peca ConstroiPeao(int linha, int coluna, CorPeca cor) {
        PECA_ABS = FabricaPrimitiva.getInstance().constroiPeca();
        PECA_ABS.tipoPeca = TipoPeca.PEAO;
        PECA_ABS.setPosicao(linha, coluna);
        PECA_ABS.setCor(cor);
        PECA_ABS.movimentos.clear();
        PECA_ABS.movimentos.add(new AndarPeao());
        PECA_ABS.valorEmPontos = 1;
        return PECA_ABS;
    }

    public Peca ConstroiTorre(int linha, int coluna, CorPeca cor) {
        PECA_ABS = FabricaPrimitiva.getInstance().constroiPeca();
        PECA_ABS.tipoPeca = TipoPeca.TORRE;
        PECA_ABS.setPosicao(linha, coluna);
        PECA_ABS.setCor(cor);
        PECA_ABS.movimentos.clear();
        PECA_ABS.movimentos.add(new AndarVertical());
        PECA_ABS.movimentos.add(new AndarHorizontal());
        PECA_ABS.valorEmPontos = 5;
        return PECA_ABS;
    }

    public Peca ConstroiCavalo(int linha, int coluna, CorPeca cor) {
        PECA_ABS = FabricaPrimitiva.getInstance().constroiPeca();
        PECA_ABS.tipoPeca = TipoPeca.CAVALO;
        PECA_ABS.setPosicao(linha, coluna);
        PECA_ABS.setCor(cor);
        PECA_ABS.movimentos.clear();
        PECA_ABS.movimentos.add(new AndarEmL());
        PECA_ABS.valorEmPontos = 3;
        return PECA_ABS;
    }

    public Peca ConstroiBispo(int linha, int coluna, CorPeca cor) {
        PECA_ABS = FabricaPrimitiva.getInstance().constroiPeca();
        PECA_ABS.tipoPeca = TipoPeca.BISPO;
        PECA_ABS.setPosicao(linha, coluna);
        PECA_ABS.setCor(cor);
        PECA_ABS.movimentos.clear();
        PECA_ABS.movimentos.add(new AndarDiagonais());
        PECA_ABS.valorEmPontos = 3;
        return PECA_ABS;
    }

    public Peca ConstroiRainha(int linha, int coluna, CorPeca cor) {
        PECA_ABS = FabricaPrimitiva.getInstance().constroiPeca();
        PECA_ABS.tipoPeca = TipoPeca.RAINHA;
        PECA_ABS.setPosicao(linha, coluna);
        PECA_ABS.setCor(cor);
        PECA_ABS.movimentos.clear();
        PECA_ABS.movimentos.add(new AndarDiagonais());
        PECA_ABS.movimentos.add(new AndarVertical());
        PECA_ABS.movimentos.add(new AndarHorizontal());
        PECA_ABS.valorEmPontos = 9;
        return PECA_ABS;
    }

    public Peca ConstroiRei(int linha, int coluna, CorPeca cor) {
        PECA_ABS = FabricaPrimitiva.getInstance().constroiPeca();
        PECA_ABS.tipoPeca = TipoPeca.REI;
        PECA_ABS.setPosicao(linha, coluna);
        PECA_ABS.setCor(cor);
        PECA_ABS.movimentos.clear();
        PECA_ABS.movimentos.add(new AndarDoRei());
        PECA_ABS.valorEmPontos = 0;
        return PECA_ABS;
    }
}
