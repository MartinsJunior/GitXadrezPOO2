/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.edu.br.gitxadrezpoo2.application;

import ifes.edu.br.gitxadrezpoo2.bd.cgd.JogoDAO;
import ifes.edu.br.gitxadrezpoo2.bd.cgd.PecaDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import poo.xadrez.cci.Xadrez;
import poo.xadrez.modelo.cdp.CorPeca;
import poo.xadrez.modelo.cdp.Peca;
import poo.xadrez.modelo.cdp.Posicao;
import poo.xadrez.modelo.cdp.TipoPeca;
import poo.xadrez.modelo.cdp.movimento.AndarPeao;
import ifes.edu.br.gitxadrezpoo2.modelo.cdp.pattern.Builder.BuilderTabuleiroNovo;
import ifes.edu.br.gitxadrezpoo2.modelo.cdp.pattern.Builder.Diretor;
import ifes.edu.br.gitxadrezpoo2.modelo.cdp.pattern.Fabrica.FabricaPecas;
import ifes.edu.br.gitxadrezpoo2.modelo.cdp.pattern.Fabrica.FabricaPrimitiva;

/**
 *
 * @author Junior
 */
public class App {

    public static void main(String[] args) {
        
        Peca peca = FabricaPecas.getInstance().retornaPeca(TipoPeca.CAVALO,2,2, CorPeca.BRANCO);
//        System.out.println(peca.getTipoPeca());
//        System.out.println(peca.getCor());
//        System.out.println(peca.getValorEmPontos());
//        JogoDAO jogoDAO = new JogoDAO();
//        try {
//            jogoDAO.recuperarJogo("agora");
//        } catch (SQLException ex) {
//            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
        Xadrez.run();
    }

}
