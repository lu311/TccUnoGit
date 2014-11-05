/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBases;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe que execulta os comando sql, extends classe MysqlConnect que faz a conecxção com o banco
 * @author Lu311
 */
public class MysqlCommand extends MysqlConnect {

    private ResultSet rs;
    private Statement st;

    public MysqlCommand() {
        rs = null;
        abir();
    }

    public void fecharComando() {
        fechar();
    }

    public void comitComando() {
        comitTransaction();
    }

    public void rollbackComando() {
        rollbackTransaction();
    }

    /**
     * @param ps
     * @return
     * @recebe comando sql select e retorna ResultSet
     */
    public ResultSet select(PreparedStatement ps) {
        try {
            rs = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Erro ao executa select");
            System.out.println("\n" + e.getStackTrace());
        }
        return rs;
    }

    /**
     * @param s
     * @return
     * @recebe comando sql select e retorna ResultSet
     */
    public ResultSet select(String s) {
        try {
            rs = getCon().createStatement().executeQuery(s);
        } catch (SQLException e) {
            System.out.println("Erro ao executa select");
            System.out.println("\n" + e.getStackTrace());
        }
        return rs;
    }

    /**
     * executa um comando SQL do tipo insert, uptade, delete usando
     * PreparedStatement
     *
     * @param ps
     * @return
     */
    public boolean insert(PreparedStatement ps) {
        boolean r = false;
        try {
            r = ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao executa comando SQL");
            System.out.println("\n" + e.getStackTrace());
        }
        return r;
    }

    /**
     * executa um comando SQL do tipo insert, uptade, delete usando
     * String/Statement
     *
     * @param ps
     * @return
     */
    public boolean insert(String ps) {
        boolean r = false;
        try {
            getCon().createStatement().execute(ps);
            r = true;
        } catch (SQLException e) {
            System.out.println("Erro ao executa comando SQL \n"+e.getMessage());
        }
        return r;
    }

}
