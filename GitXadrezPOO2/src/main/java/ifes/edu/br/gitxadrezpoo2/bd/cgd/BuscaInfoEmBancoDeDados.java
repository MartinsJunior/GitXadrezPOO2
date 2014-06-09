/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.edu.br.gitxadrezpoo2.bd.cgd;

import ifes.edu.br.gitxadrezpoo2.rn.cgt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import poo.xadrez.modelo.cdp.Jogo;
import poo.xadrez.modelo.cdp.JogoCompleto;

/**
 *
 * @author 20102bsi0138
 */
public class BuscaInfoEmBancoDeDados {

    JogoDAO jogoDAO = new JogoDAO();

    public ArrayList<Jogo> buscaJogos() {

        try {
            return jogoDAO.recuperarJogo();
        } catch (SQLException ex) {
            Logger.getLogger(BuscaInfoEmBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public JogoCompleto recuperaPartida(int id) {
        try {
            return jogoDAO.recuperarJogo(id);
        } catch (SQLException ex) {
            Logger.getLogger(BuscaInfoEmBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean deletaJogo(String nomeJogoAtual) {
//        System.out.println(nomeJogoAtual);
//       
//        return ctrlRegistro.deletaJogo(nomeJogoAtual);;
        return true;
    }

}
