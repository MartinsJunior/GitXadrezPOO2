/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.edu.br.gitxadrezpoo2.bd.cgd;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import poo.xadrez.modelo.cdp.Casa;
import poo.xadrez.modelo.cdp.Jogo;
import poo.xadrez.modelo.cdp.JogoCompleto;
import poo.xadrez.modelo.cdp.Peca;
import poo.xadrez.modelo.cdp.Tabuleiro;
import poo.xadrez.rn.cgt.AplPrincipal;

/**
 *
 * @author Junior
 */
public class RegistraEmBancoDeDados {

    public void SalvaJogoCompleto(JogoCompleto jogoCompleto) {
       
        SalvaJogo(jogoCompleto);
        
            System.out.println(jogoCompleto.getJogo().getId());
        try {
            SalvaPecas(jogoCompleto.getTabuleiro(), jogoCompleto.getNomeJogo(),jogoCompleto.getJogo().getId());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistraEmBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegistraEmBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
    private void SalvaJogo(JogoCompleto jogoCompleto){
        JogoDAO jogoDAO = new JogoDAO();
        try {
            jogoDAO.criarTabela();
            jogoDAO.insert(jogoCompleto.getJogo(), jogoCompleto.getData(), jogoCompleto.getNomeJogo(),jogoCompleto.getVezJogador());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistraEmBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegistraEmBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void SalvaPecas(Tabuleiro tabuleiro, String nomeJogo,int idJogo) throws ClassNotFoundException, SQLException {
        PecaDAO pecaDAO = new PecaDAO();
        pecaDAO.criarTabela();
        for (int contadorLinha = 1; contadorLinha < 9; contadorLinha++) {
            for (int contadorColuna = 1; contadorColuna < 9; contadorColuna++) {
                Casa casa = tabuleiro.getCasa("" + contadorLinha + "" + contadorColuna);
                Peca pecaAtual = casa.getPeca();
                if (pecaAtual != null) {
                        pecaDAO.insert(pecaAtual, nomeJogo,idJogo);
                }
            }
        }

    }

}
