/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBases;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe tem a funcção de estabece uma conexão com o banco de dados
 *
 * @author Lu311
 */
public class MysqlConnect {

    private static final String ipServidor = "localhost";
    private static final String portaServidor = "3306";
    private static final String nomeBanco = "tcc_unopar"; // jdbc:mysql://localhost:3306/tcc_unopar
    final String driver = "com.mysql.jdbc.Driver";
    final String url = "jdbc:mysql://" + ipServidor + ":" + portaServidor + "/" + nomeBanco;
    final String usuario = "root";
    final String senha = "";
    //-------------------------------------------------------
    private Connection con;
    private Statement stmt;
    private PreparedStatement pstmt;
    public int transactionNumber;

    /*
     private static final String ipServidor = "localhost";
     private static final String portaServidor = "3306";
     private static final String nomeBanco = "tcc_unopar"
     */
    /**
     * faz os set para estabelece conexão com banco
     */
    public void abir() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, senha);
            stmt = (Statement) con.createStatement();
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao carregar o drive");
            System.out.println("\n" + e.getStackTrace().toString());
        } catch (SQLException e) {
            System.out.println("Erro ao tentar estabelecer uma conexão com o banco de dados");
            System.out.println("\n" + e.getMessage());
        }
    }

    /**
     * fecha o banco
     */
    public void fechar() {
        try {
            if (getStmt() != null) {
                getStmt().close();
            }
            if (pstmt != null) {
                pstmt.close();
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao tentar fechar a conexão com o banco de dados");
            System.out.println("\n" + e.getStackTrace());
        }
    }

    /**
     * @return, retorna numero da Transaction
     */
    public int getTransactionNumber() {
        return this.transactionNumber;
    }

    /**
     * faz efetivação dos dados manipulado pela conecxão
     */
    public void comitTransaction() {
        try {
            con.commit();
        } catch (SQLException e) {
            System.out.println("Erro ao fazer comitTransaction");
            System.out.println("\n" + e.getStackTrace());
        }
    }

    /**
     * cancela as alerações dos dados manipulado pela conecxão
     */
    public void rollbackTransaction() {
        try {
            con.rollback();
        } catch (SQLException e) {
            System.out.println("Erro ao fazer rollbackTransaction");
            System.out.println("\n" + e.getStackTrace());
        }
    }

    /**
     * @return the con, retorna a string da conexão
     */
    public Connection getCon() {
        return con;
    }

    /**
     * @return the stmt
     */
    public Statement getStmt() {
        return stmt;
    }

}
