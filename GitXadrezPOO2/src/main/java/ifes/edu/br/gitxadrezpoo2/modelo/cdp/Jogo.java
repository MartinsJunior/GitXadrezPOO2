package poo.xadrez.modelo.cdp;

import ifes.edu.br.gitxadrezpoo2.bd.cgd.ObjetoPersistente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Jogo extends ObjetoPersistente implements Serializable{
    private List<Jogador> jogador = new ArrayList<Jogador>();
    private String nomeJogo;
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getnomeJogo() {
        return nomeJogo;
    }

    public void setnomeJogo(String NomeJogo) {
        this.nomeJogo = NomeJogo;
    }
    public Jogo() {
    }
    
    public Jogo(Jogador jogadorBranco ,Jogador jogadorPreto) {
        this.jogador.add(jogadorBranco);
        this.jogador.add(jogadorPreto);
        
    }
    public Jogador getJogador(int indice) {
        return jogador.get(indice);
    }
    public void setJogador(Jogador jogador) {
        this.jogador.add(jogador);
    }
}
