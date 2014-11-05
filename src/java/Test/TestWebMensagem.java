/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Actions.GrupoUsuarioSQL;
import Actions.WebMensagemSQL;
import Beans.GrupoUsuariosConsultaBean;
import DataBases.MysqlCommand;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lu311
 */
public class TestWebMensagem {

    static public void main(String args[]) {
        System.out.println("---- Mensagem ----");
        MysqlCommand com = new MysqlCommand();
        WebMensagemSQL sql = new WebMensagemSQL();

        System.out.println("---- Mensagem Grupo insert ----");
        boolean x;

        x = com.insert(sql.incluirMensagemGrupo(1, 1, "mensagem grupo de teste nº " + Math.random()));
        System.out.println(x);
        x = com.insert(sql.incluirMensagemGrupo(1, 2, "mensagem grupo de teste nº " + Math.random()));
        System.out.println(x);
        x = com.insert(sql.incluirMensagemGrupo(25, 4, "mensagem grupo de teste nº " + Math.random()));
        System.out.println(x);
        x = com.insert(sql.incluirMensagemGrupo(26, 5, "mensagem grupo de teste nº " + Math.random()));
        System.out.println(x);
        x = com.insert(sql.incluirMensagemGrupo(27, 7, "mensagem grupo de teste nº " + Math.random()));
        System.out.println(x);
        x = com.insert(sql.incluirMensagemGrupo(28, 8, "mensagem grupo de teste nº " + Math.random()));
        System.out.println(x);

        System.out.println("---- Mensagem Usuario insert ----");

        x = com.insert(sql.incluirMensagemUsuario(11, 3, "mensagem usuario de teste nº " + Math.random()));
        System.out.println(x);
        x = com.insert(sql.incluirMensagemUsuario(12, 8, "mensagem usuario de teste nº " + Math.random()));
        System.out.println(x);
        x = com.insert(sql.incluirMensagemUsuario(13, 8, "mensagem usuario de teste nº " + Math.random()));
        System.out.println(x);
        x = com.insert(sql.incluirMensagemUsuario(14, 10, "mensagem usuario de teste nº " + Math.random()));
        System.out.println(x);
        x = com.insert(sql.incluirMensagemUsuario(15, 7, "mensagem usuario de teste nº " + Math.random()));
        System.out.println(x);
        x = com.insert(sql.incluirMensagemUsuario(16, 9, "mensagem usuario de teste nº " + Math.random()));
        System.out.println(x);

        com.fecharComando();
    }
}
