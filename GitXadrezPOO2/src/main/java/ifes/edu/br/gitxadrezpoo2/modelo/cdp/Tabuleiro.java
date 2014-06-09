package poo.xadrez.modelo.cdp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Tabuleiro implements Serializable {

    protected Map<String, Casa> tabuleiro = new HashMap<String, Casa>();

    public Map<String, Casa> getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Map<String, Casa> tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public Peca getPeca(Posicao posicao) {
        Casa casa = tabuleiro.get("" + posicao.getLinha() + "" + posicao.getColuna());
        return casa.getPeca();
    }

    public void setPeca(Peca peca, Posicao posicao) {
        Casa casa = tabuleiro.get("" + posicao.getLinha() + "" + posicao.getColuna());
        casa.setPeca(peca);
        tabuleiro.put("" + posicao.getLinha() + "" + posicao.getColuna(), casa);
    }

    public boolean existePeca(int linha, int coluna) {
        Casa casa = tabuleiro.get("" + linha + "" + coluna);
        if (casa.getPeca() == null) {
            return false;
        }
        return true;
    }

    public void movimentapeca(Posicao posicaoInicial, Posicao posicaoFinal, Jogador jogadorAtual) {
        Casa casaFinal = tabuleiro.get("" + posicaoFinal.getLinha() + "" + posicaoFinal.getColuna());

        Casa casaInicial = tabuleiro.get("" + posicaoInicial.getLinha() + "" + posicaoInicial.getColuna());
        Peca pecaFinal = casaFinal.getPeca();
        if (pecaFinal != null) {
            int pontuacao = jogadorAtual.getPontuacao();
            int pontuacaoDaPeca = pecaFinal.getValorEmPontos();
            jogadorAtual.setPontuacao(pontuacao + pontuacaoDaPeca);
        }
        Peca pecaInicial = casaInicial.getPeca();
        pecaInicial.setJaMovimentou(1);
        pecaInicial.setPosicao(posicaoFinal.getLinha(), posicaoFinal.getColuna());
        casaFinal.setPeca(pecaInicial);
        casaInicial.setPeca(null);
    }

    public CorPeca getCor(Posicao posicaoAtual) {
        Casa casa = tabuleiro.get("" + posicaoAtual.getLinha() + "" + posicaoAtual.getColuna());
        return (casa.getPeca().getCor());
    }

    public boolean verificaCheque(Posicao posicaoCasa, CorPeca cor) {

        for (int contadorLinha = 1; contadorLinha < 9; contadorLinha++) {
            for (int contadorColuna = 1; contadorColuna < 9; contadorColuna++) {
                Casa casa = tabuleiro.get("" + contadorLinha + "" + contadorColuna);
                Peca pecaAtual = casa.getPeca();
                if (pecaAtual != null && pecaAtual.getCor().equals(cor)) {
                    Posicao posicaopecaAtual = pecaAtual.getPosicao();
                    boolean resposta = pecaAtual.verificaMovimentoValido(this, posicaopecaAtual, posicaoCasa);
                    if (resposta) {
                        return true;
                    }

                }

            }
        }
        return false;
    }

    public Posicao getRei(CorPeca cor) {
        for (int contadorLinha = 1; contadorLinha < 9; contadorLinha++) {
            for (int contadorColuna = 1; contadorColuna < 9; contadorColuna++) {
                Casa casa = tabuleiro.get("" + contadorLinha + "" + contadorColuna);
                Peca pecaAtual = casa.getPeca();
                if (pecaAtual != null && pecaAtual.getTipoPeca().equals(TipoPeca.REI) && !pecaAtual.getCor().equals(cor)) {
                    Posicao posicaoRei = new Posicao(contadorLinha, contadorColuna);
                    return posicaoRei;
                }
            }
        }
        return null;
    }

    public void imprime() {
        for (int contadorLinha = 1; contadorLinha < 9; contadorLinha++) {
            for (int contadorColuna = 1; contadorColuna < 9; contadorColuna++) {
                Casa casa = tabuleiro.get("" + contadorLinha + "" + contadorColuna);
                Peca pecaAtual = casa.getPeca();
                if (pecaAtual != null) {
                    pecaAtual.setPosicao(contadorLinha, contadorColuna);
                    System.out.print(" " + pecaAtual.getTipoPeca() + "(" + pecaAtual.getPosicao().getLinha() + ',' + pecaAtual.getPosicao().getColuna() + ")");
                } else {
                    System.out.print(" VAZIO");
                }
            }
            System.out.println("");
        }
    }

    public Casa getCasa(String string) {
        return tabuleiro.get(string);
    }

    public Casa getCasa(Posicao posicao) {
        return tabuleiro.get("" + posicao.getLinha() + "" + posicao.getColuna());
    }
}
