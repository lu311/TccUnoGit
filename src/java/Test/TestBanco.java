/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Actions.GrupoSQL;
import Actions.UsuarioSQL;
import Beans.GrupoBean;
import Beans.UsuarioConsultaBean;
import DataBases.MysqlCommand;
import DataBases.MysqlConnect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lu311
 */
public class TestBanco {

    static public void main(String args[]) {
        System.out.println("---- MysqlConnect ----");
        MysqlConnect banco = new MysqlConnect();
        banco.abir();
        System.out.println(banco.getCon().toString());
        System.out.println(banco.getTransactionNumber());
        banco.fechar();

        System.out.println("---- MysqlCommand ----");
        MysqlCommand command = new MysqlCommand();
        ResultSet rs = command.select("select * from usuarios");
        try {
            while (rs.next()) {
                System.out.println(rs.getInt("pk_usuario"));
                System.out.println(rs.getString("nome_usuario"));
                System.out.println(rs.getString("email"));
                System.out.println(rs.getBoolean("ms_ativo"));
                System.out.println(rs.getString("data_hora"));

                rs.next();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        command.fecharComando();

        System.out.println("---- UsuarioSQL ----");
        UsuarioSQL us = new UsuarioSQL();
        List<UsuarioConsultaBean> lista = us.usuarioConsulta();

        for (UsuarioConsultaBean p : lista) {
            System.out.println(p.getPk_usuario());
            System.out.println(p.getNome_usuario());
            System.out.println(p.getEmail());
            System.out.println(p.isMs_ativo());
            System.out.println(p.getData_hora());
        }

        System.out.println("---- grupoSQL ----");
        GrupoSQL gs = new GrupoSQL();
        List<GrupoBean> listag = gs.grupoConsulta();

        for (GrupoBean p : listag) {
            System.out.println(p.getPk_grupo());
            System.out.println(p.getNome_grupo());
            System.out.println(p.isMs_ativo());
            System.out.println(p.getData_hora());
        }
    }
}
