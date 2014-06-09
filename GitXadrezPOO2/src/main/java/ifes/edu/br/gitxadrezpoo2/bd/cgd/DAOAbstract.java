/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.edu.br.gitxadrezpoo2.bd.cgd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public abstract class DAOAbstract {

    protected Connection conexao;
    protected Statement statement;

    protected void openConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR: failed to load Sqlite JDBC driver.");
            e.printStackTrace();
            return;
        }
        this.conexao = DriverManager.getConnection("jdbc:sqlite:xadrezpoo2.db");
        if (this.conexao == null) {
            System.out.println("Problema ao abrir conexao");
        }
    }

    protected void execute(String query) throws SQLException {
        this.statement = conexao.createStatement();
        // Comando para criar
        statement.execute(query);
        statement.close();
    }

    protected ResultSet executeQuery(String query) throws SQLException {
        this.statement = conexao.createStatement();
        ResultSet rs = statement.executeQuery(query);
        return rs;
    }

    protected void closeStatement() throws SQLException {
        statement.close();
    }

    protected int executeUpdate(String query) throws SQLException {
        this.statement = conexao.createStatement();		
            int numero = 0;
		// Comando para update, insert e delete		
            statement.executeUpdate(query);		
            ResultSet rs = statement.getGeneratedKeys();		
            if (rs.next())
            {
                numero = rs.getInt(1);
            }
            statement.close();
            return numero;
    }

    protected void closeConnection() throws SQLException {
        conexao.close();
    }

}
