package poo.xadrez.modelo.cdp;

import ifes.edu.br.gitxadrezpoo2.bd.cgd.ObjetoPersistente;
import java.util.ArrayList;
import java.util.List;
import poo.xadrez.modelo.cdp.movimento.Movimento;

public class Peca extends ObjetoPersistente implements PecaInterface {

    public int valorEmPontos;
    public TipoPeca tipoPeca;
    protected int jaMovimentou;
    public Posicao posicao;
    public CorPeca cor;
    public List<Movimento> movimentos = new ArrayList<Movimento>();

    @Override
    public Peca clone() throws CloneNotSupportedException {
        return (Peca)super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    public int getValorEmPontos() {
        return valorEmPontos;
    }

    public void setValorEmPontos(int valorEmPontos) {
        this.valorEmPontos = valorEmPontos;
    }

    public int getJaMovimentou() {
        return jaMovimentou;
    }

    public void setJaMovimentou(int jaMovimentou) {
        this.jaMovimentou = jaMovimentou;
    }

    public CorPeca getCor() {
        return cor;
    }

    public TipoPeca getTipoPeca() {
        return tipoPeca;
    }

    public void setTipoPeca(TipoPeca tipoPeca) {
        this.tipoPeca = tipoPeca;
    }

    public void setCor(CorPeca cor) {
        this.cor = cor;
    }
    public void addMovimento(Movimento movimento) {
        this.movimentos.add(movimento);
    }
    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(int linha,int coluna) {
        this.posicao = new Posicao(linha, coluna);
    }

    public List<Movimento> getMovimentos() {
        return movimentos;
    }

    public void setMovimentos(List<Movimento> movimentos) {
        this.movimentos = movimentos;
    }

    public boolean verificaMovimentoValido(Tabuleiro tabuleiro, Posicao p_inicial, Posicao p_final) {
        ArrayList<Posicao> validos = new ArrayList<Posicao>();
        validos = movimentosValidos(tabuleiro, p_inicial, p_final);
        return (contemPosicao(validos, p_final));
    }

    public ArrayList<Posicao> movimentosValidos(Tabuleiro tabuleiro, Posicao p_inicial, Posicao p_final) {
        ArrayList<Posicao> posicoesValidas = new ArrayList<Posicao>();
        for (Movimento movimento : movimentos) {
            posicoesValidas.addAll(movimento.validarMovimento(tabuleiro, p_inicial, p_final, this));
        }
        return posicoesValidas;
    }

    public boolean contemPosicao(ArrayList<Posicao> validos, Posicao posicao) {
        for (int contador = 0; contador < validos.size(); contador++) {
            if (posicao.linha == validos.get(contador).linha
                    && posicao.coluna == validos.get(contador).coluna) {

                return true;
            }

        }
        return false;
    }
    public void imprime(ArrayList<Posicao> movimentosValidos) {
        for (int contador = 0; contador < movimentosValidos.size(); contador++) {
            movimentosValidos.get(contador).imprime();
        }
    }
    public boolean verificaCapitura(Tabuleiro tabuleiro, Posicao posicaoInicial, Posicao posicaoFinal, Posicao pAtual) {
        if (posicaoFinal.compara(pAtual)) {
            CorPeca coratual = tabuleiro.getPeca(posicaoInicial).getCor();
            CorPeca corpecafinal = tabuleiro.getPeca(posicaoFinal).getCor();
            if (!coratual.equals(corpecafinal)) {
                return true;
            }
        }
        return false;
    }
}