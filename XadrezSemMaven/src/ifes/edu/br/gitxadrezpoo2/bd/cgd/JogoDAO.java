/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.edu.br.gitxadrezpoo2.bd.cgd;

import ifes.edu.br.gitxadrezpoo2.modelo.cdp.pattern.Builder.BuilderTabuleiroVazio;
import ifes.edu.br.gitxadrezpoo2.modelo.cdp.pattern.Fabrica.FabricaPecas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import poo.xadrez.modelo.cdp.Casa;
import poo.xadrez.modelo.cdp.CorPeca;
import poo.xadrez.modelo.cdp.Jogador;
import poo.xadrez.modelo.cdp.Jogo;
import poo.xadrez.modelo.cdp.JogoCompleto;
import poo.xadrez.modelo.cdp.Posicao;
import poo.xadrez.modelo.cdp.Tabuleiro;
import poo.xadrez.modelo.cdp.TipoPeca;

/**
 *
 * @author
 */
public class JogoDAO extends DAOAbstract implements DAO<Jogo> {

    public void criarTabela() throws ClassNotFoundException, SQLException {
        this.openConnection();
        String sql = "CREATE TABLE IF NOT EXISTS JOGO ("
                + "Id INTEGER PRIMARY KEY   AUTOINCREMENT,"
                + "nomeJogo VARCHAR(20) NOT NULL,"
                + "NomeJogadorBranco VARCHAR(20) NOT NULL,"
                + "QuantidadeDePontosJogadorBranco INT NOT NULL,"
                + "NomeJogadorPreto VARCHAR(20) NOT NULL,"
                + "QuantidadeDePontosJogadorPreto INT NOT NULL,"
                + "DataPartida VARCHAR(20) NOT NULL,"
                + "VezJogador INT NOT NULL)";

        this.execute(sql);

        this.closeConnection();
    }

    public void insert(Jogo jogo, String data, String nomeJogo, int vezJogador) throws SQLException, ClassNotFoundException {

        this.openConnection();
        String sql = "INSERT INTO JOGO (nomeJogo,NomeJogadorBranco,QuantidadeDePontosJogadorBranco,NomeJogadorPreto,QuantidadeDePontosJogadorPreto, DataPartida,VezJogador) VALUES ("
                + "'" + nomeJogo + "'" + ","
                + "'" + jogo.getJogador(0).getNome() + "'" + ","
                + "'" + jogo.getJogador(0).getPontuacao() + "'" + ","
                + "'" + jogo.getJogador(1).getNome() + "'" + ","
                + "'" + jogo.getJogador(1).getPontuacao() + "'" + ","
                + "'" + data + "'," + vezJogador + ");";
        jogo.setId(this.executeUpdate(sql));

        this.closeConnection();
    }

    private void LimparPartida(int partida_Id) throws SQLException {

        this.openConnection();
        String sql = "DELETE FROM PARTIDA WHERE Id =" + partida_Id;
        statement = conexao.createStatement();
        statement.execute(sql);
        this.closeStatement();
        this.closeConnection();
    }

    public JogoCompleto recuperarJogo(int id) throws SQLException {
        try {
            //this.criarTabela();
            this.openConnection();
        } catch (SQLException ex) {
            Logger.getLogger(JogoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "SELECT * FROM JOGO WHERE Id = " + "'" + id + "'" + ";";
        ResultSet r = executeQuery(sql);

        Jogo jogo = new Jogo();
        int vezJogador = 0;
        String data = null;
        while (r.next()) {
            Jogador jogadorBranco = new Jogador(r.getString("NomeJogadorBranco"), CorPeca.BRANCO);
            Jogador jogadorPreto = new Jogador(r.getString("NomeJogadorPreto"), CorPeca.PRETO);
            vezJogador = r.getInt("vezJogador");
            data = r.getString("DataPartida");
            jogo.setJogador(jogadorBranco);
            jogo.setJogador(jogadorPreto);
        }

        sql = "SELECT * FROM PECA WHERE Jogo_Id = " + "'" + id + "'" + ";";
        r = executeQuery(sql);
        BuilderTabuleiroVazio builderTabuleiroVazio = new BuilderTabuleiroVazio();
        Tabuleiro tabuleiro = builderTabuleiroVazio.returnaTabuleiroVazio();
        Posicao posicao = null;
        while (r.next()) {
            System.out.println(r.getString("NomePeca"));
            posicao = new Posicao(r.getInt("Linha"), r.getInt("Coluna"));
            tabuleiro.getCasa(posicao).setPeca(FabricaPecas.getInstance().retornaPeca(TipoPeca.valueOf(r.getString("NomePeca")), r.getInt("Linha"), r.getInt("Coluna"), CorPeca.valueOf(r.getString("Cor"))));
        }
        JogoCompleto jogoCompleto = new JogoCompleto(tabuleiro, jogo, null, vezJogador, data);
        this.closeStatement();
        this.closeConnection();
        return jogoCompleto;
    }

    public ArrayList<Jogo> recuperarJogo() throws SQLException {

        ArrayList<Jogo> jogos = new ArrayList<Jogo>();

        try {
            //this.criarTabela();
            this.openConnection();
        } catch (SQLException ex) {
            Logger.getLogger(JogoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "SELECT * FROM JOGO;";
        ResultSet r = executeQuery(sql);

        while (r.next()) {
            Jogo jogo = new Jogo();
            int vezJogador = 0;
            String data = null;
            Jogador jogadorBranco = new Jogador(r.getString("NomeJogadorBranco"), CorPeca.BRANCO);
            Jogador jogadorPreto = new Jogador(r.getString("NomeJogadorPreto"), CorPeca.PRETO);
            vezJogador = r.getInt("vezJogador");
            data = r.getString("DataPartida");
            jogo.setId(r.getInt("Id"));
            jogo.setnomeJogo(r.getString("nomeJogo"));
            jogo.setData(data);
            jogo.setJogador(jogadorBranco);
            jogo.setJogador(jogadorPreto);
            jogos.add(jogo);
        }

        this.closeStatement();
        this.closeConnection();
        return jogos;
    }

    @Override
    public Jogo salvar(Jogo obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Jogo obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Jogo> obter(Class<Jogo> classe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
