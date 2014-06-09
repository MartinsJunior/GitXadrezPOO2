/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.xadrez.cci;

import ifes.edu.br.gitxadrezpoo2.bd.cgd.BuscaInfoEmBancoDeDados;
import java.util.ArrayList;
import poo.xadrez.modelo.cdp.Jogo;
import poo.xadrez.modelo.cdp.JogoCompleto;
import poo.xadrez.modelo.cdp.Tabuleiro;
import poo.xadrez.rn.cgt.AplPrincipal;
import poo.xadrez.tela.cih.TelaJogosSalvos;

/**
 *
 * @author 20102bsi0138
 */
public class CtrlJogosSalvos {

    BuscaInfoEmBancoDeDados ctrlBusca = new BuscaInfoEmBancoDeDados();

    public void start() {
        TelaJogosSalvos telaJogosSalvos = new TelaJogosSalvos();
    }

    public ArrayList<Jogo> busca() {
        return ctrlBusca.buscaJogos();
    }


    public void recomecaJogo(int id) {
        JogoCompleto jogoCompleto = ctrlBusca.recuperaPartida(id);
        Jogo jogoAtual = jogoCompleto.getJogo();
        Tabuleiro tabuleiro = jogoCompleto.getTabuleiro();
        int vezJogador = jogoCompleto.getVezJogador();
        CtrlPainelPrincipal ctrlPainelPrincipal = new CtrlPainelPrincipal(jogoAtual,tabuleiro,vezJogador);
        ctrlPainelPrincipal.iniciarJogo();
    }

    public boolean deletaJogo(String nomeJogoAtual) {
       return ctrlBusca.deletaJogo(nomeJogoAtual);
    }
}
