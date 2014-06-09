/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.edu.br.gitxadrezpoo2.bd.cgd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import poo.xadrez.modelo.cdp.Peca;

/**
 *
 * @author HYGO-HP
 */
public class PecaDAO extends DAOAbstract implements DAO<Peca> {

    public void criarTabela() throws ClassNotFoundException, SQLException {
        this.openConnection();
        String sql = "CREATE TABLE IF NOT EXISTS PECA ("
                + "Id INTEGER PRIMARY KEY   AUTOINCREMENT,"
                + "NomePeca VARCHAR (8) NOT NULL,"
                + "Linha INT NOT NULL,"
                + "Coluna INT NOT NULL,"
                + "JaMovimentou INT NOT NULL,"
                + "Cor VARCHAR(8) NOT NULL,"
                + "NomePartida VARCHAR (8) NOT NULL,"
                + "Jogo_Id INT NOT NULL"
                + /*"FOREIGN KEY(Jogo_Id) REFERENCES JOGO(Id)*/ ");";

        this.execute(sql);

        this.closeConnection();
    }

    public void insert(Peca peca, String NomeJogo, int idJogo) throws SQLException, ClassNotFoundException {
        this.openConnection();

        String sql = "INSERT INTO PECA (NomePeca,Linha,Coluna,JaMovimentou,Cor,NomePartida,Jogo_Id) VALUES ("
                + "'" + peca.getTipoPeca() + "'" + ","
                + peca.getPosicao().getLinha() + ","
                + peca.getPosicao().getColuna() + ","
                + peca.getJaMovimentou() + ","
                + "'" + peca.getCor() + "',"
                + "'" + NomeJogo + "',"
                + idJogo + ");";
        this.executeUpdate(sql);

        this.closeConnection();
    }

    private void LimparPecas(int partida_Id) throws SQLException {

        this.openConnection();
        String sql = "DELETE FROM PECA WHERE Partida_Id =" + partida_Id;
        statement = conexao.createStatement();
        statement.execute(sql);
        this.closeStatement();
        this.closeConnection();
    }

    public ArrayList<Peca> restaurarPeca(int partida) throws SQLException {
        this.openConnection();
        ArrayList<Peca> pecas = new ArrayList<Peca>();

        this.openConnection();

        String sql = "SELECT * FROM PECA WHERE Partida_Id =" + partida;
        ResultSet r = this.executeQuery(sql);
        while (r.next()) {
//           Peca unica = new UnicaPeca();
//           unica.setLinha(r.getInt("Linha"));
//           unica.setColuna(r.getInt("Coluna"));
//           unica.setNome(r.getString("Nome"));
//           unica.setValue(r.getInt("Valor"));
//           unica.setCapturada(r.getString("Estado_Peca"));
//           if(r.getString("Color").equals("PRETO"))
//           {
//               unica.setColor(Color.PRETO);
//           }
//           else
//           {
//               unica.setColor(Color.BRANCO);
//           }
//           //unica.setColor(rs.getString("Color"));
//           pecas.add(unica);
        }
        this.closeStatement();
        this.closeConnection();
        this.LimparPecas(partida);
        return pecas;

    }

    public Peca salvar(Peca obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean excluir(Peca obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Peca> obter(Class<Peca> classe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
