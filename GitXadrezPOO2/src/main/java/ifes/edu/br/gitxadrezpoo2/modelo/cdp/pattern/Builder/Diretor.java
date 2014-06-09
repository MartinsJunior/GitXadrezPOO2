/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.edu.br.gitxadrezpoo2.modelo.cdp.pattern.Builder;

import poo.xadrez.modelo.cdp.Tabuleiro;

/**
 *
 * @author Junior
 */
public class Diretor {

    public static Diretor getInstance() {
        return DiretorHolder.INSTANCE;
    }

    private static class DiretorHolder {

        private static final Diretor INSTANCE = new Diretor();
    }

    public Tabuleiro ConstroiTabuleiro() {
        BuilderTabuleiroNovo bu = new BuilderTabuleiroNovo();
        bu.AlocarCasa();
        bu.AlocarPeao();
        bu.AlocarTorre();
        bu.AlocarCavalo();
        bu.AlocarBispo();
        bu.AlocarRainha();
        bu.AlocarRei();
        return bu.CriarTabuleiro();
    }
}
